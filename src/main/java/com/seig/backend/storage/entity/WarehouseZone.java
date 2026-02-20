package com.seig.backend.storage.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 仓库库区表实体类
 * 对应 warehouse_zone 表
 */
public class WarehouseZone {
    /**
     * 库区编号，主键
     */
    private Integer zoneId;

    /**
     * 所属仓库ID
     */
    private Integer warehouseId;

    /**
     * 库区编码(如:A区)
     */
    private String zoneCode;

    /**
     * 库区名称(如:常温合格品区)
     */
    private String zoneName;

    /**
     * 库区类型：1-常温库 2-阴凉库 3-冷藏库 4-冷冻库 5-麻精库 6-危险品库
     */
    private Byte zoneType;

    /**
     * GSP分区类型(质量状态维度：1-合格品区 2-待验区 3-不合格品区 4-退货区 5-发货区 6-隔离区)
     */
    private Byte gspZoneType;

    /**
     * 风险等级：1-常温 2-阴凉 3-冷藏 4-冷冻 5-麻精 6-高危 7-剧毒
     */
    private Byte riskLevel;

    /**
     * 最低温度
     */
    private BigDecimal temperatureMin;

    /**
     * 最高温度
     */
    private BigDecimal temperatureMax;

    /**
     * 最低湿度(%)
     */
    private BigDecimal humidityMin;

    /**
     * 最高湿度(%)
     */
    private BigDecimal humidityMax;

    /**
     * 当前温度
     */
    private BigDecimal currentTemp;

    /**
     * 当前湿度(%)
     */
    private BigDecimal currentHumidity;

    /**
     * 父级库区ID(自关联，用于多级货架)
     */
    private Integer parentZoneId;

    /**
     * 是否麻精专用库区:0-否 1-是
     */
    private Byte isNarcotic;

    /**
     * 是否双人双锁:0-否 1-是
     */
    private Byte isDoubleLock;

    /**
     * 是否门禁管控:0-否 1-是
     */
    private Byte isAccessControl;

    /**
     * 状态：0-停用 1-启用 2-维护中
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


    public Byte getIsNarcotic() {
        return isNarcotic;
    }

    public void setIsNarcotic(Byte isNarcotic) {
        this.isNarcotic = isNarcotic;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public Byte getZoneType() {
        return zoneType;
    }

    public void setZoneType(Byte zoneType) {
        this.zoneType = zoneType;
    }

    public Byte getGspZoneType() {
        return gspZoneType;
    }

    public void setGspZoneType(Byte gspZoneType) {
        this.gspZoneType = gspZoneType;
    }

    public Byte getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(Byte riskLevel) {
        this.riskLevel = riskLevel;
    }

    public BigDecimal getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(BigDecimal temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public BigDecimal getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(BigDecimal temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public BigDecimal getHumidityMin() {
        return humidityMin;
    }

    public void setHumidityMin(BigDecimal humidityMin) {
        this.humidityMin = humidityMin;
    }

    public BigDecimal getHumidityMax() {
        return humidityMax;
    }

    public void setHumidityMax(BigDecimal humidityMax) {
        this.humidityMax = humidityMax;
    }

    public BigDecimal getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(BigDecimal currentTemp) {
        this.currentTemp = currentTemp;
    }

    public BigDecimal getCurrentHumidity() {
        return currentHumidity;
    }

    public void setCurrentHumidity(BigDecimal currentHumidity) {
        this.currentHumidity = currentHumidity;
    }

    public Integer getParentZoneId() {
        return parentZoneId;
    }

    public void setParentZoneId(Integer parentZoneId) {
        this.parentZoneId = parentZoneId;
    }

    public Byte getIsDoubleLock() {
        return isDoubleLock;
    }

    public void setIsDoubleLock(Byte isDoubleLock) {
        this.isDoubleLock = isDoubleLock;
    }

    public Byte getIsAccessControl() {
        return isAccessControl;
    }

    public void setIsAccessControl(Byte isAccessControl) {
        this.isAccessControl = isAccessControl;
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
