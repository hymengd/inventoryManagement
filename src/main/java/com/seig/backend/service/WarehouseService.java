package com.seig.backend.service;

import com.seig.backend.entity.storage.Warehouse;
import com.seig.backend.entity.storage.WarehouseZone;
import java.util.List;

public interface WarehouseService {
    /**
     * 创建仓库
     */
    Warehouse createWarehouse(Warehouse warehouse);

    /**
     * 根据ID查询仓库
     */
    Warehouse getWarehouseById(Integer warehouseId);

    /**
     * 查询所有仓库
     */
    List<Warehouse> getAllWarehouses();

    /**
     * 更新仓库信息
     */
    Warehouse updateWarehouse(Warehouse warehouse);

    /**
     * 删除仓库
     */
    boolean deleteWarehouse(Integer warehouseId);

    /**
     * 根据仓库ID查询关联的库区列表
     */
    List<WarehouseZone> getWarehouseZonesByWarehouseId(Integer warehouseId);
}

