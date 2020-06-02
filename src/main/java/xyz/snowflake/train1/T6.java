package xyz.snowflake.train1;

import java.time.LocalDate;

/**
 * @author snowflake
 * @create-date 2020-03-11 21:18
 */
public class T6 {

    static class IDate {

        /**
         * 标识年份
         */
        public static final int YEAR = 1;
        /**
         * 标识月份
         */
        public static final int MONTH = 2;
        /**
         * 标识天份
         */
        public static final int DAY = 4;
        /**
         * 最大月数
         */
        public static final int MAX_MONTH = 12;
        /**
         * 每月的天数，会根据不同的年份进行修正
         */
        private static final int[] DAYS_OF_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        /**
         * 存储当前年份
         */
        private int year;
        /**
         * 存储当前月份
         */
        private int month;
        /**
         * 存储当前日份
         */
        private int day;

        public IDate() {
            // 这里使用 Date
            this(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth());
        }

        public IDate(int year, int month ,int day) {
            this.year = year;
            this.month = month;
            this.day = day;
            // 根据年份的改变去修改二月的天数。
            updateDaysOfMonthInLeapYear();
        }

        /**
         * 设置某种日期类型的时间
         *
         * @param part  日期类型
         * @param nums  具体值
         * @return      返回 this
         */
        public IDate setDate(int part, int nums) throws IDateException {

            switch (part) {
                case YEAR:
                    this.year = nums;
                    break;
                case MONTH:
                    if (nums < 1 || nums > 12) {
                        throw new IDateException("月份日期值不在合法范围内");
                    }
                    this.month = nums;
                    break;
                case DAY:
                    if (nums < 1 || nums > DAYS_OF_MONTH[this.month - 1]) {
                        throw new IDateException("天数日期值不在合法范围内");
                    }
                    this.day = nums;
                    break;
                default:
            }

            updateDaysOfMonthInLeapYear();
            return this;
        }

        /**
         * 根据指定的日期的类型，加上响应的日期
         *
         * @param part  日期的类型（年、月、天）
         * @param nums  要加上的数字
         * @return      返回修正后的日期对象
         */
        public IDate addDate(int part, int nums) {
            switch (part) {
                case YEAR:
                    this.year = this.year + nums;
                    break;
                case MONTH:
                    int newMonth = this.month + nums;
                    while (newMonth > MAX_MONTH) {
                        this.year++;
                        newMonth -= MAX_MONTH;
                    }
                    while (newMonth < 1) {
                        this.year--;
                        newMonth += MAX_MONTH;
                    }
                    this.month = newMonth;
                    break;
                case DAY:
                    int newDay = this.day + nums;
                    // 计算获取当月最大的天数
                    while (newDay > DAYS_OF_MONTH[this.month - 1]) {
                        newDay -= DAYS_OF_MONTH[this.month - 1];
                        this.month++;
                        if (this.month > MAX_MONTH) {
                            this.month ^= MAX_MONTH;
                            this.year++;
                        }
                        updateDaysOfMonthInLeapYear();
                    }
                    while (newDay < 1) {
                        newDay += DAYS_OF_MONTH[this.month - 1];
                        this.month--;
                        if (this.month < 1) {
                            this.year--;
                        }
                        updateDaysOfMonthInLeapYear();
                    }
                    this.day = newDay;
                    break;
                default:
                    break;
            }
            updateDaysOfMonthInLeapYear();
            return this;
        }

        /**
         * 更新月份的天数，如果是闰年二月应该为 28 天。
         */
        private void updateDaysOfMonthInLeapYear() {
            if (isLeapYear()) {
                DAYS_OF_MONTH[1] = 28;
            } else {
                DAYS_OF_MONTH[1] = 29;
            }
        }

        /**
         * 获取当月的最大天数
         *
         * @return  当月的最大天数
         */
        public int daysOfMonth() {
            return DAYS_OF_MONTH[this.month];
        }

