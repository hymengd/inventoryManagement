package com.seig.backend.product.service.impl;

import com.seig.backend.product.entity.Medicines;
import com.seig.backend.product.mapper.MedicinesMapper;
import com.seig.backend.pojo.dto.MedicinesDto;
import com.seig.backend.product.service.MedicinesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicinesServiceImpl implements MedicinesService {
    @Autowired
    private MedicinesMapper medicinesMapper;
    @Override
    public List<Medicines> getAllMedicines() {
        List<Medicines> medicines = medicinesMapper.getAllMedicines();
        return medicines;
//        return medicines.stream().map((this::convertToDto))
//                .collect(Collectors.toList());
    }
    @Override
    public Medicines getMedicineById(Integer medicineId) {
        return medicinesMapper.getMedicineById(medicineId);
    }

    @Override
    public List<Medicines> selectByPrescriptionType(int prescriptionType) {
//         0-查询非处方， 1-查询处方
        return medicinesMapper.selectByPrescriptionType(prescriptionType);
    }

    @Override
    public List<String> getNameList() {
        return medicinesMapper.getNameList();
    }

    @Override
    public int updateMedicine(Medicines medicine) {
        return medicinesMapper.updateMedicine(medicine);
    }

    // 实体到DTO的转换方法
    private MedicinesDto convertToDto(Medicines medicine) {
        MedicinesDto dto = new MedicinesDto();

        // 使用BeanUtils复制相同字段
        BeanUtils.copyProperties(medicine, dto);

        return dto;
    }
    @Override
    public List<Medicines> searchByKeyword(String keyword) {
        return medicinesMapper.searchByKeyword(keyword);
    }
}
