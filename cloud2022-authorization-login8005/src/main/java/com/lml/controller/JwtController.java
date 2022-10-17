package com.lml.controller;

import com.lml.entity.CommonResult;
import com.lml.entity.User;
import com.lml.entity.UserContext;
import com.lml.exception.ApiException;
import com.lml.util.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：limaolin
 * @date ：Created in 2022/10/17 15:14
 * @description：jwt控制层
 * @modified By：
 */
@RestController
@RequestMapping("/jwt")
public class JwtController {

    @GetMapping("/login")
    public CommonResult login(@RequestBody User user){
        if ("admin".equals(user.getUsername())&&"123456".equals(user.getPassword())){
            return new CommonResult(200,"success",JwtUtil.generate(user.getUsername()));
        }
        return new CommonResult(500,"账号或密码错误");
    }

    //eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY2NTk5Mjc3MiwiZXhwIjoxNjY1OTk5OTcyfQ.Ifxo1xO_S3tdosEkLTn1LNCyBsHZFcZ0lAeWUDHA6VTCCjCSnHmqdMuTrU4FjFAO2Xyak_Sg4vPGcmk7ASvY7A
    @GetMapping("api1")
    public CommonResult api1(HttpServletRequest request){
/*        String jwt = request.getHeader("Authorization");
        if (JwtUtil.parse(jwt) == null){
            throw new ApiException(501,"没有接收到token");
        }*/
         return new CommonResult(200,"成功","操作人为:"+UserContext.getCurrentUserName());
    }

    @GetMapping("api2")
    public CommonResult api2(HttpServletRequest request){
/*        String jwt = request.getHeader("Authorization");
        if (JwtUtil.parse(jwt) == null){
            throw new ApiException(501,"没有接收到token");
        }*/
        return new CommonResult(200,"成功");
    }
}