        /**
         * 判断this和otherDate在不同类型的日期上相差的时间
         *
         * @param field         日期类型
         * @param otherDate     另外一个日期对象
         * @return              返回在 field 类型上相差的日期
         */
        public int diffDate(int field, IDate otherDate) {
            switch (field) {
                case YEAR:
                    return otherDate.getYear() - this.year;
                case MONTH:
                    return Math.abs(otherDate.getYear() * MAX_MONTH + otherDate.getMonth() - year * MAX_MONTH + month);
                case DAY:
                    int days = 0;
                    IDate date = new IDate(year, month, day);
                    if (date.isBefore(otherDate)) {
                        while (!date.isEquals(otherDate)) {
                            date.addOneDay();
                            days++;
                        }
                    } else {
                        while (!date.isEquals(otherDate)) {
                            otherDate.addOneDay();
                            days++;
                        }
                    }
                    return days;
                default:
                    throw new IDateException("不支持该类型");
            }
        }

        /**
         * 判断两个日期是否相等
         *
         * @param date  另外一个日期
         * @return      如果相等返回 true ，否则返回 false
         */
        private boolean isEquals(IDate date) {
            return year == date.year && month == date.month && day == date.day;
        }

        public IDate addOneDay() {
            return addDate(DAY, 1);
        }

        public IDate minusOneDay() {
            return addDate(DAY, -1);
        }

        public IDate addOneWeek() {
            return addDate(DAY, 7);
        }

        public IDate minusOneWeek() {
            return addDate(DAY, -7);
        }

        public IDate addOneMonth() {
            return addDate(MONTH, 1);
        }

        public IDate minusOneMonth() {
            return addDate(MONTH, -1);
        }

        public IDate addOneYear() {
            return addDate(YEAR, 1);
        }

        public IDate minusOneYear() {
            return addDate(YEAR, -1);
        }

        /**
         * 判断当前日期是否比 date 日期之前
         *
         * @param date  另外一个日期
         * @return      如果当前日期在 date 日期之前则返回 true，否则返回 false
         */
        public boolean isBefore(IDate date) {
            if (year == date.year) {
                return month == date.month ? day < date.day : month < date.month;
            } else {
                return year < date.year;
            }
        }

        /**
         * 判单当前年份是否是闰年
         *
         * @return  如果是闰年返回 true，否则返回 false
         */
        private boolean isLeapYear() {
            return this.year % 4 == 0 && this.year % 100 != 0 || this.year % 400 == 0;
        }

        public int getYear() {
            return year;
        }

        public int getMonth() {
            return month;
        }

        public int getDay() {
            return day;
        }

        @Override
        public String toString() {
            return year + "年" + month + "月" + day + "日";
        }
    }

    static class IDateException extends RuntimeException {

        public IDateException(String message) {
            super(message);
        }

    }

    public static void main(String[] args) {
        IDate date = new IDate();
        System.out.print("当前日期:");
        System.out.println(date);
        date.addOneDay();
        System.out.print("当前日期加上一天:");
        System.out.println(date);
        date.minusOneDay();
        System.out.print("当前日期减上一天:");
        System.out.println(date);
        date.addOneWeek();
        System.out.print("当前日期加上一周:");
        System.out.println(date);
        date.minusOneWeek();
        System.out.print("当前日期减上一周:");
        System.out.println(date);
        date.addOneMonth();
        System.out.print("当前日期加上一月:");
        System.out.println(date);
        date.minusOneMonth();
        System.out.print("当前日期减上一月:");
        System.out.println(date);
        date.addOneYear();
        System.out.print("当前日期加上一年:");
        System.out.println(date);
        date.minusOneYear();
        System.out.print("当前日期减上一年:");
        System.out.println(date);
        IDate date2 = new IDate(2020, 3, 15);
        int differenceDate = date.diffDate(IDate.DAY, date2);
        System.out.println(date + " 和 " + date2 + "相差：" + differenceDate + "天");

        date.setDate(IDate.DAY, 10);
        date.setDate(IDate.MONTH, 10);
        date.setDate(IDate.YEAR, 1999);
        System.out.println("设置日期为：1999年10月10日:");
        System.out.println("结果为：" + date);
    }

}
