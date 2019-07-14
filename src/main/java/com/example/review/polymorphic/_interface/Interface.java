package com.example.review.polymorphic._interface;

import static com.example.util.Utils.log;

/**
 * ClassName: Interface.java
 * Author: chenyiAlone
 * Create Time: 2019/7/12 11:28
 * Description: 测试接口的性质
 */
public class Interface {

    /*static*/ interface InterfaceDecorate {}   // Modifier 'static' is redundant for inner interfaces


    interface Nesting1 {
        interface Nesting2 {
            interface Nesting3 {
                int value = 3;
                // ...
            }
        }
    }

    private interface Inter1 {
        /*public static*/ int i = 1;    // Modifier 'static' is redundant for interface fields
    }

    private interface Inter2 extends Inter1 {}

//!   private interface Inter3 implements Inner1 {}    // 接口不能使用 implements

    private interface Inter4 {
//！        void print();    // default 的方法和抽象方法也不能重复
        default void print() {
            log("default method() ...");
        }
    }

    /*
    测试接口的属性调用
    */
    private static void interfaceMemberTest() {
        log("Inter1.i: " + Inter1.i);

        /* Output:

            Inter1.i: 1
        *///:~
    }

    /*
    测试接口的嵌套
    */
    private static void nestingInterfaceNesting() {
        log("Nesting1.Nesting2.Nesting3.value: " + Nesting1.Nesting2.Nesting3.value);

        /* Output:

            Nesting1.Nesting2.Nesting3.value: 3
        *///:~
    }

    /*
    测试接口中 default 修饰的默认方法
    */
    private static void interfaceDefaultMethodTest() {
        Inter4 inter = new Inter4() {};
        inter.print();

        /* Output:

            default method() ...
        *///:~
    }


    public static void main(String[] args) {
        interfaceMemberTest();      // 访问接口成员变量
//        interfaceDefaultMethodTest();   // 接口的 default 默认方法
//        nestingInterfaceNesting();  // 接口嵌套
    }

}
