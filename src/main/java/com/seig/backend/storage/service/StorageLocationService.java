package com.seig.backend.storage.service;

import com.seig.backend.storage.entity.StorageLocation;
import java.util.List;

public interface StorageLocationService {
    // StorageLocation 相关操作
//    StorageLocation createStorageLocation(StorageLocation storageLocation);
//    StorageLocation getStorageLocationById(Integer locationId);
//    List<StorageLocation> getAllStorageLocations();
//    List<StorageLocation> getStorageLocationsByContainerId(Integer containerId);
//    StorageLocation updateStorageLocation(StorageLocation storageLocation);
//    boolean deleteStorageLocation(Integer locationId);

    List<StorageLocation> findAll();
    StorageLocation findById(Integer id);
    StorageLocation save(StorageLocation location);
    StorageLocation update(StorageLocation location);
    void deleteById(Integer id);
    List<StorageLocation> getByContainerId(Integer containerId);

}
