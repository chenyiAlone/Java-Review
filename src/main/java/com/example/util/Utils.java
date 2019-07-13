package com.example.util;
/**
 * ClassName: Utils.java
 * Author: chenyiAlone
 * Create Time: 2019/7/12 9:29
 * Description: 工具类
 */
public class Utils {

    /**
     * == System.out.println(str);
     *
     * @param str 要打印的字符串
     * @return 输入的字符串
     */
    public static String log(String str) {
        return log(str, '?', 2);
    }

    public static String log(String str, int w) {
        return log(str, '?', w);
    }

    public static String log(String str, boolean ln) {
        return log(str, ln, '?', 2);
    }

    /**
     * 包装 str
     * ---------- str ----------
     *
     * @param str 要打印的字符串
     * @param c 用来包围字符创的字符, e.g. -
     * @return 修饰好的字符串 , e.g. ---------- str ----------
     */
    public static String log(String str, char c) {
        return log(str, c, 2);
    }

    /**
     *
     * @param str 要包装的字符串
     * @param c 用来包装的字符
     * @param w 前后换行
     * @return 修饰好的字符串
     */
    public static String log(String str, char c, int w) {
        return log(str, true, c, w);
    }

    /**
     *
     * @param str 打印的字符串
     * @param ln 时候单独一行
     * @param c
     * @param w
     * @return
     */
    public static String log(String str, boolean ln, char c, int w) {

        StringBuilder ret = new StringBuilder();
        if (w == 0 || w == -1) ret.append("\n");

        if (c != '?') {
            for (int i = 0; i < 10; i++) ret.append(c);
            ret.append(' ');
        }

        ret.append(str);

        if (c != '?') {
            ret.append(' ');
            for (int i = 0; i < 10; i++) ret.append(c);
        }

        if (w == 0 || w == 1) ret.append("\n");

        System.out.print(ret + (ln ? "\n" : ""));
        return ret.toString();
    }

}
