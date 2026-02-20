package com.seig.backend.storage.service.impl;

import com.seig.backend.storage.entity.StorageLocation;
import com.seig.backend.storage.mapper.StorageLocationMapper;
import com.seig.backend.storage.service.StorageLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class StorageLocationServiceImpl implements StorageLocationService {

    @Autowired
    private StorageLocationMapper storageLocationMapper;

    @Override
    public List<StorageLocation> findAll() {
        return storageLocationMapper.selectAll();
    }

    @Override
    public StorageLocation findById(Integer id) {
        return storageLocationMapper.selectById(id);
    }

    @Override
    public StorageLocation save(StorageLocation location) {
        location.setCreatedTime(LocalDateTime.now());
        location.setUpdatedTime(LocalDateTime.now());
        storageLocationMapper.insert(location);
        return location;
    }

    @Override
    public StorageLocation update(StorageLocation location) {
        System.out.println(location);
        location.setUpdatedTime(LocalDateTime.now());
        storageLocationMapper.update(location);
        return location;
    }

    @Override
    public void deleteById(Integer id) {
        storageLocationMapper.deleteById(id);
    }

    @Override
    public List<StorageLocation> getByContainerId(Integer containerId) {
        return storageLocationMapper.selectByContainerId(containerId);
    }
}
