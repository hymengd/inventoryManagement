package com.seig.backend.storage.mapper;

import com.seig.backend.storage.entity.InventoryDetail;
import com.seig.backend.storage.entity.InventoryDetailWithLocation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
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


    /**
     * 根据多个skuId连表查询库存明细
     */
    List<InventoryDetailWithLocation> selectByMultipleSkuIdsWithJoin(@Param("skuIds") List<Integer> skuIds);


    /**
     * 锁定库存数量（原子操作）
     *
     * @param detailId     明细ID
     * @param lockQuantity 要锁定的数量
     * @return 更新的记录数
     */
    int lockInventoryQuantity(@Param("detailId") Integer detailId,
                              @Param("lockQuantity") BigDecimal lockQuantity);

    /**
     * 解锁库存数量
     *
     * @param detailId       明细ID
     * @param unlockQuantity 要解锁的数量
     * @return 更新的记录数
     */
    int unlockInventoryQuantity(@Param("detailId") Integer detailId,
                                @Param("unlockQuantity") BigDecimal unlockQuantity);

    /**
     * 查询可用库存（排除已锁定的）
     *
     * @param skuIds SKU ID列表
     * @return 可用库存明细列表
     */
    List<InventoryDetailWithLocation> selectAvailableInventoryBySkuIds(@Param("skuIds") List<Integer> skuIds);

}
