package com.seig.backend.procurement.mapper;

import com.seig.backend.procurement.entity.PurchaseOrder;
import com.seig.backend.procurement.entity.PurchaseOrderItem;
import com.seig.backend.pojo.dto.PurchaseOrderDetailDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PurchaseOrderMapper {

    /**
     * 插入采购订单   1:n
     */
    int insertOrder(PurchaseOrder order);

    /**
     * 插入采购订单项  1:n
     */
    int insertOrderItem(PurchaseOrderItem item);

    /**
     * 根据订单ID查询订单基本信息
     *
     * @param orderId 订单ID
     * @return 订单信息
     */
    PurchaseOrder selectOrderById(Long orderId);

    /**
     * 根据订单ID查询订单项列表
     *
     * @param orderId 订单ID
     * @return 订单项列表
     */
    List<PurchaseOrderItem> selectItemsByOrderId(Long orderId);

    /**
     * 查询所有订单基本信息
     *
     * @return 订单列表
     */
    List<PurchaseOrder> selectAllOrders();

    /**
     * 查询所有订单详情（包含订单项）
     *
     * @return 订单详情DTO列表
     */
    List<PurchaseOrderDetailDto> selectAllOrdersWithItems();

    /**
     * 根据订单ID删除订单项
     *
     * @param orderId 订单ID
     * @return 删除的记录数
     */
    int deleteItemsByOrderId(Long orderId);

    /**
     * 根据订单ID删除订单
     *
     * @param orderId 订单ID
     * @return 删除的记录数
     */
    int deleteOrderById(Long orderId);

    /**
     * 更新订单状态
     *
     * @param order 订单信息
     * @return 更新的记录数
     */
    int updateOrderStatus(PurchaseOrder order);

}
