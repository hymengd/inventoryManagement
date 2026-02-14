package com.seig.backend.service;

import com.seig.backend.entity.record.PurchaseArrival;

import java.util.List;

public interface PurchaseArrivalService {
    /**
     * 创建采购到货记录
     */
    PurchaseArrival createPurchaseArrival(PurchaseArrival purchaseArrival);

    /**
     * 根据ID查询到货记录
     */
    PurchaseArrival getPurchaseArrivalById(Integer arrivalId);

    /**
     * 查询所有到货记录
     */
    List<PurchaseArrival> getAllPurchaseArrivals();

    /**
     * 根据采购订单ID查询到货记录
     */
    List<PurchaseArrival> getPurchaseArrivalsByPoId(Integer poId);

    /**
     * 根据SKU ID查询到货记录
     */
    List<PurchaseArrival> getPurchaseArrivalsBySkuId(Integer skuId);

    /**
     * 更新到货记录
     */
    PurchaseArrival updatePurchaseArrival(PurchaseArrival purchaseArrival);

    /**
     * 删除到货记录
     */
    boolean deletePurchaseArrivalById(Integer arrivalId);

}
