package com.itutry.dao;

import com.itutry.pojo.User;

/**
 * @author itutry
 * @create 2020-06-02_15:09
 */
public interface UserDao {

  User queryByUsername(String username);

  User queryByUsernameAndPassword(String username, String password);

  int saveUser(User user);
}
