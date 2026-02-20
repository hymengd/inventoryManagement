package com.seig.backend.product.service.impl;

import com.seig.backend.product.entity.Prescription;
import com.seig.backend.product.mapper.PrescriptionMapper;
import com.seig.backend.product.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {
    
    @Autowired
    private PrescriptionMapper prescriptionMapper;
    
    @Override
    public Prescription createPrescription(Prescription prescription) {
        // 设置默认值
        prescription.setStatus((byte) 0); // 默认状态为草稿
        prescription.setCreateTime(LocalDateTime.now());
        prescription.setUpdateTime(LocalDateTime.now());
        
        int result = prescriptionMapper.insert(prescription);
        if (result > 0) {
            return prescriptionMapper.selectById(prescription.getId());
        }
        return null;
    }
    
    @Override
    public Prescription getPrescriptionById(Long id) {
        return prescriptionMapper.selectById(id);
    }
    
    @Override
    public List<Prescription> getPrescriptionsByPatientId(Long patientId) {
        return prescriptionMapper.selectByPatientId(patientId);
    }
    
    @Override
    public List<Prescription> getPrescriptionsByDoctorId(Long doctorId) {
        return prescriptionMapper.selectByDoctorId(doctorId);
    }
    
    @Override
    public List<Prescription> getAllPrescriptions() {
        return prescriptionMapper.selectAll();
    }
    
    @Override
    public Prescription updatePrescription(Prescription prescription) {
        prescription.setUpdateTime(LocalDateTime.now());
        int result = prescriptionMapper.update(prescription);
        if (result > 0) {
            return prescriptionMapper.selectById(prescription.getId());
        }
        return null;
    }
    
    @Override
    public boolean deletePrescription(Long id) {
        return prescriptionMapper.deleteById(id) > 0;
    }
    
    @Override
    public List<Prescription> getPrescriptionsByStatus(Byte status) {
        return prescriptionMapper.selectByStatus(status);
    }
}
