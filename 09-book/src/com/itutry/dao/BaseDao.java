package com.itutry.dao;

import com.itutry.utils.JdbcUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

/**
 * @author itutry
 * @create 2020-06-02_14:58
 */
public abstract class BaseDao {

  private QueryRunner queryRunner = new QueryRunner();

  public int update(String sql, Object... params) {
    Connection conn = JdbcUtils.getConnection();

    try {
      return queryRunner.update(conn, sql, params);
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JdbcUtils.close(conn);
    }

    return -1;
  }

  public <T> T queryForOne(Class<T> type, String sql, Object... params) {
    Connection conn = JdbcUtils.getConnection();

    try {
      return queryRunner.query(conn, sql, new BeanHandler<>(type), params);
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JdbcUtils.close(conn);
    }

    return null;
  }

  public <T> List<T> queryForList(Class<T> type, String sql, Object... params) {
    Connection conn = JdbcUtils.getConnection();
    try {
      return queryRunner.query(conn, sql, new BeanListHandler<>(type), params);
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JdbcUtils.close(conn);
    }

    return null;
  }

  public Object queryForSingleValue(String sql, Object... params) {
    Connection conn = JdbcUtils.getConnection();

    try {
      return queryRunner.query(conn, sql, new ScalarHandler(), params);
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JdbcUtils.close(conn);
    }

    return null;
  }
}
