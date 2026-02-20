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
     * 药品清单 [{id, name, spec, dose, qty, inventory}]
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
        private Long id;
        private String name;
        private String spec;
        private String dose;
        private Integer qty;
        private Integer inventory;

        // 构造函数
        public MedicineItem() {
        }

        public MedicineItem(Long id, String name, String spec, String dose, Integer qty, Integer inventory) {
            this.id = id;
            this.name = name;
            this.spec = spec;
            this.dose = dose;
            this.qty = qty;
            this.inventory = inventory;
        }

        // Getter 和 Setter 方法
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSpec() {
            return spec;
        }

        public void setSpec(String spec) {
            this.spec = spec;
        }

        public String getDose() {
            return dose;
        }

        public void setDose(String dose) {
            this.dose = dose;
        }

        public Integer getQty() {
            return qty;
        }

        public void setQty(Integer qty) {
            this.qty = qty;
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
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", spec='" + spec + '\'' +
                    ", dose='" + dose + '\'' +
                    ", qty=" + qty +
                    ", inventory=" + inventory +
                    '}';
        }
    }
}
