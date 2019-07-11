package com.example.review._extends;
/**
 * ClassName: _Class.java
 * Author: chenyiAlone
 * Create Time: 2019/7/11 11:00
 * Description: 测试对象的 Class
 */
public class _Class {
    /*
    测试同一个类的不同实例对象得到的 Class 对象实例是否为同一个
        是同一个
     */
    private static void classOfObject() {
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

    public static void main(String[] args) {
        classOfObject();
    }
}
