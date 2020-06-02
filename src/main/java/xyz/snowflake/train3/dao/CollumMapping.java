package xyz.snowflake.train3.dao;

/**
 * @author snowflake
 * @create-date 2020-04-25 14:14
 */
public interface CollumMapping<T, R> {

    /**
     *
     * 将 T 类型转化未 R 类型
     *
     * @param t     参数
     * @return      返回值
     */
    R mapping(T t);

}
