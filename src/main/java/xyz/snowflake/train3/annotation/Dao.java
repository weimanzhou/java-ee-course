package xyz.snowflake.train3.annotation;

import java.lang.annotation.*;

/**
 * @author snowflake
 * @create-date 2020-04-19 15:18
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE})
@Documented
@Inherited
public @interface Dao {
}
