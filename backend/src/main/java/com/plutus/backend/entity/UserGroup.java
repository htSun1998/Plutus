package com.plutus.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserGroup implements Serializable {
    private Integer id;
    private String groupName;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
