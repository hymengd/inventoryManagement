package com.seig.backend.storage.service.impl;

import com.seig.backend.storage.entity.PurchaseArrival;
import com.seig.backend.storage.mapper.PurchaseArrivalMapper;
import com.seig.backend.storage.service.PurchaseArrivalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class PurchaseArrivalServiceImpl implements PurchaseArrivalService {
    
    @Autowired
    private PurchaseArrivalMapper purchaseArrivalMapper;

    @Override
    public PurchaseArrival createPurchaseArrival(PurchaseArrival purchaseArrival) {
        // 设置默认值
        if (purchaseArrival.getArrivalDate() == null) {
            purchaseArrival.setArrivalDate(LocalDate.now());
        }

        if (purchaseArrival.getStatus() == null) {
            purchaseArrival.setStatus("待验"); // 默认状态
        }

        int result = purchaseArrivalMapper.insert(purchaseArrival);
        if (result > 0) {
            return purchaseArrival;
        }
        return null;
    }

    @Override
    public PurchaseArrival getPurchaseArrivalById(Integer arrivalId) {
        return purchaseArrivalMapper.selectByArrivalId(arrivalId);
    }

    @Override
    public List<PurchaseArrival> getAllPurchaseArrivals() {
        return purchaseArrivalMapper.selectAllPurchaseArrivals();
    }

    @Override
    public List<PurchaseArrival> getPurchaseArrivalsByPoId(Integer poId) {
        return purchaseArrivalMapper.selectByPoId(poId);
    }

    @Override
    public List<PurchaseArrival> getPurchaseArrivalsBySkuId(Integer skuId) {
        return purchaseArrivalMapper.selectBySkuId(skuId);
    }

    @Override
    public PurchaseArrival updatePurchaseArrival(PurchaseArrival purchaseArrival) {
        int result = purchaseArrivalMapper.updatePurchaseArrival(purchaseArrival);
        if (result > 0) {
            return purchaseArrival;
        }
        return null;
    }

    @Override
    public boolean deletePurchaseArrivalById(Integer arrivalId) {
        int result = purchaseArrivalMapper.deleteByArrivalId(arrivalId);
        return result > 0;
    }

}
