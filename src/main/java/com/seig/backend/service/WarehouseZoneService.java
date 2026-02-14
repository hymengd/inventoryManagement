package com.seig.backend.service;

import com.seig.backend.entity.storage.WarehouseZone;
import com.seig.backend.entity.storage.WarehouseContainer;
import java.util.List;

public interface WarehouseZoneService {
    // WarehouseZone 相关操作
    WarehouseZone createWarehouseZone(WarehouseZone warehouseZone);
    WarehouseZone getWarehouseZoneById(Integer zoneId);
    List<WarehouseZone> getAllWarehouseZones();
    List<WarehouseZone> getWarehouseZonesByWarehouseId(Integer warehouseId);
    WarehouseZone updateWarehouseZone(WarehouseZone warehouseZone);
    boolean deleteWarehouseZone(Integer zoneId);
    
    // 根据库区ID查询货架/容器
    List<WarehouseContainer> getWarehouseContainersByZoneId(Integer zoneId);
}
