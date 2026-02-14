package com.seig.backend.pojo.dto;

public class GenerateQuarantineRequestDto {
    private Integer warehouseId; // 仓库ID
    private Integer skuId;       // SKU ID
    private Integer quantity;    // 批次总数量


    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
