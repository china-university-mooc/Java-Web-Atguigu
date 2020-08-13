package com.itutry.test;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UserServletTest {

    public void login() {
        System.out.println("login()方法被调用");
    }

    public void regist() {
        System.out.println("regist()方法被调用");
    }

    public void updateUser() {
        System.out.println("updateUser()方法被调用");
    }

    @Test
    public void test1() throws Exception {
        String action = "updateUser";
        Method method = UserServletTest.class.getDeclaredMethod(action);
        method.invoke(new UserServletTest());
    }
}
