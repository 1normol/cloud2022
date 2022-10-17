package com.lml.exception;

import lombok.Data;
import lombok.Getter;

/**
 * @author ：limaolin
 * @date ：Created in 2022/10/12 16:54
 * @description：自定义异常
 * @modified By：
 */
@Getter
public class ApiException extends RuntimeException{
    private Integer code;
    private String message;
    public ApiException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
