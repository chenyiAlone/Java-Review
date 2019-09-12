package com.example.review.polymorphic.generic;

import java.util.ArrayList;

import static com.example.util.Utils.log;

/**
 * ClassName: Erase.java
 * Author: chenyiAlone
 * Create Time: 2019/7/16 19:15
 * Description: 测试泛型擦除的属性
 *
 */
public class Erase {
    /*
    测试泛型擦除的影响
        1. 不能直接使用泛型参数的类型信息，在编译期泛型会被擦除
        2. 由于泛型擦除，运行中的 ArrayList<String> 和 ArrayInteger<Integer> 其实是一样的，
           擦除道一个边界，都是 ArrayList<Object>


    */
    private static <T> void testGenericErase() {
//!       if (T instanceof Object); // Error
//!       T t = new T();    // Error
//!       T[] ts = new T[10];  // Error
        T t = (T)new Object();   // Uncheck warning
        T[] ts = (T[])new Object(); // Uncheck warning


        Class clazz1 = new ArrayList<Integer>().getClass();
        Class clazz2 = new ArrayList<String>().getClass();
        log("clazz1 == clazz2: " + (clazz1 == clazz2));

        /* Output:

            clazz1 == clazz2: true
        *///:~
    }

    public static void main(String[] args) {
        testGenericErase();
    }

}
