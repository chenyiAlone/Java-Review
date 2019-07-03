package com.example.review.string;
/**
 * ClassName: _String.java
 * Author: chenyiAlone
 * Create Time: 2019/7/3 21:04
 * Description: 测试 String
 */
public class _String {

    private static void stringBuilder() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("A").append("B").append("C").append("D");
        System.out.println("str: " + stringBuilder);
    }

    private static void addOperator() {
        int a = 3, b = 4;
        Object o = new Object();
        String str = "";
        str += a * b;
        System.out.println(str);
    }


    public static void main(String[] args) {
        stringBuilder();
    }
}
