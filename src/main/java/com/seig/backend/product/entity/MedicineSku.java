package com.seig.backend.product.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 药品SKU实体类
 * 管理同一药品不同供应商/厂家的具体商品
 */
public class MedicineSku {
    /**
     * SKU ID，主键
     */
    private Integer skuId;

    /**
     * SKU编码（规则：药品编码-厂家简码-规格码）
     */
    private String skuCode;

    /**
     * 药品ID，外键关联medicines
     */
    private Integer medicineId;

    /**
     * 供应商ID，外键关联suppliers
     */
    private Integer supplierId;

    /**
     * 生产厂家ID（可指向suppliers表）
     */
    private Integer manufacturerId;

    /**
     * 是否从厂家直供
     */
    private Boolean isDirectFromManufacturer;

    /**
     * 商品名/品牌名
     */
    private String brandName;

    /**
     * 详细规格（如：100mg30片/盒）
     */
    private String specificationDetail;

    /**
     * 包装描述
     */
    private String packaging;

    /**
     * 商品条码
     */
    private String barcode;

    /**
     * 批准文号（可能不同厂家不同）
     */
    private String approvalNumber;

    /**
     * 产地
     */
    private String originCountry;

    /**
     * 采购单价
     */
    private BigDecimal purchasePrice;

    /**
     * 批发价
     */
    private BigDecimal wholesalePrice;

    /**
     * 零售价
     */
    private BigDecimal retailPrice;

    /**
     * 医保支付价
     */
    private BigDecimal insurancePrice;

    /**
     * 是否中标产品：0-否，1-是
     */
    private Boolean isBidWinner;

    /**
     * 中标编号
     */
    private String bidNumber;

    /**
     * 是否首选供应商：0-否，1-是
     */
    private Boolean isPreferred;

    /**
     * 采购优先级（1-10，数字越小优先级越高）
     */
    private Integer priorityLevel;

    /**
     * 最小采购量
     */
    private Integer minPurchaseQuantity;

    /**
     * 采购单位
     */
    private String purchaseUnit;

    /**
     * 采购单位到最小单位转换系数
     */
    private Integer conversionToMin;

    /**
     * 质量层次：原研、参比制剂、通过一致性评价等
     */
    private String qualityLevel;

    /**
     * 有效期（月）
     */
    private Integer validityPeriodMonths;

    /**
     * 详细储存条件
     */
    private String storageConditionDetail;

    /**
     * 是否特殊药品（麻、精、毒、放等）
     */
    private Boolean isSpecialDrug;

    /**
     * 是否需要冷藏
     */
    private Boolean isRefrigerated;

    /**
     * 是否避光
     */
    private Boolean isLightSensitive;

    /**
     * 是否防潮
     */
    private Boolean isMoistureSensitive;

//    min_temperature DECIMAL(5,2) COMMENT '最低温度要求',
//    max_temperature DECIMAL(5,2) COMMENT '最高温度要求',
    private BigDecimal minTemperature;
    private BigDecimal maxTemperature;

    public BigDecimal getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(BigDecimal minTemperature) {
        this.minTemperature = minTemperature;
    }

