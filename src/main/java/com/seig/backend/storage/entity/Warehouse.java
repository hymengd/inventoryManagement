package com.seig.backend.storage.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 仓库主表实体类
 * 对应 warehouse 表
 */
public class Warehouse {
    /**
     * 仓库编号，主键
     */
    private Integer warehouseId;

    /**
     * 仓库编码(2位字母，比如：ZY  住院药房 (ZhuYuan))
     */
    private String warehouseCode;

    /**
     * 仓库名称(如:中心药库)
     */
    private String warehouseName;

    /**
     * 仓库类型：1-中心药库 2-门诊药房 3-住院药房 4-急诊药房 5-中药房 6-静配中心
     */
    private Byte warehouseType;

    /**
     * 仓库地址
     */
    private String address;

    /**
     * 仓库负责人ID
     */
    private String managerId;

    /**
     * 仓库负责人姓名
     */
    private String managerName;

    /**
     * 联系电话
     */
    private String contactPhone;

    /**
     * 最低温度要求
     */
    private BigDecimal tempMin;

    /**
     * 最高温度要求
     */
    private BigDecimal tempMax;

    /**
     * 最低湿度要求(%)
     */
    private BigDecimal humidityMin;

    /**
     * 最高湿度要求(%)
     */
    private BigDecimal humidityMax;

    /**
     * 当前温度
     */
    private BigDecimal currentTemp;

    /**
     * 当前湿度
     */
    private BigDecimal currentHumidity;

    /**
     * 温度要求(方便展示用)
     */
    private String temperatureRange;

    /**
     * 湿度要求(方便展示用)
     */
    private String humidityRange;

    /**
     * 面积(平方米)
     */
    private BigDecimal areaSize;

    /**
     * 最大存储容量(货位数)
     */
    private Integer maxCapacity;

    /**
     * 是否支持冷链:0-否 1-是
     */
    private Byte supportColdChain;

    /**
     * 是否支持麻精药品:0-否 1-是
     */
    private Byte supportNarcotic;

    /**
     * 是否支持医疗用毒性药品:0-否 1-是
     */
    private Byte supportPoison;

    /**
     * 是否支持放射性药品:0-否 1-是
     */
    private Byte supportRadioactive;

    /**
     * 是否GSP认证:0-否 1-是
     */
    private Byte gspCertified;

    /**
     * 状态：0-停用 1-启用 2-维护中 3-盘点中
     */
    private Byte status;

    /**
     * 上级仓库ID(如:门诊药房的上级是中心药库)
     */
    private Integer parentWarehouseId;

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

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 更新人
     */
    private String updatedBy;

    /**
     * 备注
     */
    private String remark;

    public String getHumidityRange() {
        return humidityRange;
    }

    public void setHumidityRange(String humidityRange) {
        this.humidityRange = humidityRange;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public Byte getWarehouseType() {
        return warehouseType;
    }

    public void setWarehouseType(Byte warehouseType) {
        this.warehouseType = warehouseType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public BigDecimal getTempMin() {
        return tempMin;
    }

    public void setTempMin(BigDecimal tempMin) {
        this.tempMin = tempMin;
    }

    public BigDecimal getTempMax() {
        return tempMax;
    }

    public void setTempMax(BigDecimal tempMax) {
        this.tempMax = tempMax;
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

    public String getTemperatureRange() {
        return temperatureRange;
    }

    public void setTemperatureRange(String temperatureRange) {
        this.temperatureRange = temperatureRange;
    }

    public BigDecimal getAreaSize() {
        return areaSize;
    }

    public void setAreaSize(BigDecimal areaSize) {
        this.areaSize = areaSize;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Byte getSupportColdChain() {
        return supportColdChain;
    }

    public void setSupportColdChain(Byte supportColdChain) {
        this.supportColdChain = supportColdChain;
    }

    public Byte getSupportNarcotic() {
        return supportNarcotic;
    }

    public void setSupportNarcotic(Byte supportNarcotic) {
        this.supportNarcotic = supportNarcotic;
    }

    public Byte getSupportPoison() {
        return supportPoison;
    }

    public void setSupportPoison(Byte supportPoison) {
        this.supportPoison = supportPoison;
    }

    public Byte getSupportRadioactive() {
        return supportRadioactive;
    }

    public void setSupportRadioactive(Byte supportRadioactive) {
        this.supportRadioactive = supportRadioactive;
    }

    public Byte getGspCertified() {
        return gspCertified;
    }

    public void setGspCertified(Byte gspCertified) {
        this.gspCertified = gspCertified;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getParentWarehouseId() {
        return parentWarehouseId;
    }

    public void setParentWarehouseId(Integer parentWarehouseId) {
        this.parentWarehouseId = parentWarehouseId;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
