package com.itutry.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author itutry
 * @create 2020-06-02_14:41
 */
public class JdbcUtils {

  private static DruidDataSource dataSource;
  private static final ThreadLocal<Connection> conns = new ThreadLocal<>();

  static {
    try {
      Properties properties = new Properties();
      InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
      properties.load(inputStream);
      dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static Connection getConnection() {
    Connection conn = conns.get();

    if (null == conn) {
      try {
        conn = dataSource.getConnection();
        conns.set(conn);
        conn.setAutoCommit(false);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    return conn;
  }

  public static void commitAndClose() {
    Connection conn = conns.get();
    if (conn != null) {
      try {
        conn.commit();
      } catch (SQLException e) {
        e.printStackTrace();
      } finally {
        close(conn);
      }
      conns.remove();
    }
  }

  public static void rollbackAndClose() {
    Connection conn = conns.get();
    if (conn != null) {
      try {
        conn.rollback();
      } catch (SQLException e) {
        e.printStackTrace();
      } finally {
        close(conn);
      }
      conns.remove();
    }
  }

  public static void close(Connection connection) {
    if (connection != null) {
      try {
        connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}
