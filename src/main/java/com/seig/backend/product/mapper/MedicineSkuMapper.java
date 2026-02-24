package com.seig.backend.product.mapper;

import com.seig.backend.product.entity.MedicineSku;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
     * 根据药品通用名称查询SKU
     */
    List<MedicineSku> selectByGenericName(@Param("genericName") String genericName);

    /**
     * 根据英文名称查询SKU
     */
    List<MedicineSku> selectByEnglishName(@Param("englishName") String englishName);

    /**
     * 根据化学名称查询SKU
     */
    List<MedicineSku> selectByChemicalName(@Param("chemicalName") String chemicalName);

    /**
     * 根据多个条件组合查询SKU
     */
    List<MedicineSku> selectByConditions(@Param("genericName") String genericName,
                                         @Param("englishName") String englishName,
                                         @Param("chemicalName") String chemicalName,
                                         @Param("brandName") String brandName);

    /**
     * 根据关键字统一搜索SKU（在generic_name、english_name、chemical_name、brand_name中搜索）
     */
    List<MedicineSku> searchByKeyword(@Param("keyword") String keyword);

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
