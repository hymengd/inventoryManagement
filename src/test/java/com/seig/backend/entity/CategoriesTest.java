package com.seig.backend.entity;

import com.seig.backend.product.entity.Categories;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

class CategoriesTest {

    @Test
    void testGettersAndSetters() {
        Categories category = new Categories();
        category.setCategoryId(1);
        category.setCategoryCode("CAT001");
        category.setCategoryName("Test Category");
        category.setParentId(0);
        category.setLevel((byte) 1);
        category.setFullPath("Root/Test Category");
        category.setDescription("This is a test category");
        category.setSortOrder(1);
        category.setStatus((byte) 1);
        category.setCreatedAt(LocalDateTime.now());
        category.setUpdatedAt(LocalDateTime.now());

        assertEquals(1, category.getCategoryId());
        assertEquals("CAT001", category.getCategoryCode());
        assertEquals("Test Category", category.getCategoryName());
        assertEquals(0, category.getParentId());
        assertEquals((byte) 1, category.getLevel());
        assertEquals("Root/Test Category", category.getFullPath());
        assertEquals("This is a test category", category.getDescription());
        assertEquals(1, category.getSortOrder());
        assertEquals((byte) 1, category.getStatus());
        assertNotNull(category.getCreatedAt());
        assertNotNull(category.getUpdatedAt());
    }
}
