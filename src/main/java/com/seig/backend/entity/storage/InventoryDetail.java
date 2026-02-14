package com.seig.backend.entity.storage;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 库存明细实体类
 * 记录每个批次在不同库位的具体数量
 */
public class InventoryDetail {
    /**
     * 明细ID，主键，同一批次在不同库位（具体到货位？）的具体数量
     */
    private Integer detailId;

    /**
     * 批次ID，外键关联inventory_batches
     */
    private Integer batchId;

    /**
     * 药品ID
     * 虽然同一批号确实对应同一种药品，但不同厂家、不同药品的批号可能重复
     */
    private String drugId;

    /**
     * 货位编号
     */
    private Integer locationId;

    /**
     * 数量
     */
    private BigDecimal quantity;

    /**
     * 可用数量
     */
    private BigDecimal availableQuantity;

    /**
     * 锁定数量
     */
    private BigDecimal lockedQuantity;

    /**
     * 是否主库位：0-否，1-是
     */
    private Boolean isPrimaryLocation;

    /**
     * 温区
     */
    private String temperatureZone;

    /**
     * 湿度条件
     */
    private String humidityCondition;

    /**
     * 光照条件
     */
    private String lightCondition;

    /**
     * 最后盘点日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate lastStocktakeDate;

    /**
     * 最后盘点数量
     */
    private BigDecimal lastStocktakeQuantity;

    /**
     * 盘点差异
     */
    private BigDecimal stocktakeDifference;

    /**
     * 库龄（天）
     */
    private Integer inventoryAge;

    /**
     * 最后移动日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime lastMoveDate;

    /**
     * 移动原因
     */
    private String moveReason;

    /**
     * 状态：1-正常，2-冻结，3-停用
     */
    private Integer status;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updatedAt;

    /**
     * 创建人
     */
    private Integer createdBy;

    /**
     * 更新人
     */
    private Integer updatedBy;

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(BigDecimal availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public BigDecimal getLockedQuantity() {
        return lockedQuantity;
    }

    public void setLockedQuantity(BigDecimal lockedQuantity) {
        this.lockedQuantity = lockedQuantity;
    }

    public Boolean getPrimaryLocation() {
        return isPrimaryLocation;
    }

    public void setPrimaryLocation(Boolean primaryLocation) {
        isPrimaryLocation = primaryLocation;
    }

    public String getTemperatureZone() {
        return temperatureZone;
    }

    public void setTemperatureZone(String temperatureZone) {
        this.temperatureZone = temperatureZone;
    }

    public String getHumidityCondition() {
        return humidityCondition;
    }

    public void setHumidityCondition(String humidityCondition) {
        this.humidityCondition = humidityCondition;
    }

    public String getLightCondition() {
        return lightCondition;
    }

    public void setLightCondition(String lightCondition) {
        this.lightCondition = lightCondition;
    }

    public LocalDate getLastStocktakeDate() {
        return lastStocktakeDate;
    }

    public void setLastStocktakeDate(LocalDate lastStocktakeDate) {
        this.lastStocktakeDate = lastStocktakeDate;
    }

    public BigDecimal getLastStocktakeQuantity() {
        return lastStocktakeQuantity;
    }

    public void setLastStocktakeQuantity(BigDecimal lastStocktakeQuantity) {
        this.lastStocktakeQuantity = lastStocktakeQuantity;
    }

    public BigDecimal getStocktakeDifference() {
        return stocktakeDifference;
    }

    public void setStocktakeDifference(BigDecimal stocktakeDifference) {
        this.stocktakeDifference = stocktakeDifference;
    }

    public Integer getInventoryAge() {
        return inventoryAge;
    }

    public void setInventoryAge(Integer inventoryAge) {
        this.inventoryAge = inventoryAge;
    }

    public LocalDateTime getLastMoveDate() {
        return lastMoveDate;
    }

    public void setLastMoveDate(LocalDateTime lastMoveDate) {
        this.lastMoveDate = lastMoveDate;
    }

    public String getMoveReason() {
        return moveReason;
    }

    public void setMoveReason(String moveReason) {
        this.moveReason = moveReason;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }
}
