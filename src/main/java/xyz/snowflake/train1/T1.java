package xyz.snowflake.train1;

import java.util.Arrays;

/**
 * @author snowflake
 * @create-date 2020-03-10 23:02
 */
public class T1 {

    public static void main(String[] args) {

        String str = "Solutions to selected exercises can be found "
                + "in the electronic document The Thinking in Java Annotated "
                + "Solution Guide, available for a small fee from BruceEckel";

        Arrays.stream(str.split("[ ,，]+"))
                .forEach(System.out::println);

    }

}


