package com.seig.backend.service.impl;

import com.seig.backend.entity.Categories;
import com.seig.backend.mapper.CategoriesMapper;
import com.seig.backend.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesServiceImpl implements CategoriesService {
    @Autowired
    private CategoriesMapper categoriesMapper;

    @Override
    public List<Categories> getAllCategories() {
        return categoriesMapper.getAllCategories();
    }

    @Override
    public List<Categories> getCategoriesVo() {
        return categoriesMapper.getCategoriesVo();
    }

    @Override
    public int updateCategories(Categories categories) {
        return categoriesMapper.updateCategories(categories);
    }

    @Override
    public int addCategories(Categories categories) {
        return categoriesMapper.insertCategories(categories);
    }

    @Override
    public int deleteCategories(Integer categoryId) {
        return categoriesMapper.deleteCategories(categoryId);
    }
}
