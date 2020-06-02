package xyz.snowflake.train3.dao;

import xyz.snowflake.train3.util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author snowflake
 * @create-date 2020-04-25 14:09
 */
public abstract class AbstractDao implements Dao {

    @Override
    public Object find(String sql, CollumMapping mapping, Object... args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DButil.getConnection();
            statement = connection.prepareStatement(sql);
            for (int i = 1; i <= args.length; i++) {
                statement.setObject(i, args[i - 1]);
            }
            resultSet = statement.executeQuery();
            return mapping.mapping(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButil.free(connection, statement, resultSet);
        }
        return null;
    }

    @Override
    public void save(String sql, Object... args) {
        handler(sql, args);
    }

    /**
     *
     * @param sql   sql     语句
     * @param args  args    参数
     */
    private void handler(String sql, Object[] args) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DButil.getConnection();
            statement = connection.prepareStatement(sql);
            for (int i = 1; i <= args.length; i++) {
                statement.setObject(i, args[i - 1]);
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButil.free(connection, statement, null);
        }
    }

    @Override
    public void update(String sql, Object... args) {
        handler(sql, args);
    }

    @Override
    public void delete(String sql, Object... args) {
        handler(sql, args);
    }


}
