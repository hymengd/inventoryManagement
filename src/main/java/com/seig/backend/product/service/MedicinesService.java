package com.seig.backend.product.service;

import com.seig.backend.product.entity.Medicines;

import java.util.List;

public interface MedicinesService {
    List<Medicines> getAllMedicines();
    Medicines getMedicineById(Integer medicineId);
    List<Medicines> selectByPrescriptionType(int prescriptionType);
    List<String> getNameList();
    int updateMedicine(Medicines medicine);

    /**
     * 根据关键字搜索药品
     * @param keyword 搜索关键字
     * @return 符合条件的药品列表
     */
    List<Medicines> searchByKeyword(String keyword);

}
