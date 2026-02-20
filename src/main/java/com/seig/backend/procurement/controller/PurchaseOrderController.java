package com.seig.backend.procurement.controller;

import com.seig.backend.common.Result;
import com.seig.backend.procurement.entity.PurchaseOrder;
import com.seig.backend.procurement.entity.PurchaseOrderItem;
import com.seig.backend.pojo.dto.GenerateQuarantineRequestDto;
import com.seig.backend.pojo.dto.PurchaseOrderDetailDto;
import com.seig.backend.procurement.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchaseOrders")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    /**
     * 创建采购订单
     */
    @PostMapping("/create")
    public Result<PurchaseOrder> createPurchaseOrder(@RequestBody PurchaseOrderDetailDto purchaseOrderDetailDto) {
        try {
            PurchaseOrder createdOrder = purchaseOrderService.createPurchaseOrder(purchaseOrderDetailDto.getOrder(),
                    purchaseOrderDetailDto.getItems());
            if (createdOrder != null) {
                return Result.success("采购订单创建成功", createdOrder);
            } else {
                for (PurchaseOrderItem item : purchaseOrderDetailDto.getItems()) {
                    System.out.println(item);
                }
                return Result.error(500, "采购订单创建失败", null);
            }
        } catch (Exception e) {
            for (PurchaseOrderItem item : purchaseOrderDetailDto.getItems()) {
                System.out.println(item.getCreatedAt());
            }
            System.out.println(purchaseOrderDetailDto.getOrder());


            return Result.error(500, "创建订单异常：" + e.getMessage(), null);
        }
    }

    /**
     * 查询订单详情（包含订单基本信息和订单项列表）
     *
     * @param orderId 订单ID
     * @return 订单详情DTO
     */
    @GetMapping("/{orderId}")
    public Result<PurchaseOrderDetailDto> getOrderDetail(@PathVariable Long orderId) {
        try {
            PurchaseOrderDetailDto orderDetail = purchaseOrderService.getOrderDetail(orderId);
            if (orderDetail != null) {
                return Result.success("查询成功", orderDetail);
            } else {
                return Result.error(404, "订单不存在", null);
            }
        } catch (Exception e) {
            return Result.error(500, "查询订单详情失败：" + e.getMessage(), null);
        }
    }

    /**
     * 查询所有订单（包含订单项列表）
     *
     * @return 订单详情DTO列表
     */
    @GetMapping("/all")
    public Result<List<PurchaseOrderDetailDto>> getAllOrdersWithItems() {
        try {
            List<PurchaseOrderDetailDto> orders = purchaseOrderService.getAllOrdersWithItems();
            return Result.success("查询成功", orders);
        } catch (Exception e) {
            return Result.error(500, "查询订单列表失败：" + e.getMessage(), null);
        }
    }

    /**
     * 删除订单（同时删除订单项）
     *
     * @param orderId 订单ID
     * @return 删除结果
     */
    @DeleteMapping("/{orderId}")
    public Result<Void> deleteOrder(@PathVariable Long orderId) {
        try {
            boolean success = purchaseOrderService.deleteOrder(orderId);
            if (success) {
                return Result.success("订单删除成功");
            } else {
                return Result.error("订单不存在，无法删除");
            }
        } catch (Exception e) {
            return Result.error(500, "删除订单失败：" + e.getMessage(), null);
        }
    }

    /**
     * 更新采购订单状态并生成到货记录
     */
    @PostMapping("/updateStatusAndGenerateArrival/{orderId}")
    public Result<List<String>> updateOrderStatusAndGenerateArrival(
            @PathVariable Long orderId,
            @RequestParam Byte newStatus,
            @RequestBody GenerateQuarantineRequestDto requestDto) {
        try {
            List<String> result = purchaseOrderService.updateOrderStatusAndGenerateArrival(orderId, newStatus, requestDto);
            return Result.success("操作成功", result);
        } catch (Exception e) {
            return Result.error(500, "操作失败：" + e.getMessage(), null);
        }
    }


}
