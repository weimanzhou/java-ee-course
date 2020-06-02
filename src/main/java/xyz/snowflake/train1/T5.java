package xyz.snowflake.train1;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author snowflake
 * @create-date 2020-03-11 0:06
 */
public class T5 {

    static class IDateFormat {
        String format = "YYYY-MM-DD";

        private static final String YEAR = "YYYY";
        private static final String MONTH = "MM";
        private static final String DAY = "DD";

        private static Map<String, Boolean> items = new HashMap<>();

        static {
            items.put(YEAR, true);
            items.put(MONTH, true);
            items.put(DAY, true);
        }

        public IDateFormat() {
            this("YYYY-MM-DD");
        }

        public IDateFormat(String format) {
            this.format = format;
            // 对传入的 format 进行解析
            for (int i = 0; i < format.length(); i++) {
                int index = i;
                while (i < format.length() && format.charAt(index) == format.charAt(i)) {
                    i++;
                }
                if (isChar(format.charAt(index))) {
                    if (!items.containsKey(format.substring(index, i))) {
                        throw new IDateFormatException("不支持的格式：" + format.substring(index, i));
                    }
                }
                i--;
            }
        }

        private boolean isChar(char c) {
            return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
        }

        /**
         * 格式化日期对象
         *
         * @param date 日期对象
         * @return 格式化后的日期对象字符串
         * @throws IDateFormatException 抛出不支持该格式的异常
         */
        public String format(Date date) throws IDateFormatException {
            StringBuilder formatString = new StringBuilder();
            // 解析模式
            for (int i = 0; i < format.length(); i++) {
                int index = i;
                while (i < format.length() && format.charAt(i) == format.charAt(index)) {
                    i++;
                }
                // 获取到一个字串
                String item = format.substring(index, i);
                switch (item) {
                    case YEAR:
                        formatString.append(date.getYear() + 1900);
                        break;
                    case MONTH:
                        formatString.append(date.getMonth() + 1);
                        break;
                    case DAY:
                        formatString.append(date.getDate());
                        break;
                    default:
                        formatString.append(item);
                        break;
//                        throw new IDateFormatException("不支持转化为该格式：" + this.format);
                }
                i--;
            }
            return formatString.toString();
        }

        /**
         * 将 date 日期字符串按照指定的格式解析为 Date 对象
         *
         * @param date 日期字符串
         * @return 日期对象
         */
        public Date parse(String date) {
            Integer[] array = Arrays.stream(date.split("[^0-9]+"))
                    .map(Integer::valueOf)
                    .toArray(Integer[]::new);
            Date newDate = new Date();
            int arrayIndex = 0;
            try {


                // 解析模式
                for (int i = 0; i < format.length(); i++) {
                    int index = i;
                    while (i < format.length() && format.charAt(i) == format.charAt(index)) {
                        i++;
                    }
                    // 获取到一个字串
                    String item = format.substring(index, i);
                    switch (item) {
                        case YEAR:
                            int year = array[arrayIndex++];
                            newDate.setYear(year - 1900);
                            break;
                        case MONTH:
                            int month = array[arrayIndex++];
                            newDate.setMonth(month - 1);
                            break;
                        case DAY:
                            int day = array[arrayIndex++];
                            newDate.setDate(day);
                            break;
                        default:
                            break;
                    }
                }
                return newDate;

            } catch (Exception e) {
                throw new IDateFormatException(date + "不能转化为格式：" + this.format + ",错误原因：" + array[arrayIndex]);
            }
        }

    }

    static class IDateFormatException extends RuntimeException {

        public IDateFormatException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) throws ParseException {
        // 创建一个日期格式化对象
        System.out.println("-----------第一组测试-----------");
        String date = "2020-3-1";
        IDateFormat dateFormat = new IDateFormat("YYYY-MM-DD");
        System.out.println("测试日期：" + date);
        System.out.println("解析为为日期对象：" + dateFormat.parse(date));
        System.out.println("格式化为指定格式：" + dateFormat.format(dateFormat.parse(date)));
        System.out.println("-----------第二组测试-----------");
        System.out.println("月份不合法");
        date = "2020-13-2";
        System.out.println("测试日期：" + date);
        System.out.println("解析为为日期对象：" + dateFormat.parse(date));
        System.out.println("格式化为指定格式：" + dateFormat.format(dateFormat.parse(date)));
        System.out.println("-----------第三组测试-----------");
        System.out.println("日期字符串多出额外的字符");
        date = "2020-13-2-";
        System.out.println("测试日期：" + date);
        System.out.println("解析为为日期对象：" + dateFormat.parse(date));
        System.out.println("格式化为指定格式：" + dateFormat.format(dateFormat.parse(date)));
        System.out.println("-----------第四组测试-----------");
        System.out.println("传入不支持的格式，预测抛出错误");
        dateFormat = new IDateFormat("yyyy-MM-DD");
        date = "2020-13-2";
        System.out.println("测试日期：" + date);
        System.out.println("解析为为日期对象：" + dateFormat.parse(date));
        System.out.println("格式化为指定格式：" + dateFormat.format(dateFormat.parse(date)));
    }

}
