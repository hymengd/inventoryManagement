package com.seig.backend.storage.service.impl;

import com.seig.backend.storage.entity.WarehouseZone;
import com.seig.backend.storage.mapper.WarehouseZoneMapper;
import com.seig.backend.storage.service.WarehouseZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class WarehouseZoneServiceImpl implements WarehouseZoneService {

    @Autowired
    private WarehouseZoneMapper warehouseZoneMapper;

    @Override
    public List<WarehouseZone> findAll() {
        return warehouseZoneMapper.selectAll();
    }

    @Override
    public WarehouseZone findById(Integer id) {
        return warehouseZoneMapper.selectById(id);
    }

    @Override
    public WarehouseZone save(WarehouseZone zone) {
        System.out.println(zone.getWarehouseId());
        zone.setCreatedTime(LocalDateTime.now());
        zone.setUpdatedTime(LocalDateTime.now());
        warehouseZoneMapper.insert(zone);
        return zone;
    }

    @Override
    public WarehouseZone update(WarehouseZone zone) {
        zone.setUpdatedTime(LocalDateTime.now());
        warehouseZoneMapper.update(zone);
        return zone;
    }

    @Override
    public void deleteById(Integer id) {
        warehouseZoneMapper.deleteById(id);
    }

    @Override
    public List<WarehouseZone> getByWarehouseId(Integer warehouseId) {
        return warehouseZoneMapper.selectByWarehouseId(warehouseId);
    }
}
