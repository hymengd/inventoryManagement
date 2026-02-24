package com.seig.backend.product.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * 药方实体类
 */
public class Prescription {
    /**
     * 处方ID，主键
     */
    private Long id;

    /**
     * 患者ID，冗余
     */
    private Long patientId;

    /**
     * 开方医生ID，冗余
     */
    private Long doctorId;

    /**
     * 病情诊断，冗余
     */
    private String diagnosis;
    /**
     * 就诊记录ID，外键关联visits表
     */
    private Integer visitId;

    /**
     * 药品清单 [{skuId, brandName, spec, dosage, quantity, inventory}]
     */
    private String medicines;

    /**
     * 状态: 0草稿 1待抓药 2已锁定 3发药中 4已完成
     */
    private Byte status;

    /**
     * 领取药师ID
     */
    private Long pharmacistId;

    /**
     * 锁定时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime lockTime;

    /**
     * 完成时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime completeTime;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

    // 构造函数
    public Prescription() {
    }

    // Getter 和 Setter 方法
    public Long getId() {
        return id;
        }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getMedicines() {
        return medicines;
    }

    public Integer getVisitId() {
        return visitId;
    }

    public void setVisitId(Integer visitId) {
        this.visitId = visitId;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
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

    public LocalDateTime getLockTime() {
        return lockTime;
    }

    public void setLockTime(LocalDateTime lockTime) {
        this.lockTime = lockTime;
    }

    public LocalDateTime getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(LocalDateTime completeTime) {
        this.completeTime = completeTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 药品清单项内部类
     * 用于解析JSON格式的药品清单
     */
    public static class MedicineItem {
        private Long skuId;
        private String brandName;
        private String genericName;
        private String spec;
        private String dosage;
        private Integer quantity;
        private Integer inventory;

        // 构造函数
        public MedicineItem() {
        }

        public MedicineItem(Long id, String brandName, String spec, String dosage, Integer quantity, Integer inventory) {
            this.skuId = id;
            this.brandName = brandName;
            this.genericName = genericName;
            this.spec = spec;
            this.dosage = dosage;
            this.quantity = quantity;
            this.inventory = inventory;
        }

        // Getter 和 Setter 方法
        public Long getSkuId() {
            return skuId;
        }

        public void setSkuId(Long skuId) {
            this.skuId = skuId;
        }

        public String getBrandName() {
            return brandName;
        }

        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

        public String getSpec() {
            return spec;
        }

        public void setSpec(String spec) {
            this.spec = spec;
        }

        public String getDosage() {
            return dosage;
        }

        public void setDosage(String dosage) {
            this.dosage = dosage;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public Integer getInventory() {
            return inventory;
        }

        public void setInventory(Integer inventory) {
            this.inventory = inventory;
        }

        @Override
        public String toString() {
            return "MedicineItem{" +
                    "skuId=" + skuId +
                    ", brandName='" + brandName + '\'' +
                    ", genericName='" + genericName + '\'' +
                    ", spec='" + spec + '\'' +
                    ", dosage='" + dosage + '\'' +
                    ", quantity=" + quantity +
                    ", inventory=" + inventory +
                    '}';
        }
    }
}
