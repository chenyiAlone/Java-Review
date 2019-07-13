package com.example.review.initialization.passivereference;
/**
 * ClassName: Test.java
 * Author: chenyiAlone
 * Create Time: 2019/7/7 21:55
 * Description: 被动引用的测试类
 */
public class Test {
    /*
    调用子类的中继承自父类的静态属性

        只触发父类的类加载，不会触发子类的类加载，只触发拥有该属性的类型的初始化
     */
    private static void subClassUseSuperStaticParam() {
        System.out.println(SubClass.value);

        /*///:~

            super static block
            123
         */
    }
    /*
    测试通过创建指定类型的数组

        不会触发
     */
    private static void array() {
        SubClass[] subClassArray = new SubClass[2];

        /*///:~

         */
    }
    /*
    测试调用类的/类继承的 static final 属性
        1. 不会触发任何类的初始化，static final 在 准备阶段 中就将这个常量进行了赋值并放倒了 类的常量池 中
        2. 通过开关 SubClass.subStaticFinalValue2 这一句的注释进行测试 static final 常量使用 static 方法初始化
            1. 这样的常量不会在准备阶段进行赋值
            2. 只有调用的时候才赋值，并因为调用了 static 方法触发了类加载，对静态成员进行了初始化
     */
    private static void staticFinalParam() {
        System.out.println(SuperClass.supStaticFinalValue);
        System.out.println(SubClass.supStaticFinalValue);
//        System.out.println(SubClass.subStaticFinalValue2);

        /*///:~

        1. 不开启 SubClass.supStaticFinalValue

            200
            200


        2. 开启 SubClass.supStaticFinalValue

            200
            200
            super static block
            init final value2
            subclass static block
            10
         */
    }

    private static void classObject() {
        Class clazz = SubClass.class;
    }

    public static void main(String[] args) {
//        subClassUseSuperStaticParam();  // 1. 调用子类中集成父类的静态属性
//        array();                    // 2. 创建指定类型的数组
        staticFinalParam();     // 3. static final 的属性
//        classObject();      // 4. 调用类的 class 属性
    }
}
