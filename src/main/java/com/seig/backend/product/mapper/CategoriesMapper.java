package com.seig.backend.product.mapper;

import com.seig.backend.product.entity.Categories;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoriesMapper {
    List<Categories> getAllCategories();
    List<Categories> getCategoriesVo();
    int updateCategories(Categories categories);
    int insertCategories(Categories categories);
    int deleteCategories(Integer categoryId);

}
