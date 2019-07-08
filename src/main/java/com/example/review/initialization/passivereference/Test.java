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
        不会触发任何类的初始化，static final 在 准备阶段 中就将这个常量进行了赋值并放倒了 类的常量池 中
     */
    private static void staticFinalParam() {
        System.out.println(SubClass.subStaticFinalValue);
        System.out.println(SubClass.supStaticFinalValue);

        /*///:~

            120
            200
         */
    }

    public static void main(String[] args) {
//        subClassUseSuperStaticParam();  // 1. 调用子类中集成父类的静态属性
//        array();                    // 2. 创建指定类型的数组
        staticFinalParam();     // 3. static final 的属性
    }
}
