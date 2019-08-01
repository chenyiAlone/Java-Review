package com.example.review.polymorphic.generic;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static com.example.util.Utils.log;

/**
 * ClassName: PotentialType.java
 * Author: chenyiAlone
 * Create Time: 2019/7/31 18:44
 * Description: 测试 java 中的潜在类型机制的补偿
 */
public class PotentialType {
    static class Fruit {
        void eat() {
            log("eat Fruit");
        }
    }
    static class Animal {
        void eat() {
            log("eat Animal");
        }
    }
    /*
    测试使用反射来调用不相关的类的同名方法
        1. 使用 Class # getMethod 只能获取到 public 权限的方法
        2. 使用 Class # getDeclaredFields 甚至可以获取到私有权限的属性

    */
    private static void eat(Object obj) {
        Class<?> clazz = obj.getClass();
        try {
            Method method = clazz.getDeclaredMethod("eat");
            method.invoke(obj);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void reflect() {
        eat(new Fruit());
        eat(new Animal());

        /* Output:

            eat Fruit
            eat Animal
        *///:~
    }

    public static void main(String[] args) {
        reflect();
    }

}
