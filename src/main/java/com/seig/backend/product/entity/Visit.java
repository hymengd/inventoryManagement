package com.seig.backend.product.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * 就诊记录实体类
 * 对应数据库表：visits
 */
public class Visit {
    /**
     * 就诊记录ID，主键自增
     */
    private Integer visitId;

    /**
     * 患者ID
     */
    private Integer patientId;

    /**
     * 医生ID
     */
    private Integer doctorId;

    /**
     * 就诊时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime visitTime;

    /**
     * 主诉，患者自述症状
     */
    private String chiefComplaint;

    /**
     * 诊断结果
     */
    private String diagnosis;

    /**
     * 记录创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createdAt;

    /**
     * 记录最后更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updatedAt;

    // 构造函数
    public Visit() {
    }

    public Visit(Integer patientId, Integer doctorId, LocalDateTime visitTime, 
                 String chiefComplaint, String diagnosis) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.visitTime = visitTime;
        this.chiefComplaint = chiefComplaint;
        this.diagnosis = diagnosis;
    }

    // Getter 和 Setter 方法
    public Integer getVisitId() {
        return visitId;
    }

    public void setVisitId(Integer visitId) {
        this.visitId = visitId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDateTime getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(LocalDateTime visitTime) {
        this.visitTime = visitTime;
    }

    public String getChiefComplaint() {
        return chiefComplaint;
    }

    public void setChiefComplaint(String chiefComplaint) {
        this.chiefComplaint = chiefComplaint;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "visitId=" + visitId +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", visitTime=" + visitTime +
                ", chiefComplaint='" + chiefComplaint + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
