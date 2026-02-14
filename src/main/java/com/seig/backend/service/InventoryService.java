package com.seig.backend.service;

import com.seig.backend.entity.storage.InventoryBatch;
import com.seig.backend.entity.storage.InventoryDetail;

import java.util.List;

public interface InventoryService {
    // InventoryBatch 相关操作
    InventoryBatch createInventoryBatch(InventoryBatch inventoryBatch);
    InventoryBatch getInventoryBatchById(Integer batchId);
    List<InventoryBatch> getAllInventoryBatches();
    List<InventoryBatch> getInventoryBatchesBySkuId(Integer skuId);
    InventoryBatch updateInventoryBatch(InventoryBatch inventoryBatch);
    boolean deleteInventoryBatch(Integer batchId);

    // InventoryDetail 相关操作
    InventoryDetail createInventoryDetail(InventoryDetail inventoryDetail);
    InventoryDetail getInventoryDetailById(Integer detailId);
    List<InventoryDetail> getAllInventoryDetails();
    List<InventoryDetail> getInventoryDetailsByBatchId(Integer batchId);
    List<InventoryDetail> getInventoryDetailsByLocationId(Integer locationId);
    InventoryDetail updateInventoryDetail(InventoryDetail inventoryDetail);
    boolean deleteInventoryDetail(Integer detailId);
}
