package com.seig.backend.product.controller;

import com.seig.backend.common.Result;
import com.seig.backend.product.entity.Medicines;
import com.seig.backend.product.service.MedicinesService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/medicines")
public class MedicinesController {

    @Autowired
    private MedicinesService medicinesService;
    private static final Logger log = LoggerFactory.getLogger(MedicinesController.class);

    @GetMapping("/getAllMedicines")
    public List<Medicines> getAllMedicines() {

        System.out.println("getAllMedicines() called");
        List<Medicines> medicines = medicinesService.getAllMedicines();
//        if (!medicines.isEmpty()) {
//            System.out.println(medicines.get(0));
//            System.out.println(medicines.get(0).getClass());
//            Medicines a = medicines.get(0);
//            log.info("medicineId: {}",
//                    a.getKK());
//            log.info("genericName: {}", a.getGenericName());
//            medicines.forEach(medicine -> {
//                System.out.println("medicineId: " + medicine.getKK());
//                System.out.println("genericName: " + medicine.getGenericName());
//            });
//        }
//        Map<String, Object> response = new HashMap<>();
//        response.put("data", medicines);
//        response.put("success", true);
//        response.put("message", "获取成功");
//        response.put("count", medicines.size());
//        // 记录最终响应数据
//        System.out.println("返回的响应数据: " + response);

        return medicines;

    }
    @GetMapping("/{medicineId}")
    public Result<Medicines> getMedicineById(@PathVariable Integer medicineId) {
        try {
            Medicines medicine = medicinesService.getMedicineById(medicineId);
            if (medicine != null) {
                return Result.success("查询成功", medicine);
            } else {
                return Result.error(404, "药品不存在", null);
            }
        } catch (Exception e) {
            return Result.error(500, "查询失败：" + e.getMessage(), null);
        }
    }

    @GetMapping("/selectByPrescriptionType")
    public List<Medicines> selectByPrescriptionType(int prescriptionType) {
        return medicinesService.selectByPrescriptionType(prescriptionType);
    }

    @GetMapping("/getNameList")
    public ResponseEntity<Map<String, Object>> getNameList() {
        System.out.println("getNameList() called");
        try {
            List<String> nameList = medicinesService.getNameList();

            Map<String, Object> response = new HashMap<>();
            response.put("data", nameList);
            response.put("success", true);
            response.put("message", "获取成功");

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println("Error in getNameList(): " + e.getMessage());
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("data", null);
            errorResponse.put("success", false);
            errorResponse.put("message", "获取失败：" + e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PutMapping("/updateMedicinesById")
    public Result<Void> updateMedicinesById(@RequestBody @Valid Medicines dto) {
        Medicines medicine = new Medicines();
        BeanUtils.copyProperties(dto, medicine);

        int rows = medicinesService.updateMedicine(dto);
        return rows > 0
                ? Result.success("更新成功")           // 返回：{code: 200, message: "更新成功"}
                : Result.error("更新失败，药品不存在");  // 返回：{code: 500, message: "更新失败，药品不存在"}
    }
//    @PostMapping("/update") //替代"/updateMedicinesById"
//    public Result<Void> updateMedicine(@RequestBody MedicinesDto dto) {
//        try {
//            Medicines medicine = new Medicines();
//            BeanUtils.copyProperties(dto, medicine); // 将 DTO 转换为实体类
//            int rows = medicinesService.updateMedicine(medicine);
//            return rows > 0
//                    ? Result.success("更新成功")
//                    : Result.error("更新失败，药品不存在");
//        } catch (Exception e) {
//            return Result.error("更新异常：" + e.getMessage());
//        }
//    }

}
