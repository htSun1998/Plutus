package com.plutus.backend.mapper;

import com.plutus.backend.entity.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {
    @Select("select * from category where category_name=#{categoryName} and create_user=#{loginId}")
    Category findByCategoryNameAndId(String categoryName, Integer loginId);

    @Insert("insert into category(category_name, icon_url, create_user, create_time, update_time)" +
            "values (#{categoryName}, #{iconUrl}, #{createUser}, now(), now())")
    void add(Category category);

    @Select("select * from category where create_user=#{loginId}")
    List<Category> list(Integer loginId);

    @Update("update category set category_name=#{categoryName}, icon_url=#{iconUrl}, update_time=now() where id=#{id}")
    void update(Category category);

    @Delete("delete from category where id=#{id}")
    void deleteById(Integer id);
}
