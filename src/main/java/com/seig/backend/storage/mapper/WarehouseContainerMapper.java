package com.seig.backend.storage.mapper;

import com.seig.backend.storage.entity.WarehouseContainer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WarehouseContainerMapper {
    /**
     * 新增货架/容器
     */
    int insert(WarehouseContainer warehouseContainer);

    /**
     * 根据ID查询货架/容器
     */
    WarehouseContainer selectById(Integer containerId);

    /**
     * 根据库区ID查询货架/容器列表
     */
    List<WarehouseContainer> selectByZoneId(Integer zoneId);

    /**
     * 查询所有货架/容器
     */
    List<WarehouseContainer> selectAll();

    /**
     * 更新货架/容器
     */
    int update(WarehouseContainer warehouseContainer);

    /**
     * 删除货架/容器
     */
    int deleteById(Integer containerId);

    List<Integer> selectByConditions(@Param("zoneIds") List<Integer> zoneIds,
                                     @Param("isRefrigerated") boolean isRefrigerated,
                                     @Param("isNarcoticSafe") boolean isNarcoticSafe);



}
