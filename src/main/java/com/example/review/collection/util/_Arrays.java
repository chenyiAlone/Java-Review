package com.example.review.collection.util;

import java.io.ObjectInputStream;

/**
 * ClassName: _Arrays.java
 * Author: chenyiAlone
 * Create Time: 2019/7/11 21:09
 * Description: 测试数组对象
 */
public class _Arrays {

    private static void arrayIsObject() {
        int[] arr = new int[2];
        System.out.println("arr instanceof Object: " + arr instanceof Object);

        /* Output:

            arr instanceof Object: true
        *///:~
    }

    public static void main(String[] args) {
        arrayIsObject();
    }
}
