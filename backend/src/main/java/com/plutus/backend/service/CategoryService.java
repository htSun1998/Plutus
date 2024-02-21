package com.plutus.backend.service;

import com.plutus.backend.entity.Category;
import com.plutus.backend.mapper.CategoryMapper;
import com.plutus.backend.utils.ThreadLocalUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CategoryService {
    @Resource
    CategoryMapper categoryMapper;

    public List<Category> findByCategoryName(String categoryName1) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer loginId = (Integer) map.get("id");
        return categoryMapper.findByCategoryName(categoryName1, loginId);
    }

    public void add(Category category) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        category.setCreateUser(id);
        categoryMapper.add(category);
    }

    public List<Category> list(Integer type) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer loginId = (Integer) map.get("id");
        return categoryMapper.list(loginId, type);
    }

    public void update(Category category) {
        categoryMapper.update(category);
    }

    public void deleteById(Integer id) {
        categoryMapper.deleteById(id);
    }

    public Category findById(Integer id) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer loginId = (Integer) map.get("id");
        return categoryMapper.search(loginId, id);
    }
}
