package com.example.review.polymorphic.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: GenericClass.java
 * Author: chenyiAlone
 * Create Time: 2019/7/16 17:36
 * Description: 测试泛型类
 */
public class GenericClass {

    private static <T> List<T> getList() {
        return new ArrayList<T>();
    }
    /*
    测试类型推断
    */
    private static void genericDeduce() {
        List<Integer> list = getList();
        list.add(Integer.valueOf(12));
    }

    public static void main(String[] args) {
        genericDeduce();
    }
}
