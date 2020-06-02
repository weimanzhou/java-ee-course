package xyz.snowflake.train1;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author snowflake
 * @create-date 2020-03-18 12:13
 */
public class T11 {

    public static void main(String[] args) {

        // 测试 ArrayList
        List<Integer> list = new ArrayList<>();
        Instant start =  Instant.now();
        for (int i = 1; i <= 1000000; i++) {
            list.add(i);
        }
        Instant end = Instant.now();
        System.out.println("List 添加 1000000个 元素花费的时间：" + Duration.between(start, end).toMillis() + "ms");


        Set<Integer> set = new HashSet<>();
        start =  Instant.now();
        for (int i = 1; i <= 1000000; i++) {
            set.add(i);
        }
        end = Instant.now();
        System.out.println("Set 添加 1000000个 元素花费的时间：" + Duration.between(start, end).toMillis() + "ms");

        start =  Instant.now();
        for (int i = 1000000; i >= 1; i--) {
            list.remove(i - 1);
        }
        end = Instant.now();
        System.out.println("List 移出 1000000个 元素花费的时间：" + Duration.between(start, end).toMillis() + "ms");

        start =  Instant.now();
        for (int i = 1000000; i >= 1; i--) {
            set.remove(i);
        }
        end = Instant.now();
        System.out.println("Set 移出 1000000个 元素花费的时间：" + Duration.between(start, end).toMillis() + "ms");



    }

}
