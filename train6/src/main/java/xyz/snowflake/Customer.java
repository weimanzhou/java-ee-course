package xyz.snowflake;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author snowflake
 * @version v1.0
 * @package xyz.snowflake
 * @title Customer
 * @description
 * @date 2020/6/2 - 10:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private String customerId;
    private String name;
    private String phone;

}
