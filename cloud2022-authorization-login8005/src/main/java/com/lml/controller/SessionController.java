package com.lml.controller;

import com.lml.entity.CommonResult;
import com.lml.entity.User;
import com.lml.exception.ApiException;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @author ：limaolin
 * @date ：Created in 2022/10/13 10:49
 * @description：使用session完成基础登录功能
 * @modified By：
 */
@RestController
public class SessionController {

    @PostMapping("/login")
    public CommonResult login(@RequestBody @Valid User user, HttpSession session){
        if("admin".equals(user.getUsername()) && "123456".equals(user.getPassword())){
            session.setAttribute("user",user);
            System.out.println(session.getAttribute("user"));
            return new CommonResult<>("登陆成功,Session成功保存");
        }
        return new CommonResult("账号密码错误");
    }

    @GetMapping("/do")
    public CommonResult doSome(HttpSession session){
        System.out.println(session.getAttribute("user"));
        User user = (User) session.getAttribute("user");
        if (user == null){
            throw new ApiException(40001,"未登录,请先登录");
        }
        return new CommonResult("hello,dododo");
    }

}
