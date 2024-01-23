package com.plutus.backend.exception;

import com.plutus.backend.entity.Response;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Response<Object> handleException(Exception e) {
        e.printStackTrace();
        return Response.error(StringUtils.hasLength(e.getMessage()) ? e.getMessage() : "操作失败");
    }
}