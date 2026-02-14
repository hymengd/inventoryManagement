package com.seig.backend.service;

import com.seig.backend.entity.MedicineSku;

import java.math.BigDecimal;
import java.util.List;

public interface MedicineSkuService {
    MedicineSku createMedicineSku(MedicineSku medicineSku);
    MedicineSku getMedicineSkuById(Integer skuId);
    List<MedicineSku> getAllMedicineSkus();
    List<MedicineSku> getMedicineSkusByMedicineId(Integer medicineId);
    MedicineSku updateMedicineSku(MedicineSku medicineSku);
    boolean deleteMedicineSku(Integer skuId);
    List<MedicineSku> getMedicineSkusBySupplierId(Integer supplierId);






}
