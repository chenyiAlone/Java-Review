package com.example.review.polymorphic.innerclass;

import static com.example.util.Utils.log;
/**
 * ClassName: Anonymous.java
 * Author: chenyiAlone
 * Create Time: 2019/7/15 20:41
 * Description: 测试匿名内部类的属性方法的和其所实现的类或者接口的关系
 */
public class Anonymous {

    static abstract class InnerClass1 {
        int value;
        abstract void method();

    }
    static abstract class InnerClass2 {
        int value;
    }


    /*
    测试在 匿名内部类内部，如何调用新增的成员变量

        1. 相当于实现、继承的作用
        2. 因为内明内部类的没有世界类名，所以 new 创建的这个完成继承/ 实现的匿名内部类，
            就没有起他石实际类型的引用，进而如果使用父类引用来调用扩展的 成员变量 或者 方法 必定错误，
            只有紧跟着 new 创建完成的匿名内部类，直接调用其内部的属性和方法，才是可行的
    */
    private static void superRef() {
        int initVal = 2;
        InnerClass1 innerClass1 = new InnerClass1() {

            int value = initVal;

            @Override
            void method() {
                log("method()", '-', -1);
                log("value: " + value);
                log("this.value: " + this.value);
                log("super.value: " + super.value);
            }

            private void newMethod() {
                log("newMethod()", '-', -1);
                log("value: " + value);
                log("this.value: " + this.value);
                log("super.value: " + super.value);
            }

        };

        log("remember", '-');
        log("innerClass1.value: " + innerClass1.value);
        log("((InnerClass1) innerClass).value: " + ((InnerClass1) innerClass1).value);

        innerClass1.method();
//!        ((InnerClass1) innerClass).newMethod(); // 相当于是父引用不能嗲用子类新增的方法

        /* Output:

            ---------- remember ----------
            innerClass.value: 0
            ((InnerClass1) innerClass).value: 0

            ---------- method() ----------
            value: 2
            this.value: 2
            super.value: 0
        *///:~
    }


    /*
    测试通过 匿名内部类的实例对象 直接访问新增的方法和成员变量
        1. 通过 new 得到的对象的实例，可以直接调用额外增加的属性和方法
        2. 将得到的对象实例再次通过 强制类型转化，转化为其实现的 类或者接口 类型的时候，
            这里的情况跟前面继承的 成员变量 和 方法 的区别是是完全一致的，调用重名的成员变量的，
            会得到被实现的 类 或者 接口 的成员变量
    */
    private static void directRef() {
        int value = new InnerClass2() {
            int value = 2;
        }.value;
        log("remember", '-');
        log("new InnerClass2() {}.value: " + value);
        log("((InnerClass2)instance).value: " + ((InnerClass2)(new InnerClass2() {
                                                                        int value = 2;
                                                                    })).value);

        new InnerClass2() {
            void newMethod() {
                log("newMethod()", '-', -1);
                log("value: " + value);
                log("this.value: " + this.value);
                log("super.value: " + super.value);
            }
        }.newMethod();


        /* Output:

            ---------- remember ----------
            new InnerClass2() {}.value: 2
            ((InnerClass2)instance).value: 0

            ---------- newMethod() ----------
            value: 0
            this.value: 0
            super.value: 0
        *///:~
    }


    public static void main(String[] args) {
//        superRef();     // 父引引用 指向 匿名内部类对象实例
        directRef();    // 匿名内部类的实例直接引用
    }

}
