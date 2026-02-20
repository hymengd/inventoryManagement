package com.seig.backend.storage.mapper;

import com.seig.backend.storage.entity.Warehouse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WarehouseMapper {
    /**
     * 新增仓库
     */
    int insert(Warehouse warehouse);

    /**
     * 根据ID查询仓库
     */
    Warehouse selectById(Integer warehouseId);

    /**
     * 查询所有仓库
     */
    List<Warehouse> selectAll();

    /**
     * 更新仓库
     */
    int update(Warehouse warehouse);

    /**
     * 删除仓库
     */
    int deleteById(Integer warehouseId);

//    List<Integer> selectZonesByTemperature(@Param("warehouseId") Integer warehouseId,
//                                           @Param("minTemperature") BigDecimal minTemperature,
//                                           @Param("maxTemperature") BigDecimal maxTemperature);



}
