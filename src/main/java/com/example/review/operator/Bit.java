package com.example.review.operator;
/**
 * ClassName: Bit.java
 * Author: chenyiAlone
 * Create Time: 2019/7/3 20:11
 * Description: 测试按位操作符
 */
public class Bit {

    private static void bitAnd() {
        int i = 0b11110;
        int tailOne = i & -i;
        int eraserTailOne = i & (i - 1);
        System.out.println("tailOne: " + Integer.toBinaryString(tailOne));
        System.out.println("eraserTailOne: " + Integer.toBinaryString(eraserTailOne));

        /*///:~
            tailOne: 10
            eraserTailOne: 11100

        */
    }

    private static void bitNegate() {
        int x = 0b1;
        int nx = ~x;
        int ret = x + nx;

        System.out.println("-x == ~x + 1: " + (-x == nx + 1));

        System.out.println("x: " + Integer.toBinaryString(x));
        System.out.println("nx: " + Integer.toBinaryString(nx));
        System.out.println("ret: " + Integer.toBinaryString(ret));

        /*///:~
            -x == ~x + 1: true

              x:                                1
             nx: 11111111111111111111111111111110
            ret: 11111111111111111111111111111111

        */
    }

    public static void main(String[] args) {
//        bitAnd();
        bitNegate();
    }

}
