package com.seig.backend.utils;

import com.seig.backend.product.entity.Categories;

/**
 * 分类更新工具类 - 支持非空字段更新 ----- 现在在sql语句判断空了
 */
public class CategoriesUpdateUtil {
    
    /**
     * 更新目标对象中非空字段
     * @param target 目标对象
     * @param source 源对象
     * @return 更新后的目标对象
     */
    public static Categories updateNonNullFields(Categories target, Categories source) {
        if (source.getCategoryCode() != null && !source.getCategoryCode().isEmpty()) {
            target.setCategoryCode(source.getCategoryCode());
        }
        if (source.getCategoryName() != null && !source.getCategoryName().isEmpty()) {
            target.setCategoryName(source.getCategoryName());
        }
        if (source.getParentId() != null) {
            target.setParentId(source.getParentId());
        }
        if (source.getLevel() != null) {
            target.setLevel(source.getLevel());
        }
        if (source.getFullPath() != null && !source.getFullPath().isEmpty()) {
            target.setFullPath(source.getFullPath());
        }
        if (source.getDescription() != null) {
            target.setDescription(source.getDescription());
        }
        if (source.getSortOrder() != null) {
            target.setSortOrder(source.getSortOrder());
        }
        if (source.getStatus() != null) {
            target.setStatus(source.getStatus());
        }
        target.setUpdatedAt(java.time.LocalDateTime.now());
        
        return target;
    }
}
