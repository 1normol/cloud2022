package com.lml.handler;

import cn.hutool.core.collection.CollectionUtil;
import com.lml.entity.CommonResult;
import com.lml.exception.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.MethodInvocationException;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ：limaolin
 * @date ：Created in 2022/10/12 16:44
 * @description：全局异常返回
 * @modified By：
 */
@RestControllerAdvice
@Slf4j
public class CommonExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public CommonResult apiException(ApiException e){
        return new CommonResult(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public CommonResult Exception(Exception e){
        return new CommonResult(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResult validationException(MethodArgumentNotValidException e){
        if (CollectionUtil.isNotEmpty(e.getBindingResult().getAllErrors())){
            ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
            log.error(objectError.getDefaultMessage());
            return new CommonResult(40001,"参数校验异常",objectError.getDefaultMessage());
        }
        log.error("参数校验异常",e.getMessage());
        return new CommonResult(40001,e.getMessage());
    }
}
