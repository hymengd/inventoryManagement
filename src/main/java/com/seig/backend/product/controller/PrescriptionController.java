package com.seig.backend.product.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seig.backend.common.Result;
import com.seig.backend.pojo.dto.PrescriptionDto;
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
}
