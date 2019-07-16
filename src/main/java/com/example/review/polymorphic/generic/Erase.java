package com.example.review.polymorphic.generic;
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
    */
    private <T> void test() {
//!       T t = new T();
//!       if (T instanceof Object); // Error
       T t = (T)new Object();   // Uncheck warning
    }

}
