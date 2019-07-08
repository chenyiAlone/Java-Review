package com.example.review.initialization.passivereference;
/**
 * ClassName: SuperClass.java
 * Author: chenyiAlone
 * Create Time: 2019/7/7 21:53
 * Description: 测试
 */
class SuperClass {
    static int value = 123;
    static final int supStaticFinalValue = 200;

    static {
        System.out.println("super static block");
    }
}
