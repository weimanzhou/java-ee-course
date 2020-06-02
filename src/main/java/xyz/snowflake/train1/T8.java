package xyz.snowflake.train1;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author snowflake
 * @create-date 2020-03-18 11:48
 */
public class T8 {

    public static void main(String[] args) {
        List<String> list = List.of("apple", "grape", "banana", "pear");

        list = list.stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());

        System.out.println(list.get(0));
        System.out.println(list.get(3));

        System.out.println("-----------------");

        list.stream()
                .sorted(String::compareTo)
                .forEach(System.out::println);
    }

}
