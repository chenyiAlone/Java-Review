package com.example.review.initialization;
/**
 * ClassName: Init.java
 * Author: chenyiAlone
 * Create Time: 2019/7/5 10:44
 * Description: 测试初始化的执行顺序
 *
 */
public class Init {
    private int value;

    private Init() {}
    private void method() {}
    private static void staticMethod() {}

    public static void main(String[] args) {
        Init init = new Init(); // 调用 new Init()    => invokespecial

        init.method();          // 调用非静态方法      => invokespecial

        init.staticMethod();    // 通过对象引用来调用 static 方法 (1)  => invokestatic

        staticMethod();         // 直接调用 static 方法   (2)     => invokestatic
    }

}
