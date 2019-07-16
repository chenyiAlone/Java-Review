package com.example.review.polymorphic.generic;

import java.lang.reflect.InvocationTargetException;

import static com.example.util.Utils.log;

/**
 * ClassName: GenericMethod.java
 * Author: chenyiAlone
 * Create Time: 2019/7/16 17:54
 * Description: 测试泛型方法
 */
public class GenericMethod {

    private static <T> T method(Class<T> clazz) {
        try {
            return clazz.getConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        int count = 1;
        final int i = count;
        log("i: " + i);
        log("count += count++: " + (count += count++));
    }
}
