package com.example.review.string;
/**
 * ClassName: _StringBuilder.java
 * Author: chenyiAlone
 * Create Time: 2019/7/6 15:52
 * Description: 测试 StringBuilder 创建的 StringBuilder
 */
public class _StringBuilder {
    /*
    测试 StringBuilder 来创建对象的情况
        只有一个字符串进行拼接的时候
            1. new StringBuilder("123").toString();
            2. new StringBuilder().append("123").toString();

        多个字符串拼接
            1. new StringBuilder("123").append("456").toString();
            2. new StringBuilder().appned("123").append("456").toString();
    */
    private static void stringBuilderCreateString1() {
        String a = new StringBuilder("abc").toString();
        String b = new StringBuilder().append("789").toString();

        String c = new StringBuilder("abc").append("def").toString();
        String d = new StringBuilder().append("123").append("456").toString();

        System.out.println("a == a.intern(): " + (a == a.intern()));
        System.out.println("b == b.intern(): " + (b == b.intern()));
        System.out.println("c == c.intern(): " + (c == c.intern()));
        System.out.println("d == d.intern(): " + (d == d.intern()));

        /*///:~

            a == a.intern(): false
            b == b.intern(): false
            c == c.intern(): true
            d == d.intern(): true
         */
    }


    private static void stringBuilderCreateString2() {
        // Create three strings in three different ways.
        String s1 = "Hello";
        String s2 = new StringBuffer("He").append("llo").toString();
        String s3 = s2.intern();

        // Determine which strings are equivalent using the ==
        // operator
        System.out.println("s1 == s2: " + (s1 == s2)); // false
        System.out.println("s1 == s3: " + (s1 == s3)); // true
    }

    private static void stringBuilderCreateString3() {
        String s1 = new String("a") + new String("b");
        s1.intern();
        String s2 = new StringBuilder().append("a").append("b").toString();

        System.out.println("s1 == s2: " + (s1 == s2));  // false

//        System.out.println("s1.intern() == s2: " + (s1.intern() == s2));
    }


    public static void main(String[] args) {
        stringBuilderCreateString1();   // 测试使用 StringBuilder 来创建字符串什么时候会放到常量池中
//        stringBuilderCreateString2();
//        stringBuilderCreateString3();

    }

}
