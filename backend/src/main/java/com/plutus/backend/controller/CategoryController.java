package com.plutus.backend.controller;

import com.plutus.backend.entity.Category;
import com.plutus.backend.entity.Response;
import com.plutus.backend.service.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Resource
    CategoryService categoryService;

    @PostMapping("/add")
    public Response<Object> add(@RequestBody Category category) {
        Category c = categoryService.findByCategoryName(category.getCategoryName());
        if (c != null) {
            return Response.error("该类别已存在");
        }
        categoryService.add(category);
        return Response.success();
    }

    @GetMapping("/search")
    public Response<Object> search(@RequestParam Integer id) {
        Category category = categoryService.findById(id);
        return Response.success(category);
    }

    @GetMapping("/list")
    public Response<Object> list(@RequestParam Integer type) {
        List<Category> categoryList = categoryService.list(type);
        return Response.success(categoryList);
    }

    @PutMapping("/update")
    public Response<Object> update(@RequestBody Category category) {
        categoryService.update(category);
        return Response.success();
    }

    @DeleteMapping("/delete")
    public Response<Object> delete(@RequestParam Integer id) {
        categoryService.deleteById(id);
        return Response.success();
    }
}
