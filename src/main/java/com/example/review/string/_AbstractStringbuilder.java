package com.example.review.string;
/**
 * ClassName: _AbstractStringbuilder.java
 * Author: chenyiAlone
 * Create Time: 2019/7/4 20:13
 * Description: 测试 StringBuilder 探究 AbstractStringBuilder 原理
 */
public class _AbstractStringbuilder {
    /*
    测试 StringBuilder
        1. String#void getBytes(byte dst[], int dstBegin, byte coder) 这个方法的作用没有权限修饰符，
            所以权限为 default，所以 无法使用该方法

        2. AbstractStringBuilder#void ensureCapacityInternal(int minimumCapacity) 确保内部容量(扩容方法)
            的作用就是将数组的长度更新，使用的是 Array.copyOf() 这个方法的作用就是为了 截断 或者 扩展 数组。

        3. return this; 实现了串行调用
    */
    private static void stringBuilder() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("A").append("B").append("C").append("D");
        System.out.println("str: " + stringBuilder);
    }

    public static void main(String[] args) {
        stringBuilder();
    }
}
