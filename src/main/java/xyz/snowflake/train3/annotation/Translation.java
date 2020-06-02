package xyz.snowflake.train3.annotation;

import java.lang.annotation.*;

/**
 * @author snowflake
 * @create-date 2020-04-19 14:55
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD})
@Documented
@Inherited
public @interface Translation {

    String value();

    boolean readonly();

}
