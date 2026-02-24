package com.seig.backend.product.service;

import com.seig.backend.product.entity.Visit;
import com.seig.backend.product.entity.Prescription;

import java.util.List;
import java.util.Map;

public interface VisitService {
    
    /**
     * 创建就诊记录并关联处方
     * @param doctorId 医生ID
     * @param patientId 患者ID  
     * @param chiefComplaint 主诉
     * @param diagnosis 诊断结果
     * @return 创建的就诊记录
     */
    Visit createVisitWithPrescription(Integer doctorId, Integer patientId, 
                                     String chiefComplaint, String diagnosis, String medicines);
    
    /**
     * 根据患者ID或医生ID查询就诊记录及关联的处方
     * @param id 患者ID或医生ID
     * @param isPatientId true表示按患者ID查询，false表示按医生ID查询
     * @return 包含就诊记录和处方的Map
     */
    Map<String, Object> getVisitsWithPrescriptionsById(Integer id, boolean isPatientId);
    
    /**
     * 删除就诊记录及其关联的处方
     * @param visitId 就诊记录ID
     * @return 是否删除成功
     */
    boolean deleteVisitWithPrescriptions(Integer visitId);
    
    /**
     * 更新就诊记录
     * @param visit 就诊记录对象
     * @return 更新后的就诊记录
     */
    Visit updateVisit(Visit visit);
    
    /**
     * 根据ID获取就诊记录
     * @param visitId 就诊记录ID
     * @return 就诊记录
     */
    Visit getVisitById(Integer visitId);
    
    /**
     * 获取所有就诊记录
     * @return 就诊记录列表
     */
    List<Visit> getAllVisits();
}
