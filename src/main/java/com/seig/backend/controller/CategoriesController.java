package com.seig.backend.controller;

import com.seig.backend.common.Result;
import com.seig.backend.entity.Categories;
import com.seig.backend.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicineCategory")
public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService ;

    @GetMapping("/getAllCategories")
    public Result<List<Categories>> getAllCategories() {
        System.out.println("getAllCategories() called");
        try {
            List<Categories> categories = categoriesService.getAllCategories();
            // 使用带数据的成功返回
            return Result.success("操作成功", categories);  // 返回 Result<List<Categories>>
        } catch (Exception e) {
            System.out.println("Error in getAllCategories(): " + e.getMessage());
            // 使用带数据的错误返回，保持泛型类型一致
            return Result.error(500, "获取分类列表失败", (List<Categories>) null);  // 返回 Result<List<Categories>>
        }
    }
//    @GetMapping("/getCategoriesVo")
//    public List<Categories> getCategoriesVo() {
//        System.out.println("getCategoriesVo() called");
//        return categoriesService.getCategoriesVo();
//    }
@PutMapping("/updateCategories")
public Result<Void> updateCategories(@RequestBody Categories categories) {
    try {
        int rows = categoriesService.updateCategories(categories);
        if (rows > 0) {
            return Result.success("更新成功");
        } else {
            return Result.error("更新失败，分类不存在或无变化");
        }
    } catch (Exception e) {
        System.out.println("Error in updateCategories(): " + e.getMessage());
        return Result.error("更新分类失败：" + e.getMessage());
    }
}

    @PostMapping("/addCategories")
    public Result<Void> addCategories(@RequestBody Categories categories) {
        try {
            int rows = categoriesService.addCategories(categories);
            if (rows > 0) {
                return Result.success("添加成功");
            } else {
                return Result.error("添加失败");
            }
        } catch (Exception e) {
            System.out.println("Error in addCategories(): " + e.getMessage());
            return Result.error("添加分类失败：" + e.getMessage());
        }
    }

    @DeleteMapping("/deleteCategories/{categoryId}")
    public Result<Void> deleteCategories(@PathVariable Integer categoryId) {
        try {
            int rows = categoriesService.deleteCategories(categoryId);
            if (rows > 0) {
                return Result.success("删除成功");
            } else {
                return Result.error("删除失败，分类不存在");
            }
        } catch (Exception e) {
            System.out.println("Error in deleteCategories(): " + e.getMessage());
            return Result.error("删除分类失败：" + e.getMessage());
        }
    }
}