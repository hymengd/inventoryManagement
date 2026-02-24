package com.seig.backend.product.service;

import com.seig.backend.product.entity.MedicineSku;

import java.util.List;

public interface MedicineSkuService {
    MedicineSku createMedicineSku(MedicineSku medicineSku);
    MedicineSku getMedicineSkuById(Integer skuId);
    List<MedicineSku> getAllMedicineSkus();
    List<MedicineSku> getMedicineSkusByMedicineId(Integer medicineId);
    List<MedicineSku> getMedicineSkusByGenericName(String genericName);
    List<MedicineSku> getMedicineSkusByEnglishName(String englishName);
    List<MedicineSku> getMedicineSkusByChemicalName(String chemicalName);
    List<MedicineSku> searchMedicineSkus(String genericName, String englishName, String chemicalName,  String brandName);

    /**
     * 根据关键字统一搜索SKU
     */
    List<MedicineSku> searchByKeyword(String keyword);

    MedicineSku updateMedicineSku(MedicineSku medicineSku);
    boolean deleteMedicineSku(Integer skuId);
    List<MedicineSku> getMedicineSkusBySupplierId(Integer supplierId);




}
