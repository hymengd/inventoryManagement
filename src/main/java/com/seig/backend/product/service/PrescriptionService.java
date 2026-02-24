package com.seig.backend.product.service;

import com.seig.backend.pojo.dto.UpdatePrescriptionStatusDto;
import com.seig.backend.product.entity.Prescription;

import java.util.List;

public interface PrescriptionService {
    
    /**
     * 医生开方
     */
    Prescription createPrescription(Prescription prescription);
    
    /**
     * 根据ID获取药方详情
     */
    Prescription getPrescriptionById(Long id);
    
    /**
     * 根据患者ID获取药方列表
     */
    List<Prescription> getPrescriptionsByPatientId(Long patientId);
    
    /**
     * 根据医生ID获取药方列表
     */
    List<Prescription> getPrescriptionsByDoctorId(Long doctorId);
    
    /**
     * 获取所有药方
     */
    List<Prescription> getAllPrescriptions();
    
    /**
     * 更新药方
     */
    Prescription updatePrescription(Prescription prescription);
    
    /**
     * 删除药方
     */
    boolean deletePrescription(Long id);
    
    /**
     * 根据状态获取药方列表
     */
    List<Prescription> getPrescriptionsByStatus(Byte status);


    List<Prescription> getPrescriptionsByVisitId(Integer visitId);

    boolean deletePrescriptionsByVisitId(Integer visitId);
    List<Prescription> getPrescriptionsByCompleteTimeIsNull();


    /**
     * 批量更新药方状态
     */
    boolean batchUpdatePrescriptionStatus(List<UpdatePrescriptionStatusDto> statusDtos);


}
