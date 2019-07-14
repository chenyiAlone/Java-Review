package com.example.review.polymorphic._extends;
/**
 * ClassName: SuperClass.java
 * Author: chenyiAlone
 * Create Time: 2019/7/11 21:36
 * Description: 继承-覆盖测试类 - 父类
 */
public class SuperClass {

    public int value = 0;

    void printValues() {
        System.out.println("super class printValues:");
        System.out.println("     value: " + value);
        System.out.println("this.value: " + this.value);
    }

    void method() {
        System.out.println("super method()");
    }

    public void perm() {
        System.out.println("super perm()");
    }
}
