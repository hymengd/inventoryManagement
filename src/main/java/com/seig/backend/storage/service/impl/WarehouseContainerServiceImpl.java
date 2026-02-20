package com.seig.backend.storage.service.impl;

import com.seig.backend.storage.entity.WarehouseContainer;
import com.seig.backend.storage.mapper.WarehouseContainerMapper;
import com.seig.backend.storage.service.WarehouseContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class WarehouseContainerServiceImpl implements WarehouseContainerService {

    @Autowired
    private WarehouseContainerMapper warehouseContainerMapper;

    @Override
    public List<WarehouseContainer> findAll() {
        return warehouseContainerMapper.selectAll();
    }

    @Override
    public WarehouseContainer findById(Integer id) {
        return warehouseContainerMapper.selectById(id);
    }

    @Override
    public WarehouseContainer save(WarehouseContainer container) {
        container.setCreatedTime(LocalDateTime.now());
        container.setUpdatedTime(LocalDateTime.now());
        warehouseContainerMapper.insert(container);
        return container;
    }

    @Override
    public WarehouseContainer update(WarehouseContainer container) {
        container.setUpdatedTime(LocalDateTime.now());
        warehouseContainerMapper.update(container);
        return container;
    }

    @Override
    public void deleteById(Integer id) {
        warehouseContainerMapper.deleteById(id);
    }

    @Override
    public List<WarehouseContainer> getByZoneId(Integer zoneId) {
        return warehouseContainerMapper.selectByZoneId(zoneId);
    }

    @Override
    public List<Integer> selectByConditions(List<Integer> zoneIds, boolean isRefrigerated, boolean isNarcoticSafe) {
        return warehouseContainerMapper.selectByConditions(zoneIds, isRefrigerated, isNarcoticSafe);
    }
}
