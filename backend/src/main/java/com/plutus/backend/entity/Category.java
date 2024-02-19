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
    private String categoryName1;
    private String categoryName2;
    private Integer type;
    private String iconUrl;
    private Integer createUser;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
