package com.seig.backend.product.entity;
import java.time.LocalDateTime;

/**
 * 药品分类实体类
 * medicine_categories 名字太长所以缩减类名了
 */
public class Categories {
    /**
     * 分类ID，id确定完整分类路径了应该
     */
    private Integer categoryId;

    /**
     * 分类编码（数字字母下划线）
     */
    private String categoryCode;

    /**
     * 分类名称（不带父/祖）
     */
    private String categoryName;

    /**
     * 父分类ID
     */
    private Integer parentId;

    /**
     * 分类层级，第几级，0顶级1次级这样
     */
    private Byte level;

    /**
     * 完整路径（如：西药-抗微生物药物-第一代头孢菌素-头孢唑林钠）
     */
    private String fullPath;

    /**
     * 分类描述
     */
    private String description;

    /**
     * 排序号，这一级下的顺序
     */
    private Integer sortOrder;

    /**
     * 状态：0-停用，1-启用
     */
    private Byte status;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;

    public Categories() {
    }

    // getter 和 setter 方法
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public String getFullPath() {
        return fullPath;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
