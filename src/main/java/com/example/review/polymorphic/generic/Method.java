package com.example.review.polymorphic.generic;

import java.lang.reflect.InvocationTargetException;

import static com.example.util.Utils.log;

/**
 * ClassName: Method.java
 * Author: chenyiAlone
 * Create Time: 2019/7/16 17:54
 * Description: 测试泛型方法
 */
public class Method<E> {

    /** 'com.example.review.polymorphic.generic.Method.this' cannot be referenced from a static context */
//!    private static void useClassParam(E e) {}    // Error

    private static <T> T method(Class<T> clazz) {
        T ret = null;
        try {
            ret = clazz.getConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return ret;
    }

    private static <T> void genericMethod(T t) {}

    private <T> T getT(T t) {
        return t;
    }

    public static void main(String[] args) {
        int count = 1;
        final int i = count;
        log("i: " + i);
        log("count += count++: " + (count += count++));
    }
}
