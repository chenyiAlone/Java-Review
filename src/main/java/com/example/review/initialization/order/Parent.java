package com.example.review.initialization.order;
/**
 * ClassName: Parent.java
 * Author: chenyiAlone
 * Create Time: 2019/7/5 16:54
 * Description: 测试初始化顺序的测试类 - 父类
 */
public class Parent {
    private static int sP = 1;
    private int uSP = 1;

    static {
        print(null,"Parent static block 1");

    }


    static {
        System.out.println("Parent static block 2");
    }

    private static void print(Parent p, String block) {
        System.out.println(block);
        System.out.println("j: " + sP);
        System.out.println(": " + p.uSP);
    }

}
