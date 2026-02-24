package com.seig.backend.product.service.impl;

import com.seig.backend.pojo.dto.UpdatePrescriptionStatusDto;
import com.seig.backend.product.entity.Prescription;
import com.seig.backend.product.mapper.PrescriptionMapper;
import com.seig.backend.product.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    /**
     * 根据就诊记录ID获取处方列表
     */
    @Override
    public List<Prescription> getPrescriptionsByVisitId(Integer visitId) {
        return prescriptionMapper.selectByVisitId(visitId);
    }

    /**
     * 根据就诊记录ID删除处方
     */
    @Override
    public boolean deletePrescriptionsByVisitId(Integer visitId) {
        return prescriptionMapper.deleteByVisitId(visitId) > 0;
    }

    /**
     * 查询 completeTime 为空的药方记录
     */
    @Override
    public List<Prescription> getPrescriptionsByCompleteTimeIsNull() {
        return prescriptionMapper.selectByCompleteTimeIsNull();
    }
    @Override
    @Transactional
    public boolean batchUpdatePrescriptionStatus(List<UpdatePrescriptionStatusDto> statusDtos) {
        if (statusDtos == null || statusDtos.isEmpty()) {
            return false;
        }

        boolean allSuccess = true;
        for (UpdatePrescriptionStatusDto statusDto : statusDtos) {
            try {
                Prescription prescription = getPrescriptionById(statusDto.getPrescriptionId());
                if (prescription == null) {
                    allSuccess = false;
                    continue;
                }

                prescription.setStatus(statusDto.getStatus());

                // 根据状态设置相应的时间字段
                switch (statusDto.getStatus()) {
                    case 2: // 已锁定
                        prescription.setPharmacistId(statusDto.getPharmacistId());
                        prescription.setLockTime(LocalDateTime.now());
                        break;
                    case 3: // 发药中
                        prescription.setPharmacistId(statusDto.getPharmacistId());
                        break;
                    case 4: // 已完成
                        prescription.setPharmacistId(statusDto.getPharmacistId());
                        prescription.setCompleteTime(LocalDateTime.now());
                        break;
                    default:
                        break;
                }

                int result = prescriptionMapper.update(prescription);
                if (result <= 0) {
                    allSuccess = false;
                }
            } catch (Exception e) {
                allSuccess = false;
//                log.error("批量更新药方状态失败，ID: " + statusDto.getPrescriptionId(), e);
            }
        }

        return allSuccess;
    }

}
