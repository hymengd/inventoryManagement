package com.seig.backend.pojo.dto;

/**
 * 更新药方状态DTO
 */
public class UpdatePrescriptionStatusDto {
    
    /**
     * 药方ID
     */
    private Long prescriptionId;
    
    /**
     * 新的状态: 0草稿 1待抓药 2已锁定 3发药中 4已完成
     */
    private Byte status;
    
    /**
     * 药师ID（当状态为已锁定、发药中、已完成时需要）
     */
    private Long pharmacistId;
    
    // 构造函数
    public UpdatePrescriptionStatusDto() {
    }
    
    public UpdatePrescriptionStatusDto(Long prescriptionId, Byte status, Long pharmacistId) {
        this.prescriptionId = prescriptionId;
        this.status = status;
        this.pharmacistId = pharmacistId;
    }
    
    // Getter 和 Setter 方法
    public Long getPrescriptionId() {
        return prescriptionId;
    }
    
    public void setPrescriptionId(Long prescriptionId) {
        this.prescriptionId = prescriptionId;
    }
    
    public Byte getStatus() {
        return status;
    }
    
    public void setStatus(Byte status) {
        this.status = status;
    }
    
    public Long getPharmacistId() {
        return pharmacistId;
    }
    
    public void setPharmacistId(Long pharmacistId) {
        this.pharmacistId = pharmacistId;
    }
    
    @Override
    public String toString() {
        return "UpdatePrescriptionStatusDto{" +
                "prescriptionId=" + prescriptionId +
                ", status=" + status +
                ", pharmacistId=" + pharmacistId +
                '}';
    }
}
