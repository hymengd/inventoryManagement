package com.seig.backend.system.entity;

import java.time.LocalDateTime;

/**
 * 药品供应商实体类
 */
public class Supplier {
    private Integer supplierId; // 供应商ID
    
    // 基本联系信息
    private String supplierName; // 供应商名称
    private String contactPerson; // 联系人姓名
    private String contactPhone; // 联系电话
    private String contactEmail; // 联系邮箱
    
    // 药品相关资质信息
    private String drugBusinessLicense; // 药品经营许可证号
    private String gspCertificate; // GSP证书编号
    private String businessScope; // 经营范围
    
    // 药品供应能力
    private String mainDrugCategories; // 主营药品品类
    private String supplyCapability; // 供应能力描述
    private Integer deliveryTime; // 平均交货时间（天）
    
    // 药品质量相关
    private String qualitySystem; // 质量体系认证
    private Boolean coldChainSupport; // 冷链支持：0-否，1-是
    
    // 状态
    private Boolean status; // 状态：0-停用，1-启用
    
    private LocalDateTime createdAt; // 创建时间
    private LocalDateTime updatedAt; // 更新时间
    private String entityType; // manufacturer-纯生产厂家，supplier-纯供应商，both-既是厂家又是供应商
    private Integer parentManufacturerId; // 如果是经销商，卖的是哪个生产厂家的？不单一应该
    
    // 构造函数
    public Supplier() {}
    
    // Getter 和 Setter 方法
    public Integer getSupplierId() { return supplierId; }
    public void setSupplierId(Integer supplierId) { this.supplierId = supplierId; }
    
    public String getSupplierName() { return supplierName; }
    public void setSupplierName(String supplierName) { this.supplierName = supplierName; }
    
    public String getContactPerson() { return contactPerson; }
    public void setContactPerson(String contactPerson) { this.contactPerson = contactPerson; }
    
    public String getContactPhone() { return contactPhone; }
    public void setContactPhone(String contactPhone) { this.contactPhone = contactPhone; }
    
    public String getContactEmail() { return contactEmail; }
    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }
    
    public String getDrugBusinessLicense() { return drugBusinessLicense; }
    public void setDrugBusinessLicense(String drugBusinessLicense) { this.drugBusinessLicense = drugBusinessLicense; }
    
    public String getGspCertificate() { return gspCertificate; }
    public void setGspCertificate(String gspCertificate) { this.gspCertificate = gspCertificate; }
    
    public String getBusinessScope() { return businessScope; }
    public void setBusinessScope(String businessScope) { this.businessScope = businessScope; }
    
    public String getMainDrugCategories() { return mainDrugCategories; }
    public void setMainDrugCategories(String mainDrugCategories) { this.mainDrugCategories = mainDrugCategories; }
    
    public String getSupplyCapability() { return supplyCapability; }
    public void setSupplyCapability(String supplyCapability) { this.supplyCapability = supplyCapability; }
    
    public Integer getDeliveryTime() { return deliveryTime; }
    public void setDeliveryTime(Integer deliveryTime) { this.deliveryTime = deliveryTime; }
    
    public String getQualitySystem() { return qualitySystem; }
    public void setQualitySystem(String qualitySystem) { this.qualitySystem = qualitySystem; }
    
    public Boolean getColdChainSupport() { return coldChainSupport; }
    public void setColdChainSupport(Boolean coldChainSupport) { this.coldChainSupport = coldChainSupport; }
    
    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    
    public String getEntityType() { return entityType; }
    public void setEntityType(String entityType) { this.entityType = entityType; }
    
    public Integer getParentManufacturerId() { return parentManufacturerId; }
    public void setParentManufacturerId(Integer parentManufacturerId) { this.parentManufacturerId = parentManufacturerId; }
}
