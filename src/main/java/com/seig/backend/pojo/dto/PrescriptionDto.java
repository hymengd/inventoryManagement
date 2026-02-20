package com.seig.backend.pojo.dto;

import com.seig.backend.product.entity.Prescription;

import java.util.List;

/**
 * 药方创建请求DTO
 */
public class PrescriptionDto {
    
    /**
     * 患者ID
     */
    private Long patientId;
    
    /**
     * 开方医生ID
     */
    private Long doctorId;
    
    /**
     * 病情诊断
     */
    private String diagnosis;
    
    /**
     * 药品清单
     */
    private List<Prescription.MedicineItem> medicines;
    
    // 构造函数
    public PrescriptionDto() {
    }
    
    public PrescriptionDto(Long patientId, Long doctorId, String diagnosis, List<Prescription.MedicineItem> medicines) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.diagnosis = diagnosis;
        this.medicines = medicines;
    }
    
    // Getter 和 Setter 方法
    public Long getPatientId() {
        return patientId;
    }
    
    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
    
    public Long getDoctorId() {
        return doctorId;
    }
    
    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }
    
    public String getDiagnosis() {
        return diagnosis;
    }
    
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    
    public List<Prescription.MedicineItem> getMedicines() {
        return medicines;
    }
    
    public void setMedicines(List<Prescription.MedicineItem> medicines) {
        this.medicines = medicines;
    }
    
    @Override
    public String toString() {
        return "PrescriptionDto{" +
                "patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", diagnosis='" + diagnosis + '\'' +
                ", medicines=" + medicines +
                '}';
    }
}
