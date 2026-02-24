package com.seig.backend.product.mapper;


import com.seig.backend.product.entity.Medicines;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MedicinesMapper {
    /**
     * 获取所有药品信息
     * @return
     */
    List<Medicines> getAllMedicines();

    Medicines getMedicineById(Integer medicineId);

    /**
     * 根据处方类型查询药品所有的信息，0-非处方，1-处方
     * @param prescriptionType
     * @return
     */
    List<Medicines> selectByPrescriptionType(int prescriptionType);

    List<String> getNameList();

    /**
     * 动态更新药品信息（只更新非空字段）
     */
    int updateMedicine(Medicines medicine);

    /**
     * 强制全字段更新（包含空值）
     */
    int updateMedicineFull(Medicines medicine);

    /**
     * 根据关键字搜索药品（在medicine_code、generic_name、english_name、chemical_name中搜索）
     * @param keyword 搜索关键字
     * @return 符合条件的药品列表
     */
    List<Medicines> searchByKeyword(String keyword);

}
