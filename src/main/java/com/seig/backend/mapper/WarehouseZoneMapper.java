package com.seig.backend.mapper;

import com.seig.backend.entity.storage.WarehouseZone;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface WarehouseZoneMapper {
    /**
     * 新增库区
     */
    int insert(WarehouseZone warehouseZone);

    /**
     * 根据ID查询库区
     */
    WarehouseZone selectById(Integer zoneId);

    /**
     * 根据仓库ID查询库区列表
     */
    List<WarehouseZone> selectByWarehouseId(Integer warehouseId);

    /**
     * 查询所有库区
     */
    List<WarehouseZone> selectAll();

    /**
     * 更新库区
     */
    int update(WarehouseZone warehouseZone);

    /**
     * 删除库区
     */
    int deleteById(Integer zoneId);

    List<Integer> selectByTemperatureRange(@Param("warehouseId") Integer warehouseId,
                                           @Param("minTemperature") BigDecimal minTemperature,
                                           @Param("maxTemperature") BigDecimal maxTemperature);

    List<Integer> selectZonesByTemperature(@Param("warehouseId") Integer warehouseId,
                                           @Param("minTemperature") BigDecimal minTemperature,
                                           @Param("maxTemperature") BigDecimal maxTemperature);


}
