package com.example.main.core.exception;

import com.example.main.controller.UserController;
import com.example.main.core.response.ExceptionResponse;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice // 这个注解是指这个类是处理其他controller抛出的异常
public class ControllerExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
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

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public Resource<?> handleNullPointer(Exception e) {
        return new Resource<>(e);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Resource<?> handleInternalError(Exception e) {
        return new Resource<>(e);
    }
}

