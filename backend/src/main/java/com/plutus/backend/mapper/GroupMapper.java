package com.plutus.backend.mapper;

import com.plutus.backend.entity.UserGroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GroupMapper {
    @Select("select * " +
            "from user_group " +
            "where id=#{id}")
    UserGroup findById(Integer id);
}
