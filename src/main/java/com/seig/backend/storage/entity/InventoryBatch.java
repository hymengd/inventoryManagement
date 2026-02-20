package com.seig.backend.storage.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 库存批次实体类
 * 按批号管理库存
 */
public class InventoryBatch {
    /**
     * 批次ID，主键
     */
    private Integer batchId;

    /**
     * 生产批号
     */
    private String batchNumber;

    /**
     * SKU ID，外键关联medicine_skus
     */
    private Integer skuId;

    /**
     * 供应商ID，外键关联suppliers
     */
    private Integer supplierId;

    /**
     * 采购订单ID
     */
    private Integer purchaseOrderId;

    /**
     * 生产日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate productionDate;

    /**
     * 有效期至
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate expiryDate;

    /**
     * 制剂日期（中药饮片等---化学药通常没有这个日期/药材净选、切制、炮制完成日期）
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate manufactureDate;

    /**
     * 灭菌批号（无菌产品）
     */
    private String sterilizationBatch;

    /**
     * 验收日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate quarantineDate;

    /**
     * 验收人
     */
    private String quarantinePerson;

    /**
     * 验收结果：0-不合格，1-合格，2-待检
     */
    private Integer quarantineResult;

    /**
     * 拒收原因（不合格的原因）
     */
    private String rejectionReason;

    /**
     * 采购单价
     */
    private BigDecimal purchasePrice;

    /**
     * 成本单价（用于先进先出计价）
     */
    private BigDecimal costPrice;

    /**
     * 批次总数量（按最小单位--一箱不知几盒，一盒不知几片，所以统一用最小单位可知）
     */
    private BigDecimal totalQuantity;

    /**
     * 可用数量
     */
    private BigDecimal availableQuantity;

    /**
     * 锁定数量（已分配未出库）
     */
    private BigDecimal lockedQuantity;

    /**
     * 破损数量
     */
    private BigDecimal damagedQuantity;

    /**
     * 销毁数量
     */
    private BigDecimal destroyedQuantity;

    /**
     * 仓库ID
     */
    private Integer warehouseId;

    /**
     * 实际储存条件
     */
    private String storageCondition;

    /**
     * 温度记录
     */
    private String temperatureLog;

    /**
     * 质量状态：1-正常，2-待检，3-不合格，4-召回
     */
    private Integer qualityStatus;

    /**
     * 库存状态：1-在库，2-锁定，3-已出库，4-已销毁
     */
    private Integer inventoryStatus;

    /**
     * 首次入库日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate firstInDate;

    /**
     * 最后入库日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate lastInDate;

    /**
     * 最后出库日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate lastOutDate;

    /**
     * 最近盘点日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate stocktakeDate;

    /**
     * 盘点差异数量
     */
    private BigDecimal stocktakeDifference;

    /**
     * 备注
     */
    private String remark;

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

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(Integer purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public String getSterilizationBatch() {
        return sterilizationBatch;
    }

    public void setSterilizationBatch(String sterilizationBatch) {
        this.sterilizationBatch = sterilizationBatch;
    }

    public LocalDate getQuarantineDate() {
        return quarantineDate;
    }

    public void setQuarantineDate(LocalDate quarantineDate) {
        this.quarantineDate = quarantineDate;
    }

    public String getQuarantinePerson() {
        return quarantinePerson;
    }

    public void setQuarantinePerson(String quarantinePerson) {
        this.quarantinePerson = quarantinePerson;
    }

    public Integer getQuarantineResult() {
        return quarantineResult;
    }

    public void setQuarantineResult(Integer quarantineResult) {
        this.quarantineResult = quarantineResult;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(BigDecimal totalQuantity) {
        this.totalQuantity = totalQuantity;
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

    public BigDecimal getDamagedQuantity() {
        return damagedQuantity;
    }

    public void setDamagedQuantity(BigDecimal damagedQuantity) {
        this.damagedQuantity = damagedQuantity;
    }

    public BigDecimal getDestroyedQuantity() {
        return destroyedQuantity;
    }

    public void setDestroyedQuantity(BigDecimal destroyedQuantity) {
        this.destroyedQuantity = destroyedQuantity;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getStorageCondition() {
        return storageCondition;
    }

    public void setStorageCondition(String storageCondition) {
        this.storageCondition = storageCondition;
    }

    public String getTemperatureLog() {
        return temperatureLog;
    }

    public void setTemperatureLog(String temperatureLog) {
        this.temperatureLog = temperatureLog;
    }

    public Integer getQualityStatus() {
        return qualityStatus;
    }

    public void setQualityStatus(Integer qualityStatus) {
        this.qualityStatus = qualityStatus;
    }

    public Integer getInventoryStatus() {
        return inventoryStatus;
    }

    public void setInventoryStatus(Integer inventoryStatus) {
        this.inventoryStatus = inventoryStatus;
    }

    public LocalDate getFirstInDate() {
        return firstInDate;
    }

    public void setFirstInDate(LocalDate firstInDate) {
        this.firstInDate = firstInDate;
    }

    public LocalDate getLastInDate() {
        return lastInDate;
    }

    public void setLastInDate(LocalDate lastInDate) {
        this.lastInDate = lastInDate;
    }

    public LocalDate getLastOutDate() {
        return lastOutDate;
    }

    public void setLastOutDate(LocalDate lastOutDate) {
        this.lastOutDate = lastOutDate;
    }

    public LocalDate getStocktakeDate() {
        return stocktakeDate;
    }

    public void setStocktakeDate(LocalDate stocktakeDate) {
        this.stocktakeDate = stocktakeDate;
    }

    public BigDecimal getStocktakeDifference() {
        return stocktakeDifference;
    }

    public void setStocktakeDifference(BigDecimal stocktakeDifference) {
        this.stocktakeDifference = stocktakeDifference;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
