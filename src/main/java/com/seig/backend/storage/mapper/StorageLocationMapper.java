package com.seig.backend.storage.mapper;

import com.seig.backend.storage.entity.StorageLocation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StorageLocationMapper {
    /**
     * 新增货位
     */
    int insert(StorageLocation storageLocation);

    /**
     * 根据ID查询货位
     */
    StorageLocation selectById(Integer locationId);

    /**
     * 根据货架/容器ID查询货位列表
     */
    List<StorageLocation> selectByContainerId(Integer containerId);

    /**
     * 查询所有货位
     */
    List<StorageLocation> selectAll();

    /**
     * 更新货位
     */
    int update(StorageLocation storageLocation);

    /**
     * 删除货位
     */
    int deleteById(Integer locationId);

//    已用
    List<Integer> selectEmptyLocations(@Param("containerIds") List<Integer> containerIds);


}
