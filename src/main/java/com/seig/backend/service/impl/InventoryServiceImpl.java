package com.seig.backend.service.impl;

import com.seig.backend.entity.storage.InventoryBatch;
import com.seig.backend.entity.storage.InventoryDetail;
import com.seig.backend.mapper.InventoryBatchMapper;
import com.seig.backend.mapper.InventoryDetailMapper;
import com.seig.backend.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryBatchMapper inventoryBatchMapper;

    @Autowired
    private InventoryDetailMapper inventoryDetailMapper;

    // InventoryBatch 相关操作
    @Override
    public InventoryBatch createInventoryBatch(InventoryBatch inventoryBatch) {
        int result = inventoryBatchMapper.insert(inventoryBatch);
        if (result > 0) {
            return inventoryBatch;
        }
        return null;
    }

    @Override
    public InventoryBatch getInventoryBatchById(Integer batchId) {
        return inventoryBatchMapper.selectById(batchId);
    }

    @Override
    public List<InventoryBatch> getAllInventoryBatches() {
        return inventoryBatchMapper.selectAll();
    }

    @Override
    public List<InventoryBatch> getInventoryBatchesBySkuId(Integer skuId) {
        return inventoryBatchMapper.selectBySkuId(skuId);
    }

    @Override
    public InventoryBatch updateInventoryBatch(InventoryBatch inventoryBatch) {
        int result = inventoryBatchMapper.update(inventoryBatch);
        if (result > 0) {
            return inventoryBatch;
        }
        return null;
    }

    @Override
    public boolean deleteInventoryBatch(Integer batchId) {
        int result = inventoryBatchMapper.deleteById(batchId);
        return result > 0;
    }

    // InventoryDetail 相关操作
    @Override
    public InventoryDetail createInventoryDetail(InventoryDetail inventoryDetail) {
        int result = inventoryDetailMapper.insert(inventoryDetail);
        if (result > 0) {
            return inventoryDetail;
        }
        return null;
    }

    @Override
    public InventoryDetail getInventoryDetailById(Integer detailId) {
        return inventoryDetailMapper.selectById(detailId);
    }

    @Override
    public List<InventoryDetail> getAllInventoryDetails() {
        return inventoryDetailMapper.selectAll();
    }

    @Override
    public List<InventoryDetail> getInventoryDetailsByBatchId(Integer batchId) {
        return inventoryDetailMapper.selectByBatchId(batchId);
    }

    @Override
    public List<InventoryDetail> getInventoryDetailsByLocationId(Integer locationId) {
        return inventoryDetailMapper.selectByLocationId(locationId);
    }

    @Override
    public InventoryDetail updateInventoryDetail(InventoryDetail inventoryDetail) {
        int result = inventoryDetailMapper.update(inventoryDetail);
        if (result > 0) {
            return inventoryDetail;
        }
        return null;
    }

    @Override
    public boolean deleteInventoryDetail(Integer detailId) {
        int result = inventoryDetailMapper.deleteById(detailId);
        return result > 0;
    }
}
