package xyz.snowflake.dao;

import xyz.snowflake.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author snowflake
 * @version v1.0
 * @package xyz.snowflake.dao
 * @title CustomerDaoImpl
 * @description
 * @date 2020/6/2 - 17:57
 */
public class CustomerDaoImpl extends AbstractDao implements CustomerDao {

    @Override
    public void deleteByCid(String cid) {
        delete("delete from customers where customer_id=?", cid);
    }

    @Override
    public void updateCustomer(Customer cus) {
        update("update  customers set name=?, phone=? where customer_id=?",
                cus.getName(), cus.getPhone(), cus.getCustomerId());
    }

    public void save(Customer cus) {
        save("insert into customers values(?, ?, ?)",
                cus.getCustomerId(), cus.getName(), cus.getPhone());
    }

    @Override
    public List<Customer> findAll() {
        return (List<Customer>) find("select * from customer", resultSet -> {
            List<Customer> clist = new ArrayList<>();
            while (true) {
                try {
                    if (!((ResultSet) resultSet).next()) {
                        break;
                    }
                    Customer cus = new Customer();
                    cus.setCustomerId(((ResultSet) resultSet).getString(1));
                    cus.setName(((ResultSet) resultSet).getString(2));
                    cus.setPhone(((ResultSet) resultSet).getString(3));
                    clist.add(cus);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return clist;
        });
    }


}
