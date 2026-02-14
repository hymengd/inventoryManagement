package com.seig.backend.controller;

import com.seig.backend.common.Result;
import com.seig.backend.entity.Supplier;
import com.seig.backend.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/getAllSuppliers")
    public Result<List<Supplier>> getAllSuppliers() {
        try {
            List<Supplier> suppliers = supplierService.getAllSuppliers();
            return Result.success("获取供应商列表成功", suppliers);
        } catch (Exception e) {
            return Result.error(500, "获取供应商列表失败：" + e.getMessage());
        }
    }
    /**
     * 添加供应商
     */
    @PostMapping("/addSupplier")
    public Result<Integer> addSupplier(@RequestBody Supplier supplier) {
        try {
            Integer supplierId = supplierService.addSupplier(supplier);
            if (supplierId != null && supplierId > 0) {
                return Result.success("添加成功", supplierId);
            } else {
                return Result.error(500, "添加失败", null);
            }
        } catch (Exception e) {
            return Result.error(500, "添加供应商失败：" + e.getMessage(), null);
        }
    }


    /**
     * 根据supplierId修改供应商所有信息（ID除外）
     */
    @PutMapping("/{supplierId}")
    public Result<Void> updateSupplier(
            @PathVariable Integer supplierId,
            @RequestBody Supplier supplier) {
        try {
            supplier.setSupplierId(supplierId);
            boolean success = supplierService.updateSupplierById(supplier);
            if (success) {
                return Result.success("供应商信息更新成功");
            } else {
                return Result.error("供应商不存在，无法更新");
            }
        } catch (Exception e) {
            return Result.error("供应商信息更新失败: " + e.getMessage());
        }
    }
    @DeleteMapping("/{supplierId}")
    public Result<Void> deleteSupplierById(@PathVariable Integer supplierId) {
        try {
            boolean success = supplierService.deleteSupplierById(supplierId);
            if (success) {
                return Result.success("供应商删除成功");
            } else {
                return Result.error("供应商不存在，无法删除");
            }
        } catch (Exception e) {
            return Result.error("供应商删除失败：" + e.getMessage());
        }
    }
    /**
     * 根据供应商ID获取供应商信息
     */
    @GetMapping("/{supplierId}")
    public Result<Supplier> getSupplierById(@PathVariable Integer supplierId) {
        try {
            Supplier supplier = supplierService.getSupplierById(supplierId);
            if (supplier != null) {
                return Result.success("获取供应商信息成功", supplier);
            } else {
                return Result.error(404, "供应商不存在", null);
            }
        } catch (Exception e) {
            return Result.error(500, "获取供应商信息失败：" + e.getMessage(), null);
        }
    }
    /**
     * 根据供应商ID获取供应商名称
     */
    @GetMapping("/{supplierId}/name")
    public Result<String> getSupplierNameById(@PathVariable Integer supplierId) {
        System.out.println(supplierId);
        try {
            Supplier supplier = supplierService.getSupplierById(supplierId);
            if (supplier != null) {
                return Result.success("获取供应商名称成功", supplier.getSupplierName());
            } else {
                return Result.error(404, "供应商不存在", null);
            }
        } catch (Exception e) {
            return Result.error(500, "获取供应商名称失败：" + e.getMessage(), null);
        }
    }


}
