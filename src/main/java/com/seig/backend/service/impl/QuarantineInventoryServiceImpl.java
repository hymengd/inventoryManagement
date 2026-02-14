package com.seig.backend.service.impl;

import com.seig.backend.entity.MedicineSku;
import com.seig.backend.entity.storage.QuarantineInventory;
import com.seig.backend.mapper.*;
import com.seig.backend.service.QuarantineInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuarantineInventoryServiceImpl implements QuarantineInventoryService {

    @Autowired
    private QuarantineInventoryMapper quarantineInventoryMapper;

    @Autowired
    private MedicineSkuMapper medicineSkuMapper;

    @Autowired
    private WarehouseZoneMapper warehouseZoneMapper;

    @Autowired
    private WarehouseContainerMapper warehouseContainerMapper;

    @Autowired
    private StorageLocationMapper storageLocationMapper;

    @Override
    public QuarantineInventory createQuarantineInventory(QuarantineInventory quarantineInventory) {
        quarantineInventory.setCreatedAt(LocalDateTime.now());
        quarantineInventory.setUpdatedAt(LocalDateTime.now());
        int result = quarantineInventoryMapper.insert(quarantineInventory);
        if (result > 0) {
            return quarantineInventory;
        }
        return null;
    }
    @Override
    public List<QuarantineInventory> getQuarantineInventoryByQuarantineId(Integer quarantineId) {
        return quarantineInventoryMapper.selectByQuarantineId(quarantineId);
    }

    @Override
    public QuarantineInventory updateQuarantineInventory(QuarantineInventory quarantineInventory) {
        int result = quarantineInventoryMapper.update(quarantineInventory);
        return result > 0 ? quarantineInventory : null;
    }

    @Override
    public boolean deleteQuarantineInventory(Integer detailId) {
        return quarantineInventoryMapper.deleteById(detailId) > 0;
    }

    @Override
    public List<QuarantineInventory> generateAndAssignQuarantineInventory(
            Integer warehouseId, Integer skuId, Integer quantity) {
        // 1. 查询 MedicineSku 信息
        MedicineSku medicineSku = medicineSkuMapper.selectById(skuId);
        if (medicineSku == null) {
            throw new RuntimeException("未找到对应的药品SKU信息");
        }

        // 2. 查找符合温度条件的 warehouse_zone
        List<Integer> zoneIds = warehouseZoneMapper.selectByTemperatureRange(
                warehouseId, medicineSku.getMinTemperature(), medicineSku.getMaxTemperature());

        // 3. 查找符合条件的 warehouse_container
        List<Integer> containerIds = warehouseContainerMapper.selectByConditions(
                zoneIds, medicineSku.getRefrigerated(), medicineSku.getSpecialDrug());

        // 4. 查找空闲的 storage_location
        List<Integer> locationIds = storageLocationMapper.selectEmptyLocations(containerIds);

        // 5. 分配库存明细
        List<QuarantineInventory> inventoryList = new ArrayList<>();
        int remainingQuantity = quantity;
        for (Integer locationId : locationIds) {
            if (remainingQuantity <= 0) break;

            int assignQuantity = Math.min(10, remainingQuantity); // 每个货位最多分配10个单位
            QuarantineInventory inventory = new QuarantineInventory();
            inventory.setLocationId(locationId);
            inventory.setQuantity(BigDecimal.valueOf(assignQuantity));
            inventory.setSkuId(skuId);
//            inventory.setTemperatureZone(medicineSku.getTemperatureZone());
//            inventory.setHumidityCondition(medicineSku.getHumidityCondition());
            inventoryList.add(inventory);

            remainingQuantity -= assignQuantity;
        }

        // 批量插入
        quarantineInventoryMapper.batchInsert(inventoryList);
        return inventoryList;
    }
}

