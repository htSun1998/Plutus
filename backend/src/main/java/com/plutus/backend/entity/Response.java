package com.plutus.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
    private Integer code;
    private String message;
    private T data;

    public static <E> Response<E> success() {
        return new Response<>(0, "操作成功", null);
    }

    public static <E> Response<E> success(E data) {
        return new Response<>(0, "操作成功", data);
    }

    public static <E> Response<E> error(String message) {
        return new Response<>(1, message, null);
    }
}
