package com.seig.backend.product.controller;

import com.seig.backend.common.Result;
import com.seig.backend.product.entity.MedicineSku;
import com.seig.backend.product.service.MedicineSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicineSku")
public class MedicineSkuController {

    @Autowired
    private MedicineSkuService medicineSkuService;

    @PostMapping("/add")
    public Result<MedicineSku> createMedicineSku(@RequestBody MedicineSku medicineSku) {
        try {
            MedicineSku createdSku = medicineSkuService.createMedicineSku(medicineSku);
            if (createdSku != null) {
                return Result.success("SKU创建成功", createdSku);
            } else {
                return Result.error(500, "SKU创建失败", null);
            }
        } catch (Exception e) {
            return Result.error(500, "创建SKU时发生错误：" + e.getMessage(), null);
        }
    }

    @GetMapping("/{skuId}")
    public Result<MedicineSku> getMedicineSkuById(@PathVariable Integer skuId) {
        try {
            MedicineSku medicineSku = medicineSkuService.getMedicineSkuById(skuId);
            if (medicineSku != null) {
                return Result.success("查询成功", medicineSku);
            } else {
                return Result.error(404, "SKU不存在", null);
            }
        } catch (Exception e) {
            return Result.error(500, "查询SKU时发生错误：" + e.getMessage(), null);
        }
    }

    @GetMapping("/getAll")
    public Result<List<MedicineSku>> getAllMedicineSkus() {
        try {
            List<MedicineSku> skus = medicineSkuService.getAllMedicineSkus();
            return Result.success("查询成功", skus);
        } catch (Exception e) {
            return Result.error(500, "查询SKU列表时发生错误：" + e.getMessage(), null);
        }
    }

    @GetMapping("/byMedicine/{medicineId}")
    public Result<List<MedicineSku>> getMedicineSkusByMedicineId(@PathVariable Integer medicineId) {
        try {
            List<MedicineSku> skus = medicineSkuService.getMedicineSkusByMedicineId(medicineId);
            return Result.success("查询成功", skus);
        } catch (Exception e) {
            return Result.error(500, "查询SKU列表时发生错误：" + e.getMessage(), null);
        }
    }

    @PutMapping("/{skuId}")
    public Result<MedicineSku> updateMedicineSku(@PathVariable Integer skuId, @RequestBody MedicineSku medicineSku) {
        try {
            medicineSku.setSkuId(skuId);
            MedicineSku updatedSku = medicineSkuService.updateMedicineSku(medicineSku);
            if (updatedSku != null) {
                return Result.success("SKU更新成功", updatedSku);
            } else {
                return Result.error(404, "SKU不存在，无法更新", null);
            }
        } catch (Exception e) {
            return Result.error(500, "更新SKU时发生错误：" + e.getMessage(), null);
        }
    }

    @DeleteMapping("/{skuId}")
    public Result<Void> deleteMedicineSku(@PathVariable Integer skuId) {
        try {
            boolean success = medicineSkuService.deleteMedicineSku(skuId);
            if (success) {
                return Result.success("SKU删除成功");
            } else {
                return Result.error(404, "SKU不存在，无法删除");
            }
        } catch (Exception e) {
            return Result.error(500, "删除SKU时发生错误：" + e.getMessage());
        }
    }

    @GetMapping("/bySupplierId/{supplierId}")
    public Result<List<MedicineSku>> getMedicineSkusBySupplierId(@PathVariable Integer supplierId) {
        try {
            List<MedicineSku> skus = medicineSkuService.getMedicineSkusBySupplierId(supplierId);
            return Result.success("查询成功", skus);
        } catch (Exception e) {
            return Result.error(500, "查询失败：" + e.getMessage(), null);
        }
    }

}
