package com.plutus.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {
    private Integer id;
    private String categoryName;
    private Integer type;
    private String color;
    private Integer createUser;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
