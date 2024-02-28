package com.plutus.backend.service;

import com.plutus.backend.entity.UserGroup;
import com.plutus.backend.mapper.GroupMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class GroupService {
    @Resource
    GroupMapper groupMapper;

    public UserGroup findById(Integer id) {
        return groupMapper.findById(id);
    }
}
