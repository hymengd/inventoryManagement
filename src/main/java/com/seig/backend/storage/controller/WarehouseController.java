package com.seig.backend.storage.controller;

import com.seig.backend.common.Result;
import com.seig.backend.storage.entity.Warehouse;
import com.seig.backend.storage.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/warehouses")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    // 查询所有仓库
    @GetMapping
    public Result<List<Warehouse>> getAllWarehouses() {
        List<Warehouse> warehouses = warehouseService.getAllWarehouses();
        return Result.success("查询成功", warehouses);
    }

    // 根据ID查询仓库
    @GetMapping("/{id}")
    public Result<Warehouse> getWarehouseById(@PathVariable Integer id) {
        Warehouse warehouse = warehouseService.getWarehouseById(id);
        return Result.success("查询成功", warehouse);
    }

    // 新增仓库
    @PostMapping
    public Result<Warehouse> addWarehouse(@RequestBody Warehouse warehouse) {
        Warehouse saved = warehouseService.createWarehouse(warehouse);
        return Result.success("新增成功", saved);
    }

    // 更新仓库
    @PutMapping("/{id}")
    public Result<Warehouse> updateWarehouse(@PathVariable Integer id, @RequestBody Warehouse warehouse) {
        warehouse.setWarehouseId(id);
        Warehouse updated = warehouseService.updateWarehouse(warehouse);
        return Result.success("更新成功", updated);
    }

    // 删除仓库
    @DeleteMapping("/{id}")
    public Result<Void> deleteWarehouse(@PathVariable Integer id) {
        warehouseService.deleteWarehouse(id);
        return Result.success("删除成功");
    }
}

