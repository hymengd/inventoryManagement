package com.seig.backend.service;

import com.seig.backend.entity.storage.StorageLocation;
import java.util.List;

public interface StorageLocationService {
    // StorageLocation 相关操作
    StorageLocation createStorageLocation(StorageLocation storageLocation);
    StorageLocation getStorageLocationById(Integer locationId);
    List<StorageLocation> getAllStorageLocations();
    List<StorageLocation> getStorageLocationsByContainerId(Integer containerId);
    StorageLocation updateStorageLocation(StorageLocation storageLocation);
    boolean deleteStorageLocation(Integer locationId);
}
