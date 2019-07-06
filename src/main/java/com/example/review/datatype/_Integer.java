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
    }


    private static void autoBoxingAndUnboxing() {
        Integer integer = 1;
        int i = integer;
        System.out.println(i);
    }

    private static void integerCache() {
        Integer a = Integer.valueOf(200);   // 没有命中缓存池
        Integer b = Integer.valueOf(200);

        Integer c = Integer.valueOf(120);   // 命中缓存池
        Integer d = Integer.valueOf(120);

        Integer e = new Integer(100);   // 通过 new Integer(int) 来新建对象
        Integer f = new Integer(100);


        System.out.println("a == b: " + (a == b));
        System.out.println("c == d: " + (c == d));
        System.out.println("e == f: " + (e == f));

        /*///:~

            a == b: false
            c == d: true
            e == f: false
         */
    }



    public static void main(String[] args) {
//        initialization();             // 1. 测试初始化和自动拆箱源码分析
        integerCache();     // 2. 测试缓存池
    }
}
