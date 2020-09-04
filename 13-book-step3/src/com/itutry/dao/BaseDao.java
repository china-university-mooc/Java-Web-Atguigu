package com.itutry.dao;

import com.itutry.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {

    private QueryRunner queryRunner = new QueryRunner();

    public int update(String sql, Object... params) {
        try {
            return queryRunner.update(getConnection(), sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T queryForOne(Class<T> type, String sql, Object... params) {
        try {
            return queryRunner.query(getConnection(), sql, new BeanHandler<>(type), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> List<T> queryForList(Class<T> type, String sql, Object... params) {
        try {
            return queryRunner.query(getConnection(), sql, new BeanListHandler<>(type), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Object queryForSingleValue(String sql, Object... params) {
        try {
            return queryRunner.query(getConnection(), sql, new ScalarHandler(), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection getConnection() {
        return JdbcUtils.getConnection();
    }
}
