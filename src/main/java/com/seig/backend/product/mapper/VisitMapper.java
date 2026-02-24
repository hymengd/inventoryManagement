package com.seig.backend.product.mapper;

import com.seig.backend.product.entity.Visit;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface VisitMapper {
    
    /**
     * 插入新的就诊记录
     */
    int insert(Visit visit);
    
    /**
     * 根据ID查询就诊记录
     */
    Visit selectById(Integer visitId);
    
    /**
     * 根据患者ID查询就诊记录列表
     */
    List<Visit> selectByPatientId(Integer patientId);
    
    /**
     * 根据医生ID查询就诊记录列表
     */
    List<Visit> selectByDoctorId(Integer doctorId);
    
    /**
     * 查询所有就诊记录
     */
    List<Visit> selectAll();
    
    /**
     * 更新就诊记录信息
     */
    int update(Visit visit);
    
    /**
     * 删除就诊记录
     */
    int deleteById(Integer visitId);
}
