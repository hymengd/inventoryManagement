package com.seig.backend.controller;

import com.seig.backend.common.Result;
import com.seig.backend.entity.storage.WarehouseZone;
import com.seig.backend.service.WarehouseZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zones")
public class WarehouseZoneController {

    @Autowired
    private WarehouseZoneService warehouseZoneService;

    // 查询所有库区
    @GetMapping
    public Result<List<WarehouseZone>> getAllZones() {
        List<WarehouseZone> zones = warehouseZoneService.findAll();
        return Result.success("查询成功", zones);
    }

    // 根据ID查询库区
    @GetMapping("/{id}")
    public Result<WarehouseZone> getZoneById(@PathVariable Integer id) {
        WarehouseZone zone = warehouseZoneService.findById(id);
        return Result.success("查询成功", zone);
    }

    // 新增库区
    @PostMapping
    public Result<WarehouseZone> addZone(@RequestBody WarehouseZone zone) {
        WarehouseZone saved = warehouseZoneService.save(zone);
        return Result.success("新增成功", saved);
    }

    // 更新库区
    @PutMapping("/{id}")
    public Result<WarehouseZone> updateZone(@PathVariable Integer id, @RequestBody WarehouseZone zone) {
        zone.setZoneId(id);
        WarehouseZone updated = warehouseZoneService.update(zone);
        return Result.success("更新成功", updated);
    }

    // 删除库区
    @DeleteMapping("/{id}")
    public Result<Void> deleteZone(@PathVariable Integer id) {
        warehouseZoneService.deleteById(id);
        return Result.success("删除成功");
    }

    // 根据仓库ID查询库区列表
    @GetMapping("/warehouse/{warehouseId}")
    public Result<List<WarehouseZone>> getZonesByWarehouseId(@PathVariable Integer warehouseId) {
        List<WarehouseZone> zones = warehouseZoneService.getByWarehouseId(warehouseId);
        return Result.success("查询成功", zones);
    }
}
