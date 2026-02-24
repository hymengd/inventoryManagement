package com.seig.backend.storage.service;

import com.seig.backend.pojo.dto.SkuInventoryRequestDto;
import com.seig.backend.pojo.vo.InventoryLocationVo;
import com.seig.backend.storage.entity.InventoryBatch;
import com.seig.backend.storage.entity.InventoryDetail;
import com.seig.backend.storage.entity.InventoryDetailWithLocation;

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

    // 根据SKU和数量需求获取最优货位信息
    List<InventoryLocationVo> getOptimalLocationsForSkus(List<SkuInventoryRequestDto> requestList);

    // 解锁库存
    boolean unlockInventoryLocations(List<InventoryLocationVo> lockedLocations); // 验证库存是否足够
    // 验证库存是否足够
    boolean validateInventoryAvailability(List<SkuInventoryRequestDto> requestList);

    List<InventoryLocationVo> lockOptimalLocationsForSkus(List<SkuInventoryRequestDto> requestList);
}
