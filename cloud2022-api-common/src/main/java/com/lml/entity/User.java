package com.lml.entity;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author ：limaolin
 * @date ：Created in 2022/10/12 17:08
 * @description：用户实体类
 * @modified By：
 */

@Data
public class User {
    @NotNull(message = "用户id不能为空")
    private Long id;

    @NotNull(message = "用户账号不能为空")
    @Size(min = 4, max = 11, message = "账号长度必须是6-11个字符")
    private String username;

    @NotNull(message = "用户密码不能为空")
    @Size(min = 4, max = 11, message = "密码长度必须是6-16个字符")
    private String password;

    @NotNull(message = "用户邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;
}
