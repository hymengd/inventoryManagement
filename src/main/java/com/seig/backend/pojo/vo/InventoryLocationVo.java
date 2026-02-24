package com.seig.backend.pojo.vo;


import lombok.Data;

import java.math.BigDecimal;

/**
 * 库存货位信息VO
 * 返回完整的货位编码信息
 */
public class InventoryLocationVo {
    
    /**
     * SKU ID
     */
    private Integer skuId;
    
    /**
     * 分配的数量
     */
    private BigDecimal allocatedQuantity;
    
    /**
     * 完整货位编码：仓库编码-库区编码-容器编码-货位编码
     */
    private String fullLocationCode;
    
    /**
     * 仓库编码
     */
    private String warehouseCode;
    
    /**
     * 库区编码
     */
    private String zoneCode;
    
    /**
     * 容器编码
     */
    private String containerCode;
    
    /**
     * 货位编码
     */
    private String locationCode;
    
    /**
     * 货位ID
     */
    private Integer locationId;
    
    /**
     * 批次ID
     */
    private Integer batchId;
    
    /**
     * 有效期
     */
    private String expiryDate;


    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public BigDecimal getAllocatedQuantity() {
        return allocatedQuantity;
    }

    public void setAllocatedQuantity(BigDecimal allocatedQuantity) {
        this.allocatedQuantity = allocatedQuantity;
    }

    public String getFullLocationCode() {
        return fullLocationCode;
    }

    public void setFullLocationCode(String fullLocationCode) {
        this.fullLocationCode = fullLocationCode;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }

    public String getContainerCode() {
        return containerCode;
    }

    public void setContainerCode(String containerCode) {
        this.containerCode = containerCode;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
}
