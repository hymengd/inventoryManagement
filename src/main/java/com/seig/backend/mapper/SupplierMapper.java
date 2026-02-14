package com.seig.backend.mapper;

import com.seig.backend.entity.Supplier;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SupplierMapper {
    List<Supplier> selectAllSuppliers();


    /**
     * 插入新供应商
     */
    int insert(Supplier supplier);
    
    /**
     * 根据主键更新供应商信息
     */
    int updateByPrimaryKey(Supplier supplier);
    
    /**
     * 根据ID查询供应商
     */
    Supplier selectByPrimaryKey(Integer supplierId);

    int deleteByPrimaryKey(Integer supplierId);

}
