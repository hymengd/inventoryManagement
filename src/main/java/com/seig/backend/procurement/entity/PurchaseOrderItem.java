package com.seig.backend.procurement.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 采购订单明细表实体类
 */
public class PurchaseOrderItem {
    /**
     * 明细ID，主键
     */
    private Long itemId;

    /**
     * 订单ID（关联purchase_orders）
     */
    private Long orderId;

    /**
     * 药品ID（关联药品主表）
     */
    private Long drugId;

    /**
     * 药品通用名称
     */
    private String drugName;

    /**
     * 药品编码
     */
    private String drugCode;

    /**
     * 规格（如0.5g*24粒）
     */
    private String specification;

    /**
     * 剂型（片剂、胶囊、注射剂等）
     */
    private String dosageForm;

    /**
     * 生产厂家
     */
    private String manufacturer;

    /**
     * 批准文号（国药准字H...）
     */
    private String approvalNo;

    /**
     * 采购数量
     */
    private Integer purchaseQuantity;

    /**
     * 单位（盒、瓶、支等）
     */
    private String unit;

    /**
     * 单价
     */
    private BigDecimal unitPrice;

    /**
     * 金额（数量*单价）
     */
    private BigDecimal amount;

    /**
     * 生产批号（到货后填写）
     */
    private String batchNo;

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
     * 保质期（月）
     */
    private Integer shelfLifeMonths;

    /**
     * 入库仓库ID
     */
    private Integer warehouseId;

    /**
     * 存放货位号
     */
    private String locationNo;

    /**
     * 实际到货数量
     */
    private Integer receivedQuantity;

    /**
     * 验收合格数量
     */
    private Integer qualifiedQuantity;

    /**
     * 不合格数量
     */
    private Integer unqualifiedQuantity;

    /**
     * 不合格原因
     */
    private String unqualifiedReason;

    /**
     * 是否冷链药品
     */
    private Byte isColdChain;

    /**
     * 储存条件（常温、冷藏、冷冻）
     */
    private String storageCondition;

    /**
     * 温度记录（到货时）
     */
    private String temperatureRecord;

    /**
     * 质量状态：0-待验收，1-合格，2-不合格，3-待处理
     */
    private Byte qualityStatus;

    /**
     * 备注
     */
    private String remarks;

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
     * SKU的ID
     */
    private Integer skuId;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getDrugId() {
        return drugId;
    }

    public void setDrugId(Long drugId) {
        this.drugId = drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugCode() {
        return drugCode;
    }

    public void setDrugCode(String drugCode) {
        this.drugCode = drugCode;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getDosageForm() {
        return dosageForm;
    }

    public void setDosageForm(String dosageForm) {
        this.dosageForm = dosageForm;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getApprovalNo() {
        return approvalNo;
    }

    public void setApprovalNo(String approvalNo) {
        this.approvalNo = approvalNo;
    }

    public Integer getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(Integer purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
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

    public Integer getShelfLifeMonths() {
        return shelfLifeMonths;
    }

    public void setShelfLifeMonths(Integer shelfLifeMonths) {
        this.shelfLifeMonths = shelfLifeMonths;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getLocationNo() {
        return locationNo;
    }

    public void setLocationNo(String locationNo) {
        this.locationNo = locationNo;
    }

    public Integer getReceivedQuantity() {
        return receivedQuantity;
    }

    public void setReceivedQuantity(Integer receivedQuantity) {
        this.receivedQuantity = receivedQuantity;
    }

    public Integer getQualifiedQuantity() {
        return qualifiedQuantity;
    }

    public void setQualifiedQuantity(Integer qualifiedQuantity) {
        this.qualifiedQuantity = qualifiedQuantity;
    }

    public Integer getUnqualifiedQuantity() {
        return unqualifiedQuantity;
    }

    public void setUnqualifiedQuantity(Integer unqualifiedQuantity) {
        this.unqualifiedQuantity = unqualifiedQuantity;
    }

    public String getUnqualifiedReason() {
        return unqualifiedReason;
    }

    public void setUnqualifiedReason(String unqualifiedReason) {
        this.unqualifiedReason = unqualifiedReason;
    }

    public Byte getIsColdChain() {
        return isColdChain;
    }

    public void setIsColdChain(Byte isColdChain) {
        this.isColdChain = isColdChain;
    }

    public String getStorageCondition() {
        return storageCondition;
    }

    public void setStorageCondition(String storageCondition) {
        this.storageCondition = storageCondition;
    }

    public String getTemperatureRecord() {
        return temperatureRecord;
    }

    public void setTemperatureRecord(String temperatureRecord) {
        this.temperatureRecord = temperatureRecord;
    }

    public Byte getQualityStatus() {
        return qualityStatus;
    }

    public void setQualityStatus(Byte qualityStatus) {
        this.qualityStatus = qualityStatus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
    
    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }
}
