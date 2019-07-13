package com.example.review.initialization.passivereference;
/**
 * ClassName: SubClass.java
 * Author: chenyiAlone
 * Create Time: 2019/7/7 21:52
 * Description: 测试被动引用的 子类
 */
class SubClass extends SuperClass {
    static final int subStaticFinalValue = 120;
    static final int  subStaticFinalValue2 = initFinalVal();
    static {
        System.out.println("subclass static block");
    }

    private static int initFinalVal() {
        System.out.println("init final value2");
        return 10;
    }
}
