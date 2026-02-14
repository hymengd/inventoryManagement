package com.seig.backend.controller;

import com.seig.backend.common.Result;
import com.seig.backend.entity.storage.StorageLocation;
import com.seig.backend.service.StorageLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class StorageLocationController {

    @Autowired
    private StorageLocationService storageLocationService;

    // 查询所有货位
    @GetMapping
    public Result<List<StorageLocation>> getAllLocations() {
        List<StorageLocation> locations = storageLocationService.findAll();
        return Result.success("查询成功", locations);
    }

    // 根据ID查询货位
    @GetMapping("/{id}")
    public Result<StorageLocation> getLocationById(@PathVariable Integer id) {
        StorageLocation location = storageLocationService.findById(id);
        return Result.success("查询成功", location);
    }

    // 新增货位
    @PostMapping
    public Result<StorageLocation> addLocation(@RequestBody StorageLocation location) {
        StorageLocation saved = storageLocationService.save(location);
        return Result.success("新增成功", saved);
    }

    // 更新货位
    @PutMapping("/{id}")
    public Result<StorageLocation> updateLocation(@PathVariable Integer id, @RequestBody StorageLocation location) {
        location.setLocationId(id);
        StorageLocation updated = storageLocationService.update(location);
        return Result.success("更新成功", updated);
    }

    // 删除货位
    @DeleteMapping("/{id}")
    public Result<Void> deleteLocation(@PathVariable Integer id) {
        storageLocationService.deleteById(id);
        return Result.success("删除成功");
    }

    // 根据容器ID查询货位列表
    @GetMapping("/container/{containerId}")
    public Result<List<StorageLocation>> getLocationsByContainerId(@PathVariable Integer containerId) {
        List<StorageLocation> locations = storageLocationService.getByContainerId(containerId);
        return Result.success("查询成功", locations);
    }
}
