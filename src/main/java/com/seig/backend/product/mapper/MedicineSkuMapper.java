package com.seig.backend.product.mapper;

import com.seig.backend.product.entity.MedicineSku;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MedicineSkuMapper {
    /**
     * 新增SKU
     */
    int insert(MedicineSku medicineSku);

    /**
     * 根据ID查询SKU
     */
    MedicineSku selectById(Integer skuId);

    /**
     * 查询所有SKU
     */
    List<MedicineSku> selectAll();

    /**
     * 根据药品ID查询SKU
     */
    List<MedicineSku> selectByMedicineId(Integer medicineId);

    /**
     * 更新SKU
     */
    int update(MedicineSku medicineSku);

    /**
     * 删除SKU
     */
    int deleteById(Integer skuId);

    List<MedicineSku> selectBySupplierId(Integer supplierId);

}
