package com.itutry.test;

import com.itutry.utils.JdbcUtils;
import java.sql.Connection;
import org.junit.Test;

/**
 * @author itutry
 * @create 2020-06-02_14:53
 */
public class JdbcUtilsTest {

  @Test
  public void should_get_connection_success() {
    for (int i = 0; i < 20; i++) {
      Connection conn = JdbcUtils.getConnection();
      System.out.println(conn);
      JdbcUtils.close(conn);
    }
  }
}
