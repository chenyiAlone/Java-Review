package com.example.review.polymorphic.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.util.Utils.log;


/**
 * ClassName: Infer.java
 * Author: chenyiAlone
 * Create Time: 2019/7/23 18:16
 * Description: 测试泛型推断
 * 总结:
 *      1. 赋值操作 和 形参的传递 都能通过泛型推断获取到精确的泛型类型
 *      2. 方法的显示泛型说明
 *          1) 静态方法 ClassName.<Type>method()
 *          2) 非静态方法 this.<Type>method()
 *
 *
 */
public class Infer {

    private static <T> List<T> getList() {
        return new ArrayList<T>();
    }

    private <T> List<T> getListNonStat() {
        return new ArrayList<T>();
    }

    private static <K, V> Map<K, V> getMap() {
        return new HashMap<K, V>();
    }


    private static void paramList(List<String> list) {}

    private static <T> Map<T, String> paramMap(Map<T, String> map) {
        return map;
    }

    private void genericInferNon() {
        List<String> list = getListNonStat();
        paramList(this.<String>getListNonStat());
    }


    /*
    测试 java 泛型推断
    */
    private static void genericInfer() {
        List<String> strList = getList();
        List<Integer> intList = getList();

        paramList(getList());
        paramList(Infer.<String>getList());  // 显示类型说明
//        paramList(<String>getList()); // Error

        Map<Integer, String> map = paramMap(getMap());
        map.put(1, "String");
//!        map.put("2", "String");  // Error
        log("map.size(): " + map.size());

        /* Output:

            map.size(): 1
        *///:~
    }

    public static void main(String[] args) {
        genericInfer();
    }

}
