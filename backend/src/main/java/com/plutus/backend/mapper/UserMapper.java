package com.plutus.backend.mapper;

import com.plutus.backend.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    @Select("select * " +
            "from user " +
            "where username=#{username}")
    User findByUsername(String username);

    @Insert("insert into user(username, password, email, telephone, create_time, update_time)" +
            "values (#{username}, #{password}, #{email}, #{telephone}, now(), now())")
    void add(User user);

    @Update("update user " +
            "set username=#{username}, nickname=#{nickname}, telephone=#{telephone}, email=#{email}, update_time=now() " +
            "where id=#{id}")
    void update(User user);

    @Update("update user " +
            "set avatar_url=#{avatarUrl}, update_time=now() " +
            "where id=#{id}")
    void updateAvatar(String avatarUrl, Integer id);

    @Update("update user " +
            "set password=#{newPwd}, update_time=now() " +
            "where id=#{id}")
    void updatePwd(String newPwd, Integer id);
}
