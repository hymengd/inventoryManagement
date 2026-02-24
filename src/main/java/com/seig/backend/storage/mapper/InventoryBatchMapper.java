package com.seig.backend.storage.mapper;

import com.seig.backend.storage.entity.InventoryBatch;
import com.seig.backend.storage.entity.InventoryDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//  库存批次
//  skus --> 库存(存的是这个规格、公司...的药物)批次 --> 库存(这个批次分别存在哪里)明细
@Mapper
public interface InventoryBatchMapper {
    /**
     * 新增库存批次
     */
    int insert(InventoryBatch inventoryBatch);

    /**
     * 根据ID查询库存批次
     */
    InventoryBatch selectById(Integer batchId);

    /**
     * 根据SKU ID查询批次
     */
    List<InventoryBatch> selectBySkuId(Integer skuId);

    /**
     * 查询所有库存批次
     */
    List<InventoryBatch> selectAll();

    /**
     * 更新库存批次
     */
    int update(InventoryBatch inventoryBatch);

    /**
     * 删除库存批次
     */
    int deleteById(Integer batchId);

    /**
     * 根据批次号查询
     */
    InventoryBatch selectByBatchNumber(String batchNumber);



}
