package com.seig.backend.mapper;

import com.seig.backend.entity.storage.QuarantineInventory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QuarantineInventoryMapper {
    /**
     * 新增待验库存明细
     */
    int insert(QuarantineInventory quarantineInventory);

    /**
     * 根据ID查询待验库存明细
     */
    QuarantineInventory selectById(Integer detailId);

    /**
     * 根据待验批次ID查询明细列表
     */
    List<QuarantineInventory> selectByQuarantineId(Integer quarantineId);

    /**
     * 查询所有待验库存明细
     */
    List<QuarantineInventory> selectAll();

    /**
     * 更新待验库存明细
     */
    int update(QuarantineInventory quarantineInventory);

    /**
     * 删除待验库存明细
     */
    int deleteById(Integer detailId);

    // 根据 batchId 查询
    List<QuarantineInventory> selectByBatchId(Integer batchId);

    /**
     * 批量插入待验库存明细
     */
    int batchInsert(@Param("list") List<QuarantineInventory> list);




}
