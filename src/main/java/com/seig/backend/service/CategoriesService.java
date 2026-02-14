package com.seig.backend.service;

import com.seig.backend.entity.Categories;

import java.util.List;

public interface CategoriesService {
    List<Categories> getAllCategories();

    List<Categories> getCategoriesVo();
    int updateCategories(Categories categories);
    int addCategories(Categories categories);
    int deleteCategories(Integer categoryId);

}
