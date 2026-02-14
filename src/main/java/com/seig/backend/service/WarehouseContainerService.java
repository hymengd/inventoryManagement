package com.seig.backend.service;

import com.seig.backend.entity.storage.WarehouseContainer;
import com.seig.backend.entity.storage.StorageLocation;
import java.util.List;

public interface WarehouseContainerService {
    // WarehouseContainer 相关操作
    WarehouseContainer createWarehouseContainer(WarehouseContainer warehouseContainer);
    WarehouseContainer getWarehouseContainerById(Integer containerId);
    List<WarehouseContainer> getAllWarehouseContainers();
    List<WarehouseContainer> getWarehouseContainersByZoneId(Integer zoneId);
    WarehouseContainer updateWarehouseContainer(WarehouseContainer warehouseContainer);
    boolean deleteWarehouseContainer(Integer containerId);
    
    // 根据货架/容器ID查询货位
    List<StorageLocation> getStorageLocationsByContainerId(Integer containerId);
}
