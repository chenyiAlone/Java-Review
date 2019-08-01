package com.example.review.polymorphic.generic;

/**
 * ClassName: GenericBound.java
 * Author: chenyiAlone
 * Create Time: 2019/7/25 13:32
 * Description: 测试泛型参数的边界
 * 总结:
 *      1. 最多有一个类作为边界，接口 需要放在后面
 *      2. & 传入的泛型，必须继承声明的类 和 实现所有的接口
 *
 */
public class GenericBound {

    interface Food {}

    interface Water {
        void drink();
    }

    static class Fruit implements Food {
        void getFruit() {}
    }

    static class Banana {}

    static class Apple extends Fruit {
        void getBanana() {}
    }

    static class Pear extends Fruit implements Water {
        @Override
        public void drink() {

        }
    }


    /** Interface expected here */
//!    private static <T extends Food & Fruit> void method() {}    // Error

    private static <T extends Fruit & Food & Water> void upperBound(T t) {
        t.getFruit();
        t.drink();
    }

//!    private static <T super Apple> void lowerBound() {}  // Error

    private static void boundTest() {
//!        upperBound(new Banana());    // Error
        upperBound(new Pear());
    }

}
