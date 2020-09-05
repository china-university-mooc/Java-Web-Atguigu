package com.itutry.test;

import com.itutry.pojo.User;
import com.itutry.service.UserService;
import com.itutry.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @author itutry
 * @create 2020-06-02_15:25
 */
public class UserServiceImplTest {

  private UserService userService = new UserServiceImpl();

  @Test
  public void register() {
    userService.register(new User(null, "lm152", "11111", "lm152@itutry.com"));
  }

  @Test
  public void login() {
    System.out.println(userService.login(new User(null, "lm152", "222222", null)));
    System.out.println(userService.login(new User(null, "lm152", "11111", null)));
  }

  @Test
  public void existUserName() {
    if (userService.existUsername("lm152")) {
      System.out.println("用户名已存在");
    } else {
      System.out.println("用户名可用");
    }
  }
}
