package xyz.snowflake.dao;

import xyz.snowflake.Customer;

import java.util.List;

/**
 * @author snowflake
 * @version v1.0
 * @package xyz.snowflake
 * @title CustomerDao
 * @description
 * @date 2020/6/2 - 10:36
 */
public interface CustomerDao extends Dao {

    void deleteByCid(String cid);
    void updateCustomer(Customer cus);
    List<Customer> findAll();

}
