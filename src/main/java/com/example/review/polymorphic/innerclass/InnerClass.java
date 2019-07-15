package com.example.review.polymorphic.innerclass;

import static com.example.util.Utils.log;

/**
 * ClassName: InnerClass1.java
 * Author: chenyiAlone
 * Create Time: 2019/7/14 18:08
 * Description: 测试各种内部类
 * 总结:
 *  1. java 中可以在任何域中创建类
 *  2. {} 就代表着一个域的范围，只有类对应的域的属性才能被另一个类所访问，其余的只能在作用域内进行访问
 *  3. this。只有包含当前内部类的类，才能够使用 ClassName.this 调用当前和外部类对象
 */
public class InnerClass {

    private int value = 0;

    private InnerClass(int value) {
        this.value = value;
    }


    /* 成员内部类 */
    class RememberInnerClass {

        private int value = 2;

        private void innerMethod() {
            log("value: " + value);
            log("this.value: " + this.value);
            log("RememberInnerClass.this.value: " + RememberInnerClass.this.value);
            log("InnerClass1.this.value: " + InnerClass.this.value);
//!            log("InnerClass1.this.value: " + OutClass.this.value);    // 编译器提示 OutClass 不是一个封闭的类
        }

    }

    class RememberInnerClass2 {}

            /* 初始化块中的内部类 */
    {
        class InitializerBlockInnerClass {}
    }

    /* 静态块中的内部类 */
    static {
        class StaticBlockInnerClass {}
    }

    /* 局部内部类 */
    private void method(String str) {

        class MethodInnerClass {}    // 方法内部类

        if (true) {
            class ScopeInnerClass {}    // 作用域内部类
        }
        InnerClass innerClass = new InnerClass(10) {  // 匿名内部类，可以调用对应的有参构造器
            private String value = str;

            private String getValue() {
                return value;
            }

            @Override
            public String toString() {
                return super.toString();
            }
        };
    }

    /*
    测试内部类调用外部类的属性
        1. 使用 ClassName.this 可以调用对应的对象
    */
    private static void innerClassUseOutClassRemember() {
        RememberInnerClass ric = new InnerClass(10).new RememberInnerClass();
        ric.innerMethod();

        /* Output:

            value: 2
            this.value: 2
            RememberInnerClass.this.value: 2
            InnerClass1.this.value: 10
        *///:~
    }

    public static void main(String[] args) {
//        log(new StaticBlockInnerClass().toString());  // 静态代码块域外不能调用其内部的属性
        innerClassUseOutClassRemember();
    }

}
