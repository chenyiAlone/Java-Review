package com.example.review.string;
/**
 * ClassName: ByteCode1.java
 * Author: chenyiAlone
 * Create Time: 2019/7/5 8:53
 * Description: 测试字符串拼什么时候会创建新的 StringBuilder 对象
 *
 *  (具体的证明在 ByteCode1-Decompile.txt 反编译文件中，自行查看)
 *
 */
public class ByteCode1 {

    /*
    这里在 str 的拼接中，插入了 String a 的拼接，来查看会有几个 StringBuilder 对象生成
        1. 对于纯字面量的字符串赋值表达式 (= 赋值)，不会创建 StringBuilder 对象
        2. 对于存在了 String 对象引用的表达式中(如 str += "", 或者 str = str1 + "") 都会创建新的 StringBuilder 对象，
            一条语句一个对象，也就证明了为什么 for 循环不能使用 str += "" 来进行延长字符串

    */
    public static void main(String[] args) {
        String a = " you?";         // a 拼接 (1)=> 不创建 StringBuilder 对象

        String str = "who" + " are";    // str 拼接 (1)=> 不创建新的 StringBuilder 对象

        str += a;           // str 拼接 (2)=> += 为一条字符串拼接表达式，且 str 为 String 类型，创建第 1 个 StringBuilder

        a += "How?";            // a 拼接(2)=> 创建第 2 个 StringBuilder

        str += " And";          // str 拼接 (3)=> 创建第 3 个 StringBuilder

        str += " I am ok!";     // str 拼接 (4) => 创建第 4 个 StringBuilder

        str = new String("new String()");   // 使用 new 创建是否使用 StringBuilder? x ,非拼接，不使用 StringBuilder

        System.out.println(str);
    }
}
