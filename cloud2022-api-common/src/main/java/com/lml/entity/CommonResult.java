package com.lml.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author ：limaolin
 * @date ：Created in 2022/8/29 11:33
 * @description：公共返回结果
 * @modified By：
 */
@Data
@AllArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }

    public CommonResult(String message){
        this.message = message;
    }


}
