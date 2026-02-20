package com.seig.backend.product.service.impl;

import com.seig.backend.product.entity.MedicineSku;
import com.seig.backend.product.mapper.MedicineSkuMapper;
import com.seig.backend.product.service.MedicineSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MedicineSkuServiceImpl implements MedicineSkuService {

    @Autowired
    private MedicineSkuMapper medicineSkuMapper;

    @Override
    public MedicineSku createMedicineSku(MedicineSku medicineSku) {
        int result = medicineSkuMapper.insert(medicineSku);
        if (result > 0) {
            return medicineSku;
        }
        return null;
    }

    @Override
    public MedicineSku getMedicineSkuById(Integer skuId) {
        return medicineSkuMapper.selectById(skuId);
    }

    @Override
    public List<MedicineSku> getAllMedicineSkus() {
        return medicineSkuMapper.selectAll();
    }

    @Override
    public List<MedicineSku> getMedicineSkusByMedicineId(Integer medicineId) {
        return medicineSkuMapper.selectByMedicineId(medicineId);
    }

    @Override
    public MedicineSku updateMedicineSku(MedicineSku medicineSku) {
        int result = medicineSkuMapper.update(medicineSku);
        if (result > 0) {
            return medicineSku;
        }
        return null;
    }

    @Override
    public boolean deleteMedicineSku(Integer skuId) {
        int result = medicineSkuMapper.deleteById(skuId);
        return result > 0;
    }
    @Override
    public List<MedicineSku> getMedicineSkusBySupplierId(Integer supplierId) {
        return medicineSkuMapper.selectBySupplierId(supplierId);
    }
}
