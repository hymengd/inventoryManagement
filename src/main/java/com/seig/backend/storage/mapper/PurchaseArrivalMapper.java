package com.seig.backend.storage.mapper;

import com.seig.backend.storage.entity.PurchaseArrival;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PurchaseArrivalMapper {

    /**
     * 插入采购到货记录
     */
    int insert(PurchaseArrival purchaseArrival);

    /**
     * 根据到货单号查询记录
     */
    PurchaseArrival selectByArrivalId(Integer arrivalId);

    /**
     * 查询所有到货记录
     */
    List<PurchaseArrival> selectAllPurchaseArrivals();

    /**
     * 根据采购订单ID查询到货记录
     */
    List<PurchaseArrival> selectByPoId(Integer poId);

    /**
     * 根据SKU ID查询到货记录
     */
    List<PurchaseArrival> selectBySkuId(Integer skuId);

    /**
     * 更新到货记录
     */
    int updatePurchaseArrival(PurchaseArrival purchaseArrival);

    /**
     * 根据到货单号删除记录
     */
    int deleteByArrivalId(Integer arrivalId);
}
