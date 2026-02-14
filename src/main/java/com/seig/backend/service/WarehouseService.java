package com.seig.backend.service;

import com.seig.backend.entity.storage.Warehouse;
import com.seig.backend.entity.storage.WarehouseZone;
import java.util.List;

public interface WarehouseService {
    // Warehouse 相关操作
    Warehouse createWarehouse(Warehouse warehouse);
    Warehouse getWarehouseById(Integer warehouseId);
    List<Warehouse> getAllWarehouses();
    Warehouse updateWarehouse(Warehouse warehouse);
    boolean deleteWarehouse(Integer warehouseId);
    
    // 根据仓库ID查询库区
    List<WarehouseZone> getWarehouseZonesByWarehouseId(Integer warehouseId);
}
