package com.plutus.backend.mapper;

import com.plutus.backend.entity.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {
    @Select("select * from category where " +
            "category_name_1=#{categoryName1} and create_user=#{loginId}")
    List<Category> findByCategoryName(String categoryName1, Integer loginId);

    @Insert("insert into category(category_name_1, category_name_2, type, icon_url, create_user, create_time, update_time)" +
            "values (#{categoryName1}, #{categoryName2}, #{type}, #{iconUrl}, #{createUser}, now(), now())")
    void add(Category category);

    @Select("select * from category where create_user=#{loginId}")
    List<Category> list(Integer loginId);

    @Update("update category set " +
            "category_name_1=#{categoryName1}, category_name_2=#{categoryName2}, type=#{type}, icon_url=#{iconUrl}, update_time=now() " +
            "where id=#{id}")
    void update(Category category);

    @Delete("delete from category where id=#{id}")
    void deleteById(Integer id);
}
