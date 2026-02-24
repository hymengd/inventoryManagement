package com.seig.backend.product.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seig.backend.common.Result;
import com.seig.backend.pojo.dto.PrescriptionDto;
import com.seig.backend.pojo.dto.UpdatePrescriptionStatusDto;
import com.seig.backend.product.entity.Prescription;
import com.seig.backend.product.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 医生开方接口
     * POST /prescriptions/create
     */
    @PostMapping("/create")
    public Result<Prescription> createPrescription(@RequestBody PrescriptionDto prescriptionDto) {
        try {
            // 参数验证
            if (prescriptionDto.getPatientId() == null) {
                return Result.error(400, "患者ID不能为空");
            }
            if (prescriptionDto.getDoctorId() == null) {
                return Result.error(400, "医生ID不能为空");
            }
            if (prescriptionDto.getMedicines() == null || prescriptionDto.getMedicines().isEmpty()) {
                return Result.error(400, "药品清单不能为空");
            }
            // 将DTO转换为实体对象
            Prescription prescription = new Prescription();
            prescription.setPatientId(prescriptionDto.getPatientId());
            prescription.setDoctorId(prescriptionDto.getDoctorId());
            prescription.setDiagnosis(prescriptionDto.getDiagnosis());

            // 将药品清单转换为JSON字符串
            String medicinesJson = objectMapper.writeValueAsString(prescriptionDto.getMedicines());
            prescription.setMedicines(medicinesJson);
            System.out.println(medicinesJson);
            Prescription created = prescriptionService.createPrescription(prescription);
            if (created != null) {
                return Result.success("开方成功", created);
            } else {
                return Result.error(500, "开方失败");
            }
        } catch (JsonProcessingException e) {
            return Result.error(400, "药品清单格式错误: " + e.getMessage());
        } catch (Exception e) {
            return Result.error(500, "开方异常: " + e.getMessage());
        }
    }

    /**
     * 获取药方详情
     * GET /prescriptions/{id}
     */
    @GetMapping("/{id}")
    public Result<Prescription> getPrescription(@PathVariable Long id) {
        Prescription prescription = prescriptionService.getPrescriptionById(id);
        if (prescription != null) {
            return Result.success("查询成功", prescription);
        } else {
            return Result.error(404, "药方不存在");
        }
    }

    /**
     * 根据患者ID获取药方列表
     * GET /prescriptions/patient/{patientId}
     */
    @GetMapping("/patient/{patientId}")
    public Result<List<Prescription>> getPrescriptionsByPatient(@PathVariable Long patientId) {
        List<Prescription> prescriptions = prescriptionService.getPrescriptionsByPatientId(patientId);
        return Result.success("查询成功", prescriptions);
    }

    /**
     * 根据医生ID获取药方列表
     * GET /prescriptions/doctor/{doctorId}
     */
    @GetMapping("/doctor/{doctorId}")
    public Result<List<Prescription>> getPrescriptionsByDoctor(@PathVariable Long doctorId) {
        List<Prescription> prescriptions = prescriptionService.getPrescriptionsByDoctorId(doctorId);
        return Result.success("查询成功", prescriptions);
    }

    /**
     * 获取所有药方
     * GET /prescriptions
     */
    @GetMapping
    public Result<List<Prescription>> getAllPrescriptions() {
        List<Prescription> prescriptions = prescriptionService.getAllPrescriptions();
        return Result.success("查询成功", prescriptions);
    }

    /**
     * 更新药方
     * PUT /prescriptions/{id}
     */
    @PutMapping("/{id}")
    public Result<Prescription> updatePrescription(@PathVariable Long id, @RequestBody PrescriptionDto prescriptionDto) {
        try {
            Prescription prescription = prescriptionService.getPrescriptionById(id);
            if (prescription == null) {
                return Result.error(404, "药方不存在");
            }

            // 更新药方信息
            prescription.setDiagnosis(prescriptionDto.getDiagnosis());

            // 更新药品清单
            if (prescriptionDto.getMedicines() != null && !prescriptionDto.getMedicines().isEmpty()) {
                String medicinesJson = objectMapper.writeValueAsString(prescriptionDto.getMedicines());
                prescription.setMedicines(medicinesJson);
            }

            Prescription updated = prescriptionService.updatePrescription(prescription);
            if (updated != null) {
                return Result.success("更新成功", updated);
            } else {
                return Result.error(500, "更新失败");
            }
        } catch (JsonProcessingException e) {
            return Result.error(400, "药品清单格式错误: " + e.getMessage());
        } catch (Exception e) {
            return Result.error(500, "更新异常: " + e.getMessage());
        }
    }

    /**
     * 删除药方
     * DELETE /prescriptions/{id}
     */
    @DeleteMapping("/{id}")
    public Result<Void> deletePrescription(@PathVariable Long id) {
        boolean deleted = prescriptionService.deletePrescription(id);
        if (deleted) {
            return Result.success("删除成功");
        } else {
            return Result.error(500, "删除失败");
        }
    }

    /**
     * 根据状态获取药方列表
     * GET /prescriptions/status/{status}
     */
    @GetMapping("/status/{status}")
    public Result<List<Prescription>> getPrescriptionsByStatus(@PathVariable Byte status) {
        List<Prescription> prescriptions = prescriptionService.getPrescriptionsByStatus(status);
        return Result.success("查询成功", prescriptions);
    }

    /**
     * 查询 completeTime 为空的药方记录
     * GET /prescriptions/complete-null
     */
    @GetMapping("/complete-null")
    public Result<List<Prescription>> getPrescriptionsByCompleteTimeIsNull() {
        List<Prescription> prescriptions = prescriptionService.getPrescriptionsByCompleteTimeIsNull();
        return Result.success("查询成功", prescriptions);
    }
    /**
     * 更新药方状态
     * PUT /prescriptions/{id}/status
     */
    @PutMapping("/{id}/status")
    public Result<Prescription> updatePrescriptionStatus(@PathVariable Long id, @RequestBody UpdatePrescriptionStatusDto statusDto) {
        try {
            // 参数验证
            if (statusDto.getStatus() == null) {
                return Result.error(400, "状态不能为空");
            }

            // 验证状态值范围 (0-4)
            if (statusDto.getStatus() < 0 || statusDto.getStatus() > 4) {
                return Result.error(400, "状态值必须在0-4之间");
            }

            // 当状态为已锁定、发药中、已完成时，药师ID不能为空
            if ((statusDto.getStatus() == 2 || statusDto.getStatus() == 3 || statusDto.getStatus() == 4)
                    && statusDto.getPharmacistId() == null) {
                return Result.error(400, "状态为已锁定、发药中或已完成时，药师ID不能为空");
            }

            Prescription prescription = prescriptionService.getPrescriptionById(id);
            if (prescription == null) {
                return Result.error(404, "药方不存在");
            }

            // 更新状态相关信息
            prescription.setStatus(statusDto.getStatus());

            // 根据状态设置相应的时间字段
            switch (statusDto.getStatus()) {
                case 2: // 已锁定
                    prescription.setPharmacistId(statusDto.getPharmacistId());
                    prescription.setLockTime(java.time.LocalDateTime.now());
                    break;
                case 3: // 发药中
                    prescription.setPharmacistId(statusDto.getPharmacistId());
                    // 保持原有的锁定时间
                    break;
                case 4: // 已完成
                    prescription.setPharmacistId(statusDto.getPharmacistId());
                    prescription.setCompleteTime(java.time.LocalDateTime.now());
                    break;
                default:
                    // 草稿(0)和待抓药(1)状态不需要特殊处理
                    break;
            }

            Prescription updated = prescriptionService.updatePrescription(prescription);
            if (updated != null) {
                return Result.success("状态更新成功", updated);
            } else {
                return Result.error(500, "状态更新失败");
            }
        } catch (Exception e) {
            return Result.error(500, "状态更新异常: " + e.getMessage());
        }
    }

    /**
     * 批量更新药方状态
     * PUT /prescriptions/batch/status
     */
    @PutMapping("/batch/status")
    public Result<Void> batchUpdatePrescriptionStatus(@RequestBody List<UpdatePrescriptionStatusDto> statusDtos) {
        try {
            if (statusDtos == null || statusDtos.isEmpty()) {
                return Result.error(400, "批量更新列表不能为空");
            }

            int successCount = 0;
            int failCount = 0;
            StringBuilder errorMsg = new StringBuilder();

            for (UpdatePrescriptionStatusDto statusDto : statusDtos) {
                try {
                    // 复用单个更新的逻辑
                    Result<Prescription> result = updatePrescriptionStatus(statusDto.getPrescriptionId(), statusDto);
                    if (result.getCode() == 200) {
                        successCount++;
                    } else {
                        failCount++;
                        errorMsg.append("ID ").append(statusDto.getPrescriptionId())
                                .append(": ").append(result.getMessage()).append("; ");
                    }
                } catch (Exception e) {
                    failCount++;
                    errorMsg.append("ID ").append(statusDto.getPrescriptionId())
                            .append(": 异常 - ").append(e.getMessage()).append("; ");
                }
            }

            if (failCount == 0) {
                return Result.success("批量更新成功，共更新 " + successCount + " 条记录");
            } else {
                return Result.error(500, "批量更新部分失败: 成功" + successCount + "条，失败" + failCount + "条。错误详情: " + errorMsg.toString());
            }
        } catch (Exception e) {
            return Result.error(500, "批量更新异常: " + e.getMessage());
        }
    }
}
