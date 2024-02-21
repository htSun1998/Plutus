package com.plutus.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String telephone;
    private String nickname;
    private String avatarUrl;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
