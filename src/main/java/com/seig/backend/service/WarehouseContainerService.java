package com.seig.backend.service;

import com.seig.backend.entity.storage.WarehouseContainer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WarehouseContainerService {
    List<WarehouseContainer> findAll(); // 查询所有容器
    WarehouseContainer findById(Integer id); // 根据ID查询容器
    WarehouseContainer save(WarehouseContainer container); // 新增容器
    WarehouseContainer update(WarehouseContainer container); // 更新容器
    void deleteById(Integer id); // 删除容器
    List<WarehouseContainer> getByZoneId(Integer zoneId); // 根据库区ID查询容器列表
    List<Integer> selectByConditions(@Param("zoneIds") List<Integer> zoneIds,
                                     @Param("isRefrigerated") boolean isRefrigerated,
                                     @Param("isNarcoticSafe") boolean isNarcoticSafe);

}
