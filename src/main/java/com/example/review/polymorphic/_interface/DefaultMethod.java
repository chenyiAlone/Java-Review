package com.example.review.polymorphic._interface;

import static com.example.util.Utils.log;
/**
 * ClassName: DefaultMethod.java
 * Author: chenyiAlone
 * Create Time: 2019/7/14 15:46
 * Description: 测试 default 方法和接口抽象方法直接的关系
 *
 * 总结：
 *  1. default 和普通类中的非静态方法基本一致
 *  2. default 方法可以被接口的抽象方法所覆盖
 *
 */
public class DefaultMethod {
    /* Inter # f */
    interface Inter1 {

        default void f() {
            log("Inter1 # f");
        }

    }

    /* only extends Inter1 */
    interface Inter2 extends Inter1 {}

    /* extends Inter1, and override Inter1 # f */
    interface Inter3 extends Inter1 {
        @Override
        default void f() {
            log("Inter3 # f");
        }
    }

    /* extends Inter1, and add abstract method Inter4 # f */
    interface Inter4 extends Inter1 {
        void f();
    }
    /*
    测试接口中的 default 方法
    */
    private static void defaultMethodTest() {
        log("new Inter1() {}.f(): ", false);
        new Inter1() {}.f();

        log("new Inter2() {}.f(): ", false, -1);
        new Inter2() {}.f();

        log("new Inter3() {}.f(): ", false, -1);
        new Inter3() {}.f();

//!        new Inter4() {}.f();

        /* Output:

            new Inter1() {}.f(): Inter1 # f

            new Inter2() {}.f(): Inter1 # f

            new Inter3() {}.f(): Inter3 # f
        *///:~

    }

    public static void main(String[] args) {
        defaultMethodTest();
    }

}
