package com.seig.backend.storage.service.impl;

import com.seig.backend.storage.entity.Warehouse;
import com.seig.backend.storage.entity.WarehouseZone;
import com.seig.backend.storage.mapper.WarehouseMapper;
import com.seig.backend.storage.mapper.WarehouseZoneMapper;
import com.seig.backend.storage.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseMapper warehouseMapper;
    
    @Autowired
    private WarehouseZoneMapper warehouseZoneMapper;

    @Override
    public Warehouse createWarehouse(Warehouse warehouse) {
        int result = warehouseMapper.insert(warehouse);
        if (result > 0) {
            return warehouseMapper.selectById(warehouse.getWarehouseId());
        }
        return null;
    }

    @Override
    public Warehouse getWarehouseById(Integer warehouseId) {
        return warehouseMapper.selectById(warehouseId);
    }

    @Override
    public List<Warehouse> getAllWarehouses() {
        return warehouseMapper.selectAll();
    }

    @Override
    public Warehouse updateWarehouse(Warehouse warehouse) {
        int result = warehouseMapper.update(warehouse);
        if (result > 0) {
            return warehouseMapper.selectById(warehouse.getWarehouseId());
        }
        return null;
    }

    @Override
    public boolean deleteWarehouse(Integer warehouseId) {
        return warehouseMapper.deleteById(warehouseId) > 0;
    }

    @Override
    public List<WarehouseZone> getWarehouseZonesByWarehouseId(Integer warehouseId) {
        return warehouseZoneMapper.selectByWarehouseId(warehouseId);
    }



}