    public BigDecimal getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(BigDecimal maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    /**
     * 安全库存量
     */
    private Integer safetyStock;

    /**
     * 再订货点
     */
    private Integer reorderPoint;

    /**
     * 月均销售量（用于补货预测）
     */
    private Integer avgMonthlySales;

    /**
     * 最后采购日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate lastPurchaseDate;

    /**
     * 最后销售日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate lastSaleDate;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态：0-停用，1-启用，2-缺货，3-停采
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

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Integer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public Boolean getDirectFromManufacturer() {
        return isDirectFromManufacturer;
    }

    public void setDirectFromManufacturer(Boolean directFromManufacturer) {
        isDirectFromManufacturer = directFromManufacturer;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getSpecificationDetail() {
        return specificationDetail;
    }

    public void setSpecificationDetail(String specificationDetail) {
        this.specificationDetail = specificationDetail;
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getApprovalNumber() {
        return approvalNumber;
    }

    public void setApprovalNumber(String approvalNumber) {
        this.approvalNumber = approvalNumber;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(BigDecimal wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    public BigDecimal getInsurancePrice() {
        return insurancePrice;
    }

    public void setInsurancePrice(BigDecimal insurancePrice) {
        this.insurancePrice = insurancePrice;
    }

    public Boolean getBidWinner() {
        return isBidWinner;
    }

    public void setBidWinner(Boolean bidWinner) {
        isBidWinner = bidWinner;
    }

    public String getBidNumber() {
        return bidNumber;
    }

    public void setBidNumber(String bidNumber) {
        this.bidNumber = bidNumber;
    }

    public Boolean getPreferred() {
        return isPreferred;
    }

    public void setPreferred(Boolean preferred) {
        isPreferred = preferred;
    }

    public Integer getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(Integer priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public Integer getMinPurchaseQuantity() {
        return minPurchaseQuantity;
    }

    public void setMinPurchaseQuantity(Integer minPurchaseQuantity) {
        this.minPurchaseQuantity = minPurchaseQuantity;
    }

    public String getPurchaseUnit() {
        return purchaseUnit;
    }

    public void setPurchaseUnit(String purchaseUnit) {
        this.purchaseUnit = purchaseUnit;
    }

    public Integer getConversionToMin() {
        return conversionToMin;
    }

    public void setConversionToMin(Integer conversionToMin) {
        this.conversionToMin = conversionToMin;
    }

    public String getQualityLevel() {
        return qualityLevel;
    }

    public void setQualityLevel(String qualityLevel) {
        this.qualityLevel = qualityLevel;
    }

    public Integer getValidityPeriodMonths() {
        return validityPeriodMonths;
    }

    public void setValidityPeriodMonths(Integer validityPeriodMonths) {
        this.validityPeriodMonths = validityPeriodMonths;
    }

    public String getStorageConditionDetail() {
        return storageConditionDetail;
    }

    public void setStorageConditionDetail(String storageConditionDetail) {
        this.storageConditionDetail = storageConditionDetail;
    }

    public Boolean getSpecialDrug() {
        return isSpecialDrug;
    }

    public void setSpecialDrug(Boolean specialDrug) {
        isSpecialDrug = specialDrug;
    }

    public Boolean getRefrigerated() {
        return isRefrigerated;
    }

    public void setRefrigerated(Boolean refrigerated) {
        isRefrigerated = refrigerated;
    }

    public Boolean getLightSensitive() {
        return isLightSensitive;
    }

    public void setLightSensitive(Boolean lightSensitive) {
        isLightSensitive = lightSensitive;
    }

    public Boolean getMoistureSensitive() {
        return isMoistureSensitive;
    }

    public void setMoistureSensitive(Boolean moistureSensitive) {
        isMoistureSensitive = moistureSensitive;
    }

    public Integer getSafetyStock() {
        return safetyStock;
    }

    public void setSafetyStock(Integer safetyStock) {
        this.safetyStock = safetyStock;
    }

    public Integer getReorderPoint() {
        return reorderPoint;
    }

    public void setReorderPoint(Integer reorderPoint) {
        this.reorderPoint = reorderPoint;
    }

    public Integer getAvgMonthlySales() {
        return avgMonthlySales;
    }

    public void setAvgMonthlySales(Integer avgMonthlySales) {
        this.avgMonthlySales = avgMonthlySales;
    }

    public LocalDate getLastPurchaseDate() {
        return lastPurchaseDate;
    }

    public void setLastPurchaseDate(LocalDate lastPurchaseDate) {
        this.lastPurchaseDate = lastPurchaseDate;
    }

    public LocalDate getLastSaleDate() {
        return lastSaleDate;
    }

    public void setLastSaleDate(LocalDate lastSaleDate) {
        this.lastSaleDate = lastSaleDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
