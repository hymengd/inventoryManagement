package com.seig.backend.storage.service;

import com.seig.backend.storage.entity.WarehouseZone;

import java.util.List;

public interface WarehouseZoneService {
    // WarehouseZone 相关操作
//    WarehouseZone createWarehouseZone(WarehouseZone warehouseZone);
//    WarehouseZone getWarehouseZoneById(Integer zoneId);
//    List<WarehouseZone> getAllWarehouseZones();
//    List<WarehouseZone> getWarehouseZonesByWarehouseId(Integer warehouseId);
//    WarehouseZone updateWarehouseZone(WarehouseZone warehouseZone);
//    boolean deleteWarehouseZone(Integer zoneId);
//
//    // 根据库区ID查询货架/容器
//    List<WarehouseContainer> getWarehouseContainersByZoneId(Integer zoneId);

    List<WarehouseZone> findAll();
    WarehouseZone findById(Integer id);
    WarehouseZone save(WarehouseZone zone);
    WarehouseZone update(WarehouseZone zone);
    void deleteById(Integer id);
    List<WarehouseZone> getByWarehouseId(Integer warehouseId);


}
