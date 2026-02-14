package com.seig.backend.service.impl;

import com.seig.backend.entity.MedicineSku;
import com.seig.backend.entity.record.PurchaseOrder;
import com.seig.backend.entity.record.PurchaseOrderItem;
import com.seig.backend.entity.storage.QuarantineInventory;
import com.seig.backend.mapper.*;
import com.seig.backend.pojo.dto.GenerateQuarantineRequestDto;
import com.seig.backend.pojo.dto.PurchaseOrderDetailDto;
import com.seig.backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;

    @Autowired
    private PurchaseArrivalService purchaseArrivalService;

    @Autowired
    private QuarantineBatchService quarantineBatchService;

    @Autowired
    private QuarantineInventoryService quarantineInventoryService;

    @Autowired
    private MedicineSkuService medicineSkuService;

    @Autowired
    private MedicineSkuMapper medicineSkuMapper;

    @Autowired
    private WarehouseZoneMapper warehouseZoneMapper;

    @Autowired
    private WarehouseContainerMapper warehouseContainerMapper;

    @Autowired
    private StorageLocationMapper storageLocationMapper;

    @Autowired
    private QuarantineInventoryMapper quarantineInventoryMapper;



    @Override
    public PurchaseOrder createPurchaseOrder(PurchaseOrder order, List<PurchaseOrderItem> items) {
        try {
            // 自动生成订单编号orderNo
            if (order.getOrderNo() == null || order.getOrderNo().isEmpty()) {
                order.setOrderNo(generateOrderNo());
            }
            // 设置订单基础信息
            order.setCreatedAt(LocalDateTime.now());
            order.setUpdatedAt(LocalDateTime.now());
            order.setStatus((byte) 0); // 0表示待审核状态
            // 计算并设置金额
            java.math.BigDecimal totalAmount = calculateTotalAmount(items);
            order.setTotalAmount(totalAmount);
            // 设置应付金额 - 如果未设置则使用总金额
            if (order.getPayableAmount() == null) {
                order.setPayableAmount(totalAmount);
            }

            // 插入采购订单主表
            int orderResult = purchaseOrderMapper.insertOrder(order);
            if (orderResult <= 0) {
                throw new RuntimeException("插入采购订单主表失败");
            }

            // 批量插入采购订单项
            for (PurchaseOrderItem item : items) {
                item.setOrderId(order.getOrderId());
                item.setCreatedAt(LocalDateTime.now());
                item.setUpdatedAt(LocalDateTime.now());

                // 根据药品ID和供应商ID获取对应的SKU ID  不能唯一确定，直接由前端传输skuid
                // 可以通过MedicineSkuService获取
                // item.setSkuId(getSkuIdByDrugAndSupplier(item.getDrugId(), order.getSupplierId()));
//                item.setSkuId(item.getSkuId());
                int itemResult = purchaseOrderMapper.insertOrderItem(item);
                if (itemResult <= 0) {
                    throw new RuntimeException("插入采购订单项失败，药品ID: " + item.getDrugId());
                }
            }

            return order;
        } catch (Exception e) {
            throw new RuntimeException("创建采购订单失败: " + e.getMessage());
        }
    }

    @Override
    public PurchaseOrderDetailDto getOrderDetail(Long orderId) {
        // 查询订单基本信息
        PurchaseOrder order = purchaseOrderMapper.selectOrderById(orderId);
        if (order == null) {
            return null;
        }

        // 查询订单项列表
        List<PurchaseOrderItem> items = purchaseOrderMapper.selectItemsByOrderId(orderId);

        // 封装为DTO
        return new PurchaseOrderDetailDto(order, items);
    }

    @Override
    public List<PurchaseOrderDetailDto> getAllOrdersWithItems() {
        // 查询所有订单基本信息
        List<PurchaseOrder> orders = purchaseOrderMapper.selectAllOrders();

        // 为每个订单查询其订单项
        for (PurchaseOrder order : orders) {
            List<PurchaseOrderItem> items = purchaseOrderMapper.selectItemsByOrderId(order.getOrderId());
            // 注意：这里我们只是构建DTO对象，实际应用中可以考虑批量查询优化性能
        }

        // 构建返回结果
        return purchaseOrderMapper.selectAllOrdersWithItems();
    }

    @Override
    @Transactional
    public boolean deleteOrder(Long orderId) {
        // 先删除订单项
        int deletedItems = purchaseOrderMapper.deleteItemsByOrderId(orderId);

        // 再删除订单主表记录
        int deletedOrder = purchaseOrderMapper.deleteOrderById(orderId);

        return deletedOrder > 0;
    }

    @Override
    public List<String> updateOrderStatusAndGenerateArrival(Long orderId, Byte newStatus) {
        System.out.println("还没写");
        return List.of();
    }


    /**
     * 计算订单总金额
     */
    private java.math.BigDecimal calculateTotalAmount(List<PurchaseOrderItem> items) {
        java.math.BigDecimal total = java.math.BigDecimal.ZERO;
        for (PurchaseOrderItem item : items) {
            java.math.BigDecimal amount = item.getUnitPrice().multiply(
                    java.math.BigDecimal.valueOf(item.getPurchaseQuantity()));
            total = total.add(amount);
        }
        return total;
    }

    // 订单编号生成
    private String generateOrderNo() {
        // 生成订单号：CG + 日期 + 流水号
        String dateStr = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String sequence = String.format("%04d", System.currentTimeMillis() % 10000);
        return "CG" + dateStr + sequence;
    }
    @Transactional
    @Override
    public List<String> updateOrderStatusAndGenerateArrival(Long orderId, Byte newStatus, GenerateQuarantineRequestDto requestDto) {
        // 1. 查询 MedicineSku 信息
        MedicineSku medicineSku = medicineSkuMapper.selectById(requestDto.getSkuId());
        if (medicineSku == null) {
            throw new RuntimeException("未找到对应的药品SKU信息");
        }

        // 2. 根据 warehouseId 和温度范围查找符合条件的 warehouse_zone
        List<Integer> zoneIds = warehouseZoneMapper.selectByTemperatureRange(
                requestDto.getWarehouseId(),
                medicineSku.getMinTemperature(),
                medicineSku.getMaxTemperature());

        // 3. 根据 zoneIds，冷藏/麻精 查找符合条件的 warehouse_container
        List<Integer> containerIds = warehouseContainerMapper.selectByConditions(
                zoneIds,
                medicineSku.getRefrigerated(),
                medicineSku.getSpecialDrug());

        System.out.println(containerIds);
        System.out.println("上面是containerIds，下面是locationIds");
        // 4. 根据 containerIds 查找空闲的 storage_location
        List<Integer> locationIds = storageLocationMapper.selectEmptyLocations(containerIds);

        System.out.println(locationIds);
        // 5. 分配库存明细
        List<QuarantineInventory> inventoryList = new ArrayList<>();
        int remainingQuantity = requestDto.getQuantity();
        for (Integer locationId : locationIds) {
            if (remainingQuantity <= 0) break;

            int assignQuantity = Math.min(10, remainingQuantity); // 每个货位最多分配10个单位
            QuarantineInventory inventory = new QuarantineInventory();
            inventory.setLocationId(locationId);
            inventory.setQuantity(BigDecimal.valueOf(assignQuantity));
            inventory.setSkuId(requestDto.getSkuId());
//            inventory.setTemperatureZone(medicineSku.getTemperatureZone());
//            inventory.setHumidityCondition(medicineSku.getHumidityCondition());
            inventoryList.add(inventory);

            remainingQuantity -= assignQuantity;
        }

        // 批量插入
        quarantineInventoryMapper.batchInsert(inventoryList);

        // 返回生成的到货记录ID列表（假设每条记录有一个唯一标识）
        return inventoryList.stream()
                .map(inv -> "ARRIVAL_" + inv.getDetailId())
                .collect(Collectors.toList());
    }


}
