package com.itutry.dao.impl;

import com.itutry.dao.BaseDao;
import com.itutry.dao.UserDao;
import com.itutry.pojo.User;

/**
 * @author itutry
 * @create 2020-06-02_15:10
 */
public class UserDaoImpl extends BaseDao implements UserDao {

  @Override
  public User queryByUsername(String username) {
    String sql = "select * from user where username=?";
    return queryForOne(User.class, sql, username);
  }

  @Override
  public User queryByUsernameAndPassword(String username, String password) {
    String sql = "select * from user where username=? and password=?";
    return queryForOne(User.class, sql, username, password);
  }

  @Override
  public int saveUser(User user) {
    String sql = "insert into user(username, password, email) values(?,?,?)";
    return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
  }
}
