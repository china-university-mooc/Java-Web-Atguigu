package com.itutry.service.impl;

import com.itutry.dao.UserDao;
import com.itutry.dao.impl.UserDaoImpl;
import com.itutry.pojo.User;
import com.itutry.service.UserService;

/**
 * @author itutry
 * @create 2020-06-02_15:22
 */
public class UserServiceImpl implements UserService {

  private UserDao userDao = new UserDaoImpl();

  @Override
  public void register(User user) {
    userDao.saveUser(user);
  }

  @Override
  public User login(User user) {
    return userDao.queryByUsernameAndPassword(user.getUsername(), user.getPassword());
  }

  @Override
  public boolean existUserName(String username) {
    return userDao.queryByUsername(username) != null;
  }
}
