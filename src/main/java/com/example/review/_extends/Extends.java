package com.example.review._extends;
/**
 * ClassName: Extends.java
 * Author: chenyiAlone
 * Create Time: 2019/7/9 21:47
 * Description: 
 */
public class Extends {

    /* 父类引用会默认调用父类的重名属性，向下转型后调用子类的属性 */
    private static void extendsSuperAndSubMember() {
        SuperClass superClass = new SubClass();
        System.out.println("------------ method call remember ------------");
        superClass.printValues();

        System.out.println();
        System.out.println("------------ instance call remember ------------");
        System.out.println("             superClass.value: " + superClass.value);
        System.out.println("((SubClass) superClass).value: " +((SubClass) superClass).value);

        /* Output:

            ------------ method call remember ------------
            sub class printValues:
                  value: 1
             this.value: 1
            super.value: 0

            sub ----------> super printValues:
            super class printValues:
                 value: 0
            this.value: 0

            ------------ instance call remember ------------
                         superClass.value: 0
            ((SubClass) superClass).value: 1
         *///:~
    }


    private static void extendsSuperAndSubMethod() {
        SuperClass superClass = new SubClass();
        System.out.println("------------ superClass.method() ------------");
        superClass.method();
        System.out.println();

        System.out.println("------------ ((SubClass)superClass).method() ------------");
        ((SubClass)superClass).method();


        /* Output:

            ------------ superClass.method() ------------
            sub method()

            sub ----------> super method:
            super method()

            ------------ ((SubClass)superClass).method() ------------
            sub method()

            sub ----------> super method:
            super method()
        *///:~
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    /*
    测试 clone() 方法使用
        1. Object 对象的是 clone() 方法不能直接调用，权限为 protected 继承权限
        2. 子类重写 clone() 方法可以升级这个方法的权限
     */
    public static void testClone() {
        Object obj = new Object();
//        System.out.println(obj.clone() == obj);


    }
    public static void main(String[] args) {
        extendsSuperAndSubMethod();     // 测试方法的覆盖
//        extendsSuperAndSubMember();     // 测试成员变量的覆盖
//        int[] arr = {1, 2, 3};


    }

}
