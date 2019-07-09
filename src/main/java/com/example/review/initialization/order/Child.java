package com.example.review.initialization.order;
/**
 * ClassName: Child.java
 * Author: chenyiAlone
 * Create Time: 2019/7/5 16:54
 * Description: 测试初始化顺序的测试类 - 子类
 */
public class Child {
    public Child() {
        System.out.println("Child: Constructor");
    }

    static {
        System.out.println("Child: static black");
    }




}
