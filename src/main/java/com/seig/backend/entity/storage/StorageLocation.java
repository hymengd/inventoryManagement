package com.seig.backend.entity.storage;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 货位/储位表实体类
 * 对应 storage_location 表
 */
public class StorageLocation {
    /**
     * 货位编号，主键
     */
    private Integer locationId;

    /**
     * 所属货架/容器ID
     */
    private Integer containerId;

    /**
     * 货位编码(如:02-03表示02层03列)
     */
    private String locationCode;

    /**
     * 有效期，先到有效期的先出
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime expiryDate;

    /**
     * 货位类型：1-托盘位 2-箱位 3-散货位 4-冷藏位 5-冷冻位 6-麻精专柜位
     */
    private Byte locationType;

    /**
     * 最大承重(kg)
     */
    private BigDecimal maxWeight;

    /**
     * 尺寸(长x宽x高 cm)
     */
    private String dimension;

    /**
     * 容积(L)
     */
    private BigDecimal volume;

    /**
     * 限定存放药品分类(如:仅限抗生素类)
     */
    private String drugCategoryLimit;

    /**
     * 限定存放特定药品(专货位)
     */
    private String drugIdLimit;

    /**
     * 禁止存放的药品类型(如:禁止存放注射剂)
     */
    private String excludeDrugTypes;

    /**
     * 货位质量状态(GSP要求)：1-合格品 2-待验 3-不合格 4-退货 5-冻结
     */
    private Byte qualityStatus;

    /**
     * 是否冷藏位:0-否 1-是
     */
    private Byte isRefrigerated;

    /**
     * 是否高频货位(近出口，用于快销药)
     */
    private Byte isHighFrequency;

    /**
     * 是否麻精专位:0-否 1-是
     */
    private Byte isNarcotic;

    /**
     * 是否双锁:0-否 1-是
     */
    private Byte isDoubleLock;

    /**
     * 是否允许空托盘占位:0-否 1-是
     */
    private Byte isEmptyTray;

    /**
     * 层号(从下往上1,2,3...)
     */
    private Byte layerNo;

    /**
     * 列号(从左往右1,2,3...)
     */
    private Byte columnNo;

    /**
     * 深度号(前后排，1-前排 2-后排)
     */
    private Byte depthNo;

    /**
     * 状态：0-停用 1-启用 2-锁定(盘点/移库中) 3-维修
     */
    private Byte status;

    /**
     * 1-存储货位(正常存放) 2-发药窗口暂存 3-摆药缓存区 4-退药隔离区 5-复核台 6-包药机槽位 7-科室基数柜
     */
    private Byte locationUsageType;

    /**
     * 关联的发药窗口ID/摆药台ID/科室ID
     */
    private String relatedStationId;

    /**
     * 当前存放药品ID(空表示空闲)
     */
    private String currentDrugId;

    /**
     * 是否空闲(虚拟字段)
     */
    private Boolean isEmpty;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createdTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updatedTime;


    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getContainerId() {
        return containerId;
    }

    public void setContainerId(Integer containerId) {
        this.containerId = containerId;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Byte getLocationType() {
        return locationType;
    }

    public void setLocationType(Byte locationType) {
        this.locationType = locationType;
    }

    public BigDecimal getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(BigDecimal maxWeight) {
        this.maxWeight = maxWeight;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public String getDrugCategoryLimit() {
        return drugCategoryLimit;
    }

    public void setDrugCategoryLimit(String drugCategoryLimit) {
        this.drugCategoryLimit = drugCategoryLimit;
    }

    public String getDrugIdLimit() {
        return drugIdLimit;
    }

    public void setDrugIdLimit(String drugIdLimit) {
        this.drugIdLimit = drugIdLimit;
    }

    public String getExcludeDrugTypes() {
        return excludeDrugTypes;
    }

    public void setExcludeDrugTypes(String excludeDrugTypes) {
        this.excludeDrugTypes = excludeDrugTypes;
    }

    public Byte getQualityStatus() {
        return qualityStatus;
    }

    public void setQualityStatus(Byte qualityStatus) {
        this.qualityStatus = qualityStatus;
    }

    public Byte getIsRefrigerated() {
        return isRefrigerated;
    }

    public void setIsRefrigerated(Byte isRefrigerated) {
        this.isRefrigerated = isRefrigerated;
    }

    public Byte getIsHighFrequency() {
        return isHighFrequency;
    }

    public void setIsHighFrequency(Byte isHighFrequency) {
        this.isHighFrequency = isHighFrequency;
    }

    public Byte getIsNarcotic() {
        return isNarcotic;
    }

    public void setIsNarcotic(Byte isNarcotic) {
        this.isNarcotic = isNarcotic;
    }

    public Byte getIsDoubleLock() {
        return isDoubleLock;
    }

    public void setIsDoubleLock(Byte isDoubleLock) {
        this.isDoubleLock = isDoubleLock;
    }

    public Byte getIsEmptyTray() {
        return isEmptyTray;
    }

    public void setIsEmptyTray(Byte isEmptyTray) {
        this.isEmptyTray = isEmptyTray;
    }

    public Byte getLayerNo() {
        return layerNo;
    }

    public void setLayerNo(Byte layerNo) {
        this.layerNo = layerNo;
    }

    public Byte getColumnNo() {
        return columnNo;
    }

    public void setColumnNo(Byte columnNo) {
        this.columnNo = columnNo;
    }

    public Byte getDepthNo() {
        return depthNo;
    }

    public void setDepthNo(Byte depthNo) {
        this.depthNo = depthNo;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getLocationUsageType() {
        return locationUsageType;
    }

    public void setLocationUsageType(Byte locationUsageType) {
        this.locationUsageType = locationUsageType;
    }

    public String getRelatedStationId() {
        return relatedStationId;
    }

    public void setRelatedStationId(String relatedStationId) {
        this.relatedStationId = relatedStationId;
    }

    public String getCurrentDrugId() {
        return currentDrugId;
    }

    public void setCurrentDrugId(String currentDrugId) {
        this.currentDrugId = currentDrugId;
    }

    public Boolean getEmpty() {
        return isEmpty;
    }

    public void setEmpty(Boolean empty) {
        isEmpty = empty;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }
}
