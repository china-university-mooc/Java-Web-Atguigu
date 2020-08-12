package com.itutry.service;

import com.itutry.pojo.User;

/**
 * @author itutry
 * @create 2020-06-02_15:20
 */
public interface UserService {

  void register(User user);

  User login(User user);

  boolean existUserName(String username);
}
