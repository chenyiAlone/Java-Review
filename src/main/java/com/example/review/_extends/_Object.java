package com.example.review._extends;

import java.lang.ref.WeakReference;

/**
 * ClassName: _Object.java
 * Author: chenyiAlone
 * Create Time: 2019/7/11 11:29
 * Description: 分析 java 的根类 Object
 */
public class _Object {

    /*
     测试同一个类的不同实例对象得到的 Class 对象实例是否为同一个
         同一个类的不同实例对象得到的 Class 对象实例是为同一个 Class 对象实例
    */
    private static void getClassTest() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Class clazz1 = obj1.getClass();
        Class clazz2 = obj2.getClass();

        System.out.println("obj1 == obj2: " + (obj1 == obj2));
        System.out.println("lazz1 == clazz2: " + (clazz1 == clazz2));
        System.out.println("clazz1.equals(clazz2): " + clazz1.equals(clazz2));

        /* Output:

            obj1 == obj2: false
            lazz1 == clazz2: true
            clazz1.equals(clazz2): true
        *///:~
    }

    /*
    测试 finalize() 方法的调用时机
        一个对象要被回收的时候，将会调用他的 finalize() 方法
     */
    private static void finalizeTest() {
        InnerTestClass finalizeTest = new InnerTestClass();
        WeakReference<InnerTestClass> weaks = new WeakReference<>(finalizeTest);
        System.out.println("---------- ref is not null ---------- ");
        System.gc();
        System.out.println("---------- ref is null ---------- ");
        finalizeTest = null;
        System.gc();

        /* Output:

            ---------- ref is not null ----------
            ---------- ref is null ----------
            InnerTestClass, hash = 34801522
         *///:~
    }


    /*
    测试 clone() 方法  (1) 直接调用
     */
    private static void SuperCloneTest() {
        SuperClone obj = new SuperClone();
        try {
            System.out.println(obj == obj.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        /*

            java.lang.CloneNotSupportedException: com.example.review._extends._Object$SuperClone
                at java.base/java.lang.Object.clone(Native Method)
                at com.example.review._extends._Object$SuperClone.clone(_Object.java:93)
                at com.example.review._extends._Object.SuperCloneTest(_Object.java:65)
                at com.example.review._extends._Object.main(_Object.java:87)
         *///:~
    }

    private static void cloneTestImplTest() {

    }

    public static void main(String[] args) {
//        getClassTest();    // Object # getClass
//        finalizeTest();     // Object # finalize
        SuperCloneTest();   // ObjectImpl # super.clone
    }

    static class SuperClone {
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    static class InnerTestClass {

        @Override
        protected void finalize() throws Throwable {
            System.out.println("InnerTestClass, hash = " + hashCode());
        }

    }

}
