package com.lml.interceptor;


import com.lml.entity.UserContext;
import com.lml.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author ：limaolin
 * @date ：Created in 2022/10/17 15:37
 * @description：登录拦截
 * @modified By：
 */

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ("/jwt/login".equals(request.getRequestURL())){
            return true;
        }
        Claims claims = JwtUtil.parse(request.getHeader("Authorization"));
        if (claims != null){
            UserContext.add(claims.getSubject());
            return true;
        }
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write("请先登录");
        writer.flush();
        writer.close();
        return false;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserContext.remove();
        super.afterCompletion(request, response, handler, ex);
    }
}
