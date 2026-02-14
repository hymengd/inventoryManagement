package com.seig.backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 药品基础信息实体类
 */
//@Data
//@ToString(includeFieldNames = true, callSuper = false)
//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
public class Medicines {
    /**
     * 药品ID，主键
     */
    private Integer medicineId;

    /**
     * 药品编码，唯一
     */
    private String medicineCode;

    /**
     * 通用名称
     */
    private String genericName;

    /**
     * 英文名称
     */
    private String englishName;

    /**
     * 化学名称
     */
    private String chemicalName;

    /**
     * 规格（如：100mg30片）
     */
    private String specification;

    /**
     * 剂型（片剂、胶囊、注射液等）
     */
    private String dosageForm;

    /**
     * 分类ID，外键关联medicine_category
     */
    private Integer categoryId;

    /**
     * 默认生产厂家
     */
    private String manufacturer;

    /**
     * 批准文号
     */
    private String approvalNumber;

    /**
     * 是否处方药：0-非处方，1-处方
     */
    private Boolean isPrescription;

    /**
     * 是否麻醉药品：0-否，1-是
     */
    private Boolean isNarcotic;

    /**
     * 是否精神药品：0-否，1-是
     */
    private Boolean isPsychotropic;

    /**
     * 是否毒性药品：0-否，1-是
     */
    private Boolean isToxic;

    /**
     * 是否高危药品：0-否，1-是
     */
    private Boolean isHighAlert;

    /**
     * 储存条件（常温、阴凉、冷藏、冷冻）
     */
    private String storageCondition;

    /**
     * 最小单位（片、粒、支、瓶等）
     */
    private String unit;

    /**
     * 包装单位（盒、瓶、箱）
     */
    private String packageUnit;

    /**
     * 包装转换系数（如：1盒=30片）
     */
    private Integer conversionFactor;

    /**
     * 最低库存量
     */
    private Integer minStock;

    /**
     * 最高库存量
     */
    private Integer maxStock;

    /**
     * 药品描述
     */
    private String description;

    /**
     * 不良反应
     */
    private String sideEffects;

    /**
     * 禁忌症
     */
    private String contraindications;

    /**
     * 状态：0-停用，1-启用
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

    public Integer getKK() {
        return medicineId;
    }
    public String GetNNN() {
        return genericName;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public String getMedicineCode() {
        return medicineCode;
    }

    public void setMedicineCode(String medicineCode) {
        this.medicineCode = medicineCode;
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getChemicalName() {
        return chemicalName;
    }

    public void setChemicalName(String chemicalName) {
        this.chemicalName = chemicalName;
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getApprovalNumber() {
        return approvalNumber;
    }

    public void setApprovalNumber(String approvalNumber) {
        this.approvalNumber = approvalNumber;
    }

    public Boolean getPrescription() {
        return isPrescription;
    }

    public void setPrescription(Boolean prescription) {
        isPrescription = prescription;
    }

    public Boolean getNarcotic() {
        return isNarcotic;
    }

    public void setNarcotic(Boolean narcotic) {
        isNarcotic = narcotic;
    }

    public Boolean getPsychotropic() {
        return isPsychotropic;
    }

    public void setPsychotropic(Boolean psychotropic) {
        isPsychotropic = psychotropic;
    }

    public Boolean getToxic() {
        return isToxic;
    }

    public void setToxic(Boolean toxic) {
        isToxic = toxic;
    }

    public Boolean getHighAlert() {
        return isHighAlert;
    }

    public void setHighAlert(Boolean highAlert) {
        isHighAlert = highAlert;
    }

    public String getStorageCondition() {
        return storageCondition;
    }

    public void setStorageCondition(String storageCondition) {
        this.storageCondition = storageCondition;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getPackageUnit() {
        return packageUnit;
    }

    public void setPackageUnit(String packageUnit) {
        this.packageUnit = packageUnit;
    }

    public Integer getConversionFactor() {
        return conversionFactor;
    }

    public void setConversionFactor(Integer conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public Integer getMinStock() {
        return minStock;
    }

    public void setMinStock(Integer minStock) {
        this.minStock = minStock;
    }

    public Integer getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(Integer maxStock) {
        this.maxStock = maxStock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    public String getContraindications() {
        return contraindications;
    }

    public void setContraindications(String contraindications) {
        this.contraindications = contraindications;
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
