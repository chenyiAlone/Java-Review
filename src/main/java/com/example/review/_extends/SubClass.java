package com.example.review._extends;
/**
 * ClassName: SubClass.java
 * Author: chenyiAlone
 * Create Time: 2019/7/11 21:37
 * Description: 继承-覆盖测试类 - 子类
 */
public class SubClass extends SuperClass {

    int value = 1;

    void printValues() {
        System.out.println("sub class printValues:");
        System.out.println("      value: " + value);
        System.out.println(" this.value: " + this.value);
        System.out.println("super.value: " + super.value);
        System.out.println();

        System.out.println("sub ----------> super printValues:");
        super.printValues();
    }

    void method() {
        System.out.println("sub method()");
        System.out.println();

        System.out.println("sub ----------> super method:");
        super.method();
    }

}
