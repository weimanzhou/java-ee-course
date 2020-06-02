package xyz.snowflake.train1;

import java.sql.Time;
import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * @author snowflake
 * @create-date 2020-03-10 23:24
 */
public class T3 {

    public static void main(String[] args) {
        // 获取当前日期
        LocalDate now = LocalDate.now();
        // 记录我的生日
        LocalDate birthday = LocalDate.of(Year.now().getValue(), 12, 6);

        // 首先比较其月份，如果当前月份大于我的生日月份，则年份要加一
        if (now.getMonthValue() > birthday.getMonthValue()) {
            birthday = birthday.plusYears(1);
        } else if (now.getMonthValue() == birthday.getMonthValue()
                && now.getDayOfMonth() > birthday.getDayOfMonth()) {
            birthday = birthday.plusYears(1);
        }

        long days = ChronoUnit.DAYS.between(now, birthday);
        System.out.println("今天是：" +  now);
        System.out.println("下个生日是：" + birthday);
        System.out.println("距离下个生日还有：" + days + "天");
    }

}
