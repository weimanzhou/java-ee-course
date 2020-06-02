package xyz.snowflake.dao;

/**
 * @author snowflake
 * @create-date 2020-04-19 16:48
 */
public interface Dao {

    /**
     * 查找方法
     * @param sql       sql 语句
     * @param mapping   映射关系
     * @param args      sql 参数
     * @return          返回值
     */
    Object find(String sql, CollumMapping mapping, Object... args);

    /**
     * 存储方法
     *
     * @param sql       sql 语句
     * @param args      sql 参数
     */
    void save(String sql, Object... args);

    /**
     * 更新方法
     * @param sql       sql 语句
     * @param args      sql 参数
     */
    void update(String sql, Object... args);

    /**
     * 删除方法
     * @param sql       sql 语句
     * @param args      sql 参数
     */
    void delete(String sql, Object... args);

}
