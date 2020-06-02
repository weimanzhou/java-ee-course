package xyz.snowflake.train2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author snowflake
 * @create-date 2020-04-01 13:20
 */
public class T1 {

    public static void main(String[] args) {
        Set<String> courses = new HashSet<>();
        courses.add("计算机网络原理与应用");
        courses.add("软件测试与质量控制");
        courses.add("java EE");
        courses.add("大型数据库管理技术");
        courses.add("软件项目管理");
        courses.iterator()
                .forEachRemaining(System.out::println);
    }

}
