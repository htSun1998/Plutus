package com.plutus.backend.mapper;

import com.plutus.backend.entity.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {
    @Select("select * " +
            "from category " +
            "where category_name=#{categoryName} " +
            "and create_user=#{loginId}")
    Category findByCategoryName(String categoryName, Integer loginId);

    @Insert("insert into category(category_name, type, color, create_user, create_time, update_time)" +
            "values (#{categoryName}, #{type}, #{color}, #{createUser}, now(), now())")
    void add(Category category);

    @Select("select * " +
            "from category " +
            "where create_user=#{loginId}")
    List<Category> list(Integer loginId);

    @Update("update category " +
            "set category_name=#{categoryName}, type=#{type}, color=#{color}, update_time=now() " +
            "where id=#{id}")
    void update(Category category);

    @Delete("delete from category " +
            "where id=#{id}")
    void deleteById(Integer id);

    @Select("select * " +
            "from category " +
            "where create_user=#{loginId} " +
            "and id=#{id}")
    Category search(Integer loginId, Integer id);
}
