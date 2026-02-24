package com.seig.backend.storage.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 库存明细带货位信息的复合实体类
 */
public class InventoryDetailWithLocation {
    // InventoryDetail 字段
    private Integer detailId;
    private Integer batchId;
    private String drugId;
    private Integer locationId;
    private BigDecimal quantity;
    private BigDecimal availableQuantity;
    private BigDecimal lockedQuantity;
    private Boolean isPrimaryLocation;
    private String temperatureZone;
    private String humidityCondition;
    private String lightCondition;
    private LocalDate lastStocktakeDate;
    private BigDecimal lastStocktakeQuantity;
    private BigDecimal stocktakeDifference;
    private Integer inventoryAge;
    private LocalDateTime lastMoveDate;
    private String moveReason;
    private Integer status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer createdBy;
    private Integer updatedBy;

    // StorageLocation 字段
    private String locationCode;
    private Integer containerId;

    // Getters and Setters for InventoryDetail fields
    public Integer getDetailId() { return detailId; }
    public void setDetailId(Integer detailId) { this.detailId = detailId; }

    public Integer getBatchId() { return batchId; }
    public void setBatchId(Integer batchId) { this.batchId = batchId; }

    public String getDrugId() { return drugId; }
    public void setDrugId(String drugId) { this.drugId = drugId; }

    public Integer getLocationId() { return locationId; }
    public void setLocationId(Integer locationId) { this.locationId = locationId; }

    public BigDecimal getQuantity() { return quantity; }
    public void setQuantity(BigDecimal quantity) { this.quantity = quantity; }

    public BigDecimal getAvailableQuantity() { return availableQuantity; }
    public void setAvailableQuantity(BigDecimal availableQuantity) { this.availableQuantity = availableQuantity; }

    public BigDecimal getLockedQuantity() { return lockedQuantity; }
    public void setLockedQuantity(BigDecimal lockedQuantity) { this.lockedQuantity = lockedQuantity; }

    public Boolean getPrimaryLocation() { return isPrimaryLocation; }
    public void setPrimaryLocation(Boolean primaryLocation) { isPrimaryLocation = primaryLocation; }

    public String getTemperatureZone() { return temperatureZone; }
    public void setTemperatureZone(String temperatureZone) { this.temperatureZone = temperatureZone; }

    public String getHumidityCondition() { return humidityCondition; }
    public void setHumidityCondition(String humidityCondition) { this.humidityCondition = humidityCondition; }

    public String getLightCondition() { return lightCondition; }
    public void setLightCondition(String lightCondition) { this.lightCondition = lightCondition; }

    public LocalDate getLastStocktakeDate() { return lastStocktakeDate; }
    public void setLastStocktakeDate(LocalDate lastStocktakeDate) { this.lastStocktakeDate = lastStocktakeDate; }

    public BigDecimal getLastStocktakeQuantity() { return lastStocktakeQuantity; }
    public void setLastStocktakeQuantity(BigDecimal lastStocktakeQuantity) { this.lastStocktakeQuantity = lastStocktakeQuantity; }

    public BigDecimal getStocktakeDifference() { return stocktakeDifference; }
    public void setStocktakeDifference(BigDecimal stocktakeDifference) { this.stocktakeDifference = stocktakeDifference; }

    public Integer getInventoryAge() { return inventoryAge; }
    public void setInventoryAge(Integer inventoryAge) { this.inventoryAge = inventoryAge; }

    public LocalDateTime getLastMoveDate() { return lastMoveDate; }
    public void setLastMoveDate(LocalDateTime lastMoveDate) { this.lastMoveDate = lastMoveDate; }

    public String getMoveReason() { return moveReason; }
    public void setMoveReason(String moveReason) { this.moveReason = moveReason; }

    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public Integer getCreatedBy() { return createdBy; }
    public void setCreatedBy(Integer createdBy) { this.createdBy = createdBy; }

    public Integer getUpdatedBy() { return updatedBy; }
    public void setUpdatedBy(Integer updatedBy) { this.updatedBy = updatedBy; }

    // Getters and Setters for StorageLocation fields
    public String getLocationCode() { return locationCode; }
    public void setLocationCode(String locationCode) { this.locationCode = locationCode; }

    public Integer getContainerId() { return containerId; }
    public void setContainerId(Integer containerId) { this.containerId = containerId; }
}
