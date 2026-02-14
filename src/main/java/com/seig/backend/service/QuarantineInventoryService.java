package com.seig.backend.service;

import com.seig.backend.entity.storage.QuarantineInventory;

import java.util.List;

public interface QuarantineInventoryService {

    /**
     * 创建待验库存明细
     */
    QuarantineInventory createQuarantineInventory(QuarantineInventory quarantineInventory);

    /**
     * 根据待验批次ID查询明细列表
     */
    List<QuarantineInventory> getQuarantineInventoryByQuarantineId(Integer quarantineId);

    /**
     * 更新待验库存明细
     */
    QuarantineInventory updateQuarantineInventory(QuarantineInventory quarantineInventory);

    /**
     * 删除待验库存明细
     */
    boolean deleteQuarantineInventory(Integer detailId);

    /**
     * 批量生成待验库存明细并分配到合适的货位
     */
    List<QuarantineInventory> generateAndAssignQuarantineInventory(
            Integer warehouseId, Integer skuId, Integer quantity);


}
