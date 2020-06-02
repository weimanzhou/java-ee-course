package xyz.snowflake.train3.util;

import java.sql.*;

/**
 * @author snowflake
 * @create-date 2020-04-19 14:47
 */
public class DButil {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:1206/java_ee_train2";
    private static final String USER = "root", PASSWORD = "";
    private static Connection con;

    /*加载驱动程序*/
    static {
        try {
            Class.forName(DRIVER);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     *
     * 返回 Connection 对象
     *
     * @return                  Connection 对象
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void free(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            freeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                freeStatement(statement);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                freeResultSet(resultSet);
            }
        }
    }

    public static void free(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        try {
            freeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                freePreparedStatement(statement);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                freeResultSet(resultSet);
            }
        }
    }

    public static void free(Connection connection, CallableStatement statement, ResultSet resultSet) {
        try {
            freeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                freeCallableStatement(statement);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                freeResultSet(resultSet);
            }
        }
    }

    private static void freeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    private static void freeStatement(Statement statement) throws SQLException {
        if (statement != null) {
            statement.close();
        }
    }

    private static void freePreparedStatement(PreparedStatement statement) throws SQLException {
        if (statement != null) {
            statement.close();
        }
    }

    private static void freeCallableStatement(CallableStatement statement) throws SQLException {
        if (statement != null) {
            statement.close();
        }
    }

    private static void freeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
