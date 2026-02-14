package com.seig.backend.pojo.dto;

import com.seig.backend.entity.record.PurchaseOrder;
import com.seig.backend.entity.record.PurchaseOrderItem;

import java.util.List;

/**
 * 采购订单详情DTO，包含订单基本信息和订单项列表
 */
//@Data
public class PurchaseOrderDetailDto {
    /**
     * 订单基本信息
     */
    private PurchaseOrder order;

    /**
     * 订单项列表
     */
    private List<PurchaseOrderItem> items;

    public PurchaseOrderDetailDto(PurchaseOrder order, List<PurchaseOrderItem> items) {
        this.order = order;
        this.items = items;
    }

    public PurchaseOrderDetailDto() {}

    public PurchaseOrder getOrder() {
        return order;
    }

    public void setOrder(PurchaseOrder order) {
        this.order = order;
    }

    public List<PurchaseOrderItem> getItems() {
        return items;
    }

    public void setItems(List<PurchaseOrderItem> items) {
        this.items = items;
    }
}
