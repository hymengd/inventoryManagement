package com.seig.backend.entity.storage;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 待验库存明细表实体类
 * 对应 quarantine_inventory 表
 */
public class QuarantineInventory {
    /**
     * 明细ID，主键
     */
    private Integer detailId;

    /**
     * 待验ID，外键关联 quarantine_batches
     */
    private Integer quarantineId;

    /**
     * 待验区具体货位ID
     */
    private Integer locationId;

    /**
     * 数量
     */
    private BigDecimal quantity;

    /**
     * 温区
     */
    private String temperatureZone;

    /**
     * 湿度条件
     */
    private String humidityCondition;

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

    private Integer skuId;

    // Getter 和 Setter 方法
    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public Integer getQuarantineId() {
        return quarantineId;
    }

    public void setQuarantineId(Integer quarantineId) {
        this.quarantineId = quarantineId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getTemperatureZone() {
        return temperatureZone;
    }

    public void setTemperatureZone(String temperatureZone) {
        this.temperatureZone = temperatureZone;
    }

    public String getHumidityCondition() {
        return humidityCondition;
    }

    public void setHumidityCondition(String humidityCondition) {
        this.humidityCondition = humidityCondition;
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
