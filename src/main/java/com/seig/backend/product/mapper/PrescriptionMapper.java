package com.seig.backend.product.mapper;

import com.seig.backend.product.entity.Prescription;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PrescriptionMapper {
    
    /**
     * 插入新的药方记录
     */
    int insert(Prescription prescription);
    
    /**
     * 根据ID查询药方
     */
    Prescription selectById(Long id);
    
    /**
     * 根据患者ID查询药方列表
     */
    List<Prescription> selectByPatientId(Long patientId);
    
    /**
     * 根据医生ID查询药方列表
     */    List<Prescription> selectByDoctorId(Long doctorId);
    
    /**
     * 查询所有药方
     */    List<Prescription> selectAll();
    
    /**
     * 更新药方信息
     */
    int update(Prescription prescription);
    
    /**
     * 删除药方
     */
    int deleteById(Long id);
    
    /**
     * 根据状态查询药方
     */    List<Prescription> selectByStatus(Byte status);

    /**
     * 根据就诊记录ID查询药方
     */
    List<Prescription> selectByVisitId(Integer visitId);

    /**
     * 根据就诊记录ID删除药方
     */
    int deleteByVisitId(Integer visitId);


    /**
     * 查询 completeTime 为空的药方记录
     */
    List<Prescription> selectByCompleteTimeIsNull();


}
