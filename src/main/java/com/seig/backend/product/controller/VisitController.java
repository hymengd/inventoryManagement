package com.seig.backend.product.controller;

import com.seig.backend.common.Result;
import com.seig.backend.product.entity.Visit;
import com.seig.backend.product.service.VisitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/visits")
public class VisitController {
    
    private static final Logger log = LoggerFactory.getLogger(VisitController.class);
    
    @Autowired
    private VisitService visitService;
    
    /**
     * 创建就诊记录并关联处方
     */
    @PostMapping("/create")
    public Result<Visit> createVisit(@RequestBody Map<String, Object> requestData) {
        try {
            Integer doctorId = (Integer) requestData.get("doctorId");
            Integer patientId = (Integer) requestData.get("patientId");
            String chiefComplaint = (String) requestData.get("chiefComplaint");
            String diagnosis = (String) requestData.get("diagnosis");
            String medicines = (String) requestData.get("medicines");
            
            if (doctorId == null || patientId == null || chiefComplaint == null || diagnosis == null) {
                return Result.error(400, "参数不完整");
            }
            
            Visit visit = visitService.createVisitWithPrescription(doctorId, patientId, chiefComplaint, diagnosis, medicines);
            return Result.success("就诊记录创建成功", visit);
        } catch (Exception e) {
            log.error("创建就诊记录失败", e);
            return Result.error(500, "创建就诊记录失败: " + e.getMessage());
        }
    }
    
    /**
     * 根据患者ID或医生ID查询就诊记录及处方
     */
    @GetMapping("/query")
    public Result<Map<String, Object>> queryVisitsWithPrescriptions(
            @RequestParam Integer id,
            @RequestParam(defaultValue = "true") boolean isPatientId) {
        try {
            Map<String, Object> result = visitService.getVisitsWithPrescriptionsById(id, isPatientId);
            return Result.success("查询成功", result);
        } catch (Exception e) {
            log.error("查询就诊记录失败", e);
            return Result.error(500, "查询失败: " + e.getMessage());
        }
    }
    
    /**
     * 删除就诊记录及其关联处方
     */
    @DeleteMapping("/{visitId}")
    public Result<Void> deleteVisitWithPrescriptions(@PathVariable Integer visitId) {
        try {
            boolean success = visitService.deleteVisitWithPrescriptions(visitId);
            if (success) {
                return Result.success("删除成功");
            } else {
                return Result.error(404, "就诊记录不存在");
            }
        } catch (Exception e) {
            log.error("删除就诊记录失败", e);
            return Result.error(500, "删除失败: " + e.getMessage());
        }
    }
    
    /**
     * 更新就诊记录
     */
    @PutMapping("/{visitId}")
    public Result<Visit> updateVisit(@PathVariable Integer visitId, @RequestBody Visit visit) {
        try {
            visit.setVisitId(visitId);
            Visit updatedVisit = visitService.updateVisit(visit);
            if (updatedVisit != null) {
                return Result.success("更新成功", updatedVisit);
            } else {
                return Result.error(404, "就诊记录不存在");
            }
        } catch (Exception e) {
            log.error("更新就诊记录失败", e);
            return Result.error(500, "更新失败: " + e.getMessage());
        }
    }
    
    /**
     * 根据ID获取就诊记录详情
     */
    @GetMapping("/{visitId}")
    public Result<Visit> getVisitById(@PathVariable Integer visitId) {
        try {
            Visit visit = visitService.getVisitById(visitId);
            if (visit != null) {
                return Result.success("查询成功", visit);
            } else {
                return Result.error(404, "就诊记录不存在");
            }
        } catch (Exception e) {
            log.error("查询就诊记录失败", e);
            return Result.error(500, "查询失败: " + e.getMessage());
        }
    }
}
