package xyz.snowflake.train3.annotation;

import java.lang.annotation.*;

/**
 * @author snowflake
 * @create-date 2020-04-19 15:18
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD})
@Documented
@Inherited
public @interface Insert {

    String value();

}
