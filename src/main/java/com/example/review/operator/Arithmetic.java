package com.example.review.operator;
/**
 * ClassName: Arithmetic.java
 * Author: chenyiAlone
 * Create Time: 2019/7/3 14:05
 * Description: 测试运算操作符
 *
 */
public class Arithmetic {
    /*
    + 操作符:
        String 环境中会自动调用引用对象的 String toString() 方法
    */
    private static void addOperator() {
        int i = 1;
        float f = 12.3F;
        double d = i + f;

        Object obj = new Object();
        String str = f - i + ", str: " + obj;
        System.out.println(str);

        ///:~  str: java.lang.Object@10f87f48
    }

    private static void subOperator() {

        Object obj = new Object();
        String str = "obj: " + obj;
        System.out.println(str);

        ///:~  obj: java.lang.Object@10f87f48
    }


    /*
    类型提升

    */
    private static void upperType() {
        int i = 3;
        float f = 1.0f;

        double ret1 =  f * i / 2 ;
        double ret2 =  f + i / 2 ;
        System.out.println("ret1: " + ret1);
        System.out.println("ret2: " + ret2);

        /*///:~
            ret1: 1.5
            ret2: 2.0
        */
    }

    /*
    = 操作符:
    */
    private static void euqOperator() {
        int b = 0b1010;
        System.out.println("b: " + b);


    }

    /*
    ( ) 类型转化；
        截尾
    */
    public static void bracketsOperator() {
        int i = (int)-0.7f;
        System.out.println(i);

        ///:~ 0
    }

    public static void main(String[] args) {
//        bracketsOperator();     // 1. ( ) 类型转化
//        euqOperator();          // 2. = 操作符
//        addOperator();          // 3. + 操作符
        upperType();            // 4. 类型提升
    }
}
