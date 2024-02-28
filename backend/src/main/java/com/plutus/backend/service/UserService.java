package com.plutus.backend.service;

import com.plutus.backend.entity.User;
import com.plutus.backend.mapper.UserMapper;
import com.plutus.backend.utils.ThreadLocalUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {
    @Resource
    UserMapper userMapper;

    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    public void register(User user) {
        userMapper.add(user);
    }

    public void update(User user) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        user.setId(id);
        userMapper.update(user);
    }

    public void updateAvatar(String avatarUrl) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        userMapper.updateAvatar(avatarUrl, id);
    }

    public void updatePwd(String newPwd) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        userMapper.updatePwd(newPwd, id);
    }

    public Integer getGroupId() {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        return userMapper.getGroupId(id);
    }
}
