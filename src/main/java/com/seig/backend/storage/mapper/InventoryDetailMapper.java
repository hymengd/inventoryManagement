package com.seig.backend.storage.mapper;

import com.seig.backend.storage.entity.InventoryDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InventoryDetailMapper {
    /**
     * 新增库存明细
     */
    int insert(InventoryDetail inventoryDetail);

    /**
     * 根据ID查询库存明细
     */
    InventoryDetail selectById(Integer detailId);

    /**
     * 根据批次ID查询明细
     */
    List<InventoryDetail> selectByBatchId(Integer batchId);

    /**
     * 根据库位ID查询明细
     */
    List<InventoryDetail> selectByLocationId(Integer locationId);

    /**
     * 查询所有库存明细
     */
    List<InventoryDetail> selectAll();

    /**
     * 更新库存明细
     */
    int update(InventoryDetail inventoryDetail);

    /**
     * 删除库存明细
     */
    int deleteById(Integer detailId);

    /**
     * 根据批次和库位查询明细
     */
    InventoryDetail selectByBatchAndLocation(Integer batchId, Integer locationId);
}
