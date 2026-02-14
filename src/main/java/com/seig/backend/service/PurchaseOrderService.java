package com.seig.backend.service;

import com.seig.backend.entity.record.PurchaseOrder;
import com.seig.backend.entity.record.PurchaseOrderItem;
import com.seig.backend.pojo.dto.GenerateQuarantineRequestDto;
import com.seig.backend.pojo.dto.PurchaseOrderDetailDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PurchaseOrderService {
    /**
     * 创建采购订单
     */
    PurchaseOrder createPurchaseOrder(PurchaseOrder order, List<PurchaseOrderItem> items);

    /**
     * 获取订单详情（包含订单基本信息和订单项列表）
     *
     * @param orderId 订单ID
     * @return 订单详情DTO
     */
    PurchaseOrderDetailDto getOrderDetail(Long orderId);

    /**
     * 获取所有订单（包含订单项列表）
     *
     * @return 订单详情DTO列表
     */
    List<PurchaseOrderDetailDto> getAllOrdersWithItems();

    /**
     * 删除订单（同时删除订单项）
     *
     * @param orderId 订单ID
     * @return 删除是否成功
     */
    boolean deleteOrder(Long orderId);

    List<String> updateOrderStatusAndGenerateArrival(Long orderId, Byte newStatus);

    List<String> updateOrderStatusAndGenerateArrival(Long orderId, Byte newStatus, GenerateQuarantineRequestDto requestDto);
}
