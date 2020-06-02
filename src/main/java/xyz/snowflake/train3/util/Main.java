package xyz.snowflake.train3.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author snowflake
 * @create-date 2020-04-25 15:52
 */
public class Main {

    public static void main(String[] args) {
        int[] time = {1, 2, 3, 3, 5, 6};
        int m = 2;
        System.out.println(minTime(time, m));
    }

    public static int minTime(int[] time, int m) {
        if (m >= time.length) return 0;
        int[] copy = Arrays.copyOf(time, time.length);
        Arrays.sort(copy);
        List<Integer> list = new ArrayList<>();
        for (int i = copy.length - m; i < copy.length; i++) {
            list.add(copy[i]);
        }
        int tmp = copy[time.length - m];
        int max = 0;
        int val = 0;
        int count = 0;
        for (int i = 0; i < time.length; i++) {
            if (count < m && list.contains(time[i])) {
                count++;
                max = Math.max(max, val);
                val = 0;
                continue;
            }
            if (val + time[i] > tmp) {

            }
            val += time[i];
        }
        return max;
    }

}
