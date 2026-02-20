package com.seig.backend.storage.controller;

import com.seig.backend.common.Result;
import com.seig.backend.storage.entity.WarehouseContainer;
import com.seig.backend.storage.service.WarehouseContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/containers")
public class WarehouseContainerController {

    @Autowired
    private WarehouseContainerService warehouseContainerService;

    // 查询所有容器
    @GetMapping
    public Result<List<WarehouseContainer>> getAllContainers() {
        List<WarehouseContainer> containers = warehouseContainerService.findAll();
        return Result.success("查询成功", containers);
    }

    // 根据ID查询容器
    @GetMapping("/{id}")
    public Result<WarehouseContainer> getContainerById(@PathVariable Integer id) {
        WarehouseContainer container = warehouseContainerService.findById(id);
        return Result.success("查询成功", container);
    }

    // 新增容器
    @PostMapping
    public Result<WarehouseContainer> addContainer(@RequestBody WarehouseContainer container) {
        WarehouseContainer saved = warehouseContainerService.save(container);
        return Result.success("新增成功", saved);
    }

    // 更新容器
    @PutMapping("/{id}")
    public Result<WarehouseContainer> updateContainer(@PathVariable Integer id, @RequestBody WarehouseContainer container) {
        container.setContainerId(id);
        WarehouseContainer updated = warehouseContainerService.update(container);
        return Result.success("更新成功", updated);
    }

    // 删除容器
    @DeleteMapping("/{id}")
    public Result<Void> deleteContainer(@PathVariable Integer id) {
        warehouseContainerService.deleteById(id);
        return Result.success("删除成功");
    }

    // 根据库区ID查询容器列表
    @GetMapping("/zone/{zoneId}")
    public Result<List<WarehouseContainer>> getContainersByZoneId(@PathVariable Integer zoneId) {
        List<WarehouseContainer> containers = warehouseContainerService.getByZoneId(zoneId);
        return Result.success("查询成功", containers);
    }
}
