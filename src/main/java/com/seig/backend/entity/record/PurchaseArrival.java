package com.seig.backend.entity.record;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

/**
 * 采购到货实体类
 * 对应 purchase_arrivals 表
 */
public class PurchaseArrival {

    /**
     * 到货单号
     */
    private Integer arrivalId;

    /**
     * 关联采购订单
     */
    private Integer poId;

    /**
     * 药品规格ID(哪个药)
     */
    private Integer skuId;

    /**
     * 药品批号
     */
    private String batchNo;

    /**
     * 到货数量（实物数）
     */
    private Integer arrivalQty;

    /**
     * 到货日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate arrivalDate;

    /**
     * 暂存位置：待验区-A03
     */
    private String locationTemp;

    /**
     * 状态: 待验,检验中,合格,不合格,已退货
     */
    private String status;

    /**
     * 验收员
     */
    private String inspectorId;

    /**
     * 验收日期（完成时填写）
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate inspectDate;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getArrivalId() {
        return arrivalId;
    }

    public void setArrivalId(Integer arrivalId) {
        this.arrivalId = arrivalId;
    }

    public Integer getPoId() {
        return poId;
    }

    public void setPoId(Integer poId) {
        this.poId = poId;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public Integer getArrivalQty() {
        return arrivalQty;
    }

    public void setArrivalQty(Integer arrivalQty) {
        this.arrivalQty = arrivalQty;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getLocationTemp() {
        return locationTemp;
    }

    public void setLocationTemp(String locationTemp) {
        this.locationTemp = locationTemp;
    }

    public String getInspectorId() {
        return inspectorId;
    }

    public void setInspectorId(String inspectorId) {
        this.inspectorId = inspectorId;
    }

    public LocalDate getInspectDate() {
        return inspectDate;
    }

    public void setInspectDate(LocalDate inspectDate) {
        this.inspectDate = inspectDate;
    }
}
