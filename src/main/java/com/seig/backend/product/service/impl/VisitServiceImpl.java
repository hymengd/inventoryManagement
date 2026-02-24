package com.seig.backend.product.service.impl;

import com.seig.backend.product.entity.Visit;
import com.seig.backend.product.entity.Prescription;
import com.seig.backend.product.mapper.VisitMapper;
import com.seig.backend.product.mapper.PrescriptionMapper;
import com.seig.backend.product.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VisitServiceImpl implements VisitService {
    
    @Autowired
    private VisitMapper visitMapper;
    
    @Autowired
    private PrescriptionMapper prescriptionMapper;
    
    @Override
    @Transactional
    public Visit createVisitWithPrescription(Integer doctorId, Integer patientId, 
                                           String chiefComplaint, String diagnosis, String medicines) {
        // 1. 创建就诊记录
        Visit visit = new Visit();
        visit.setPatientId(patientId);
        visit.setDoctorId(doctorId);
        visit.setVisitTime(LocalDateTime.now());
        visit.setChiefComplaint(chiefComplaint);
        visit.setDiagnosis(diagnosis);
        visit.setCreatedAt(LocalDateTime.now());
        visit.setUpdatedAt(LocalDateTime.now());
        
        int visitResult = visitMapper.insert(visit);
        if (visitResult <= 0) {
            throw new RuntimeException("创建就诊记录失败");
        }
        
        // 2. 创建关联的处方记录
        Prescription prescription = new Prescription();
        prescription.setPatientId(Long.valueOf(patientId));
        prescription.setDoctorId(Long.valueOf(doctorId));
        prescription.setDiagnosis(diagnosis);
        prescription.setVisitId(visit.getVisitId()); // 关联就诊记录
        prescription.setMedicines(medicines);   // 处方中的药品
        prescription.setStatus((byte) 1); // 0草稿状态 1代抓药状态
        prescription.setCreateTime(LocalDateTime.now());
        prescription.setUpdateTime(LocalDateTime.now());
        
        int prescriptionResult = prescriptionMapper.insert(prescription);
        if (prescriptionResult <= 0) {
            throw new RuntimeException("创建处方记录失败");
        }
        
        return visit;
    }
    
    @Override
    public Map<String, Object> getVisitsWithPrescriptionsById(Integer id, boolean isPatientId) {
        List<Visit> visits;
        if (isPatientId) {
            visits = visitMapper.selectByPatientId(id);
        } else {
            visits = visitMapper.selectByDoctorId(id);
        }
        
        Map<String, Object> result = new HashMap<>();
        result.put("visits", visits);
        
        // 获取关联的处方记录
        List<Prescription> prescriptions = prescriptionMapper.selectByPatientId(Long.valueOf(id));
        result.put("prescriptions", prescriptions);
        
        return result;
    }
    
    @Override
    @Transactional
    public boolean deleteVisitWithPrescriptions(Integer visitId) {
        // 1. 先删除关联的处方记录
        int prescriptionResult = prescriptionMapper.deleteByVisitId(visitId);
        
        // 2. 再删除就诊记录
        int visitResult = visitMapper.deleteById(visitId);
        
        return visitResult > 0;
    }
    
    @Override
    public Visit updateVisit(Visit visit) {
        visit.setUpdatedAt(LocalDateTime.now());
        int result = visitMapper.update(visit);
        if (result > 0) {
            return visitMapper.selectById(visit.getVisitId());
        }
        return null;
    }
    
    @Override
    public Visit getVisitById(Integer visitId) {
        return visitMapper.selectById(visitId);
    }
    
    @Override
    public List<Visit> getAllVisits() {
        return visitMapper.selectAll();
    }



}
