package xyz.snowflake.train1;

/**
 * @author snowflake
 * @create-date 2020-03-10 23:07
 */
public class T2 {

    /**
     *
     * text     为主串
     * pattern  为子串
     *
     * 当 text 为 "aaa", pattern 为 "aa" 时, 结果将会返回 两个, 而不是一个
     * 当主串中找到一个字串, 将舍弃掉包含前面匹配的串只留下匹配的第一个字符之后的字符串
     *
     * @param args  main 方法的参数
     */
    public static void main(String[] args) {
        String text = "aabbccddeedddd";
        String pattern = "dd";

        int index = 0;
        int count = 0;
        while (index + pattern.length() <= text.length()) {
            int findIndex= text.substring(index).indexOf(pattern);
            if (findIndex != -1) {
                count++;
                index += findIndex + 1;
            } else {
                break;
            }
        }

        System.out.println("主串：" + text);
        System.out.println("子串：" + pattern);
        System.out.println("子串：" + pattern + "出现了" + count + "次");
    }

}
