package com.seig.backend.storage.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 待验批次主表实体类
 * 对应 quarantine_batches 表
 */
public class QuarantineBatch {
    /**
     * 待验ID，主键
     */
    private Integer quarantineId;

    /**
     * 关联的批次ID（验收后创建）
     */
    private Integer batchId;

    /**
     * 采购订单ID
     */
    private Integer purchaseOrderId;

    /**
     * SKU ID
     */
    private Integer skuId;

    /**
     * 供应商ID
     */
    private Integer supplierId;

    /**
     * 预期到货数量
     */
    private BigDecimal expectedQuantity;

    /**
     * 实际到货数量
     */
    private BigDecimal actualQuantity;

    /**
     * 到货日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate receivedDate;

    /**
     * 收货人
     */
    private String receiver;

    /**
     * 待验区库位
     */
    private String quarantineLocation;

    /**
     * 状态：1-待验收，2-验收中，3-已验收
     */
    private Byte quarantineStatus;

    /**
     * 取样数量
     */
    private BigDecimal samplingQuantity;

    /**
     * 取样日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate samplingDate;

    /**
     * 取样人
     */
    private String samplingBy;

    /**
     * 检验结果：0-未检验，1-合格，2-不合格
     */
    private Byte inspectionResult;

    /**
     * 检验完成日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate inspectionDate;

    /**
     * 检验人
     */
    private String inspector;

    /**
     * 检验报告编号
     */
    private String certificateNo;

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

    // Getter 和 Setter 方法
    public Integer getQuarantineId() {
        return quarantineId;
    }

    public void setQuarantineId(Integer quarantineId) {
        this.quarantineId = quarantineId;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public Integer getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(Integer purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
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

    public BigDecimal getExpectedQuantity() {
        return expectedQuantity;
    }

    public void setExpectedQuantity(BigDecimal expectedQuantity) {
        this.expectedQuantity = expectedQuantity;
    }

    public BigDecimal getActualQuantity() {
        return actualQuantity;
    }

    public void setActualQuantity(BigDecimal actualQuantity) {
        this.actualQuantity = actualQuantity;
    }

    public LocalDate getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(LocalDate receivedDate) {
        this.receivedDate = receivedDate;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getQuarantineLocation() {
        return quarantineLocation;
    }

    public void setQuarantineLocation(String quarantineLocation) {
        this.quarantineLocation = quarantineLocation;
    }

    public Byte getQuarantineStatus() {
        return quarantineStatus;
    }

    public void setQuarantineStatus(Byte quarantineStatus) {
        this.quarantineStatus = quarantineStatus;
    }

    public BigDecimal getSamplingQuantity() {
        return samplingQuantity;
    }

    public void setSamplingQuantity(BigDecimal samplingQuantity) {
        this.samplingQuantity = samplingQuantity;
    }

    public LocalDate getSamplingDate() {
        return samplingDate;
    }

    public void setSamplingDate(LocalDate samplingDate) {
        this.samplingDate = samplingDate;
    }

    public String getSamplingBy() {
        return samplingBy;
    }

    public void setSamplingBy(String samplingBy) {
        this.samplingBy = samplingBy;
    }

    public Byte getInspectionResult() {
        return inspectionResult;
    }

    public void setInspectionResult(Byte inspectionResult) {
        this.inspectionResult = inspectionResult;
    }

    public LocalDate getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(LocalDate inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
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
}
