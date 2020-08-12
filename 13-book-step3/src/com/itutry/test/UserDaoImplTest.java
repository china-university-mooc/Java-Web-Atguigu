package com.itutry.test;

import com.itutry.dao.UserDao;
import com.itutry.dao.impl.UserDaoImpl;
import com.itutry.pojo.User;
import org.junit.Test;

/**
 * @author itutry
 * @create 2020-06-02_15:14
 */
public class UserDaoImplTest {

  private UserDao userDao = new UserDaoImpl();

  @Test
  public void queryByUsername() {
    if (userDao.queryByUsername("admin123") == null) {
      System.out.println("用户名可用");
    } else {
      System.out.println("用户名已存在");
    }
  }

  @Test
  public void queryByUsernameAndPassword() {
    if (userDao.queryByUsernameAndPassword("admin", "admin12") == null) {
      System.out.println("用户名或密码错误，登录失败");
    } else {
      System.out.println("登录成功");
    }
  }

  @Test
  public void saveUser() {
    int i = userDao.saveUser(new User(null, "zz138", "12345", "zz138@itutry.com"));
    System.out.println(i);
  }
}
