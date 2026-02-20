package com.seig.backend.product.service;

import com.seig.backend.product.entity.Medicines;

import java.util.List;

public interface MedicinesService {
    List<Medicines> getAllMedicines();
    Medicines getMedicineById(Integer medicineId);
    List<Medicines> selectByPrescriptionType(int prescriptionType);
    List<String> getNameList();
    int updateMedicine(Medicines medicine);

}
