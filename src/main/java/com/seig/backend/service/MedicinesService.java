package com.seig.backend.service;

import com.seig.backend.entity.Medicines;
import com.seig.backend.pojo.dto.MedicinesDto;

import java.util.List;

public interface MedicinesService {
    List<Medicines> getAllMedicines();
    Medicines getMedicineById(Integer medicineId);
    List<Medicines> selectByPrescriptionType(int prescriptionType);
    List<String> getNameList();
    int updateMedicine(Medicines medicine);

}
