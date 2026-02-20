package com.seig.backend.storage.mapper;

import com.seig.backend.storage.entity.QuarantineBatch;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuarantineBatchMapper {
    /**
     * 新增待验批次
     */
    int insert(QuarantineBatch quarantineBatch);

    /**
     * 根据ID查询待验批次
     */
    QuarantineBatch selectById(Integer quarantineId);

    /**
     * 根据采购订单ID查询待验批次列表
     */
    List<QuarantineBatch> selectByPurchaseOrderId(Integer purchaseOrderId);

    /**
     * 查询所有待验批次
     */
    List<QuarantineBatch> selectAll();

    /**
     * 更新待验批次
     */
    int update(QuarantineBatch quarantineBatch);

    /**
     * 删除待验批次
     */
    int deleteById(Integer quarantineId);
}
