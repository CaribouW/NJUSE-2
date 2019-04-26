package com.example.main.core.exception;

import com.example.main.core.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice // 这个注解是指这个类是处理其他controller抛出的异常
public class ControllerExceptionHandler {
    //这个注解是指当controller中抛出这个指定的异常类的时候，都会转到这个方法中来处理异常
    @ExceptionHandler(Exception.class)
    //将返回的值转成json格式的数据
    @ResponseBody
    //返回的状态码
//    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)     //服务内部错误
    public ExceptionResponse handleException(HttpServletRequest request, HttpServletResponse response,
                                             Exception ex) {
        if (ex instanceof ApiException) {
//            log.warn(ex.getMessage(), ex);
            ApiException apiException = (ApiException) ex;
            response.setStatus(apiException.getCode());
            return ExceptionResponse.create(apiException.getCode(), apiException.getMessage());
        } else {
//            log.error(ex.getMessage(), ex);
            return ExceptionResponse.create(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
        }
    }
}

