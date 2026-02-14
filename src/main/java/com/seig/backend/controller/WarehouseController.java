package com.seig.backend.controller;

import com.seig.backend.common.Result;
import com.seig.backend.entity.storage.Warehouse;
import com.seig.backend.entity.storage.WarehouseZone;
import com.seig.backend.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @PostMapping
    public Result<Warehouse> createWarehouse(@RequestBody Warehouse warehouse) {
        try {
            Warehouse createdWarehouse = warehouseService.createWarehouse(warehouse);
            if (createdWarehouse != null) {
                return Result.success("仓库创建成功", createdWarehouse);
            } else {
                return Result.error(500, "仓库创建失败", null);
            }
        } catch (Exception e) {
            return Result.error(500, "创建仓库时发生错误：" + e.getMessage(), null);
        }
    }

    @GetMapping("/{warehouseId}")
    public Result<Warehouse> getWarehouseById(@PathVariable Integer warehouseId) {
        try {
            Warehouse warehouse = warehouseService.getWarehouseById(warehouseId);
            if (warehouse != null) {
                return Result.success("查询成功", warehouse);
            } else {
                return Result.error(404, "仓库不存在", null);
            }
        } catch (Exception e) {
            return Result.error(500, "查询仓库时发生错误：" + e.getMessage(), null);
        }
    }

    @GetMapping
    public Result<List<Warehouse>> getAllWarehouses() {
        try {
            List<Warehouse> warehouses = warehouseService.getAllWarehouses();
            return Result.success("查询成功", warehouses);
        } catch (Exception e) {
            return Result.error(500, "查询仓库列表时发生错误：" + e.getMessage(), null);
        }
    }

    @PutMapping("/{warehouseId}")
    public Result<Warehouse> updateWarehouse(@PathVariable Integer warehouseId, @RequestBody Warehouse warehouse) {
        try {
            warehouse.setWarehouseId(warehouseId);
            Warehouse updatedWarehouse = warehouseService.updateWarehouse(warehouse);
            if (updatedWarehouse != null) {
                return Result.success("仓库更新成功", updatedWarehouse);
            } else {
                return Result.error(404, "仓库不存在，无法更新", null);
            }
        } catch (Exception e) {
            return Result.error(500, "更新仓库时发生错误：" + e.getMessage(), null);
        }
    }

    @DeleteMapping("/{warehouseId}")
    public Result<Void> deleteWarehouse(@PathVariable Integer warehouseId) {
        try {
            boolean success = warehouseService.deleteWarehouse(warehouseId);
            if (success) {
                return Result.success("仓库删除成功");
            } else {
                return Result.error(404, "仓库不存在，无法删除");
            }
        } catch (Exception e) {
            return Result.error(500, "删除仓库时发生错误：" + e.getMessage());
        }
    }

    @GetMapping("/{warehouseId}/zones")
    public Result<List<WarehouseZone>> getWarehouseZonesByWarehouseId(@PathVariable Integer warehouseId) {
        try {
            List<WarehouseZone> zones = warehouseService.getWarehouseZonesByWarehouseId(warehouseId);
            return Result.success("查询成功", zones);
        } catch (Exception e) {
            return Result.error(500, "查询库区列表时发生错误：" + e.getMessage(), null);
        }
    }
}
