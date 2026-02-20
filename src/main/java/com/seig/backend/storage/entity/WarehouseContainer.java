package com.seig.backend.storage.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 货架/容器表实体类
 * 对应 warehouse_container 表
 */
//@Data
public class WarehouseContainer {
    /**
     * 容器ID，主键
     */
    private Integer containerId;

    /**
     * 所属库区ID
     */
    private Integer zoneId;

    /**
     * 容器编码(如:A-01)
     */
    private String containerCode;

    /**
     * 容器名称(如:西药货架A)
     */
    private String containerName;

    /**
     * 容器类型：1-重型货架 2-中型货架 3-轻型货架 4-冷藏柜 5-冷冻柜 
     * 6-麻精保险柜 7-药斗组(中药) 8-智能药柜 9-周转箱 10-托盘
     */
    private Byte containerType;

    /**
     * 最大承重(kg)
     */
    private BigDecimal maxWeight;

    /**
     * 尺寸(长x宽x高 cm)
     */
    private String dimension;

    /**
     * 容积(m³)
     */
    private BigDecimal volume;

    /**
     * 设备资产编号
     */
    private String deviceNo;

    /**
     * 生产厂家
     */
    private String manufacturer;

    /**
     * 安装日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate installDate;

    /**
     * 最近维护日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate maintenanceDate;

    /**
     * 最近校准日期(冷柜等需要)
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate calibrationDate;

    /**
     * 下次校准日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate nextCalibrationDate;

    /**
     * 是否冷藏设备:0-否 1-是
     */
    private Byte isRefrigerated;

    /**
     * 是否麻精保险柜:0-否 1-是
     */
    private Byte isNarcoticSafe;

    /**
     * 是否双锁:0-否 1-是
     */
    private Byte isDoubleLock;

    /**
     * 是否智能柜(自动计数):0-否 1-是
     */
    private Byte isSmartCabinet;

    /**
     * 货架层数
     */
    private Byte shelfLayers;

    /**
     * 货架列数
     */
    private Byte shelfColumns;

    /**
     * 总货位数
     */
    private Integer totalLocations;

    /**
     * 状态：0-停用 1-启用 2-维修中 3-报废
     */
    private Byte status;

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


    public Integer getContainerId() {
        return containerId;
    }

    public void setContainerId(Integer containerId) {
        this.containerId = containerId;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public String getContainerCode() {
        return containerCode;
    }

    public void setContainerCode(String containerCode) {
        this.containerCode = containerCode;
    }

    public String getContainerName() {
        return containerName;
    }

    public void setContainerName(String containerName) {
        this.containerName = containerName;
    }

    public Byte getContainerType() {
        return containerType;
    }

    public void setContainerType(Byte containerType) {
        this.containerType = containerType;
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

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public LocalDate getInstallDate() {
        return installDate;
    }

    public void setInstallDate(LocalDate installDate) {
        this.installDate = installDate;
    }

    public LocalDate getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(LocalDate maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    public LocalDate getCalibrationDate() {
        return calibrationDate;
    }

    public void setCalibrationDate(LocalDate calibrationDate) {
        this.calibrationDate = calibrationDate;
    }

    public LocalDate getNextCalibrationDate() {
        return nextCalibrationDate;
    }

    public void setNextCalibrationDate(LocalDate nextCalibrationDate) {
        this.nextCalibrationDate = nextCalibrationDate;
    }

    public Byte getIsRefrigerated() {
        return isRefrigerated;
    }

    public void setIsRefrigerated(Byte isRefrigerated) {
        this.isRefrigerated = isRefrigerated;
    }

    public Byte getIsNarcoticSafe() {
        return isNarcoticSafe;
    }

    public void setIsNarcoticSafe(Byte isNarcoticSafe) {
        this.isNarcoticSafe = isNarcoticSafe;
    }

    public Byte getIsDoubleLock() {
        return isDoubleLock;
    }

    public void setIsDoubleLock(Byte isDoubleLock) {
        this.isDoubleLock = isDoubleLock;
    }

    public Byte getIsSmartCabinet() {
        return isSmartCabinet;
    }

    public void setIsSmartCabinet(Byte isSmartCabinet) {
        this.isSmartCabinet = isSmartCabinet;
    }

    public Byte getShelfLayers() {
        return shelfLayers;
    }

    public void setShelfLayers(Byte shelfLayers) {
        this.shelfLayers = shelfLayers;
    }

    public Byte getShelfColumns() {
        return shelfColumns;
    }

    public void setShelfColumns(Byte shelfColumns) {
        this.shelfColumns = shelfColumns;
    }

    public Integer getTotalLocations() {
        return totalLocations;
    }

    public void setTotalLocations(Integer totalLocations) {
        this.totalLocations = totalLocations;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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
