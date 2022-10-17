package com.lml.entity;

/**
 * @author ：limaolin
 * @date ：Created in 2022/10/17 16:07
 * @description：用户上下文，用于jwt
 * @modified By：
 */

public class UserContext {
    private static final ThreadLocal<String> user = new ThreadLocal<String>();

    public static void add(String userName){
        user.set(userName);
    }

    public static void remove(){
        user.remove();
    }

    public static String getCurrentUserName(){
        return user.get();
    }
}
