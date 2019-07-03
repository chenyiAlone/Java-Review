package com.example.review.datatype;
/**
 * ClassName: _Integer.java
 * Author: chenyiAlone
 * Create Time: 2019/7/2 15:02
 * Description: 测试 Integer 类型
 * 结论:
 *  1.  自动装箱： Integer valueOf(int i)
 *      自动拆箱： int intValue()
 *
 *  2.  IntegerCache.low ~ Integer.high 享元模式
 *  3.  Integer.valueOf(int i) 新建对象
 *  4.  long a = 123L;
 *      float f = 234f;
 *
 */
public class _Integer {
    private static void init() {
        int a = 1;
        long b = 3000000000L;
        Integer integer = 1;
        int i = integer;
        System.out.println(i);
    }



    public static void main(String[] args) {
        init(); // 测试初始化
    }
}
