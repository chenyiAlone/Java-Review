package com.example.review.array;

import com.example.util.democlass.*;

import java.util.Arrays;
import java.util.List;

import static com.example.util.Utils.log;
import static com.example.util.Utils.printArr;

/**
 * ClassName: Array.java
 * Author: chenyiAlone
 * Create Time: 2019/8/2 14:53
 * Description: 测试数组
 */
public class Array {

    /*
    测试数组是否支持协变
        1. 数组支持协变
        2. 接口抽象类都可以创建数组对象
    */
    private static void arrayCovariant() {
        SuperInterface[] sis = new SuperInterface[10];  // interface array
        sis[1] = new SubInterface() {}; // array support covariant
    }


    /*
    测试 Arrays # asList 方法
    */
    private static void asList() {
        int[] arr = {1, 2, 3};
//!        List<Integer> list1 = Arrays.asList(arr);     // Error
        List<Integer> list2 = Arrays.asList(1, 2, 3);
        List<Integer> list3 = Arrays.<Integer>asList(3, 4);
//!        list2.remove(1);     // Error
//!        list2.add(4);        // Error

        log(Arrays.toString(arr));

        /* Output:

            [1, 2, 3]
        *///:~
    }


    /*
    测试数组为一维对象
    */
    private static void arrayCreate() {
        int[] arr;  // 声明数组引用
        arr = new int[5];


        int[][] arr2D = new int[2][];
        arr2D[0] = new int[4];
        arr2D[1] = new int[2];
        for (int i = 0; i < arr2D.length; i++) {
            log("arr2D[" + i + "].length: " + arr2D[i].length);
        }
        arr2D[4] = null;

        /* Output:

            arr2D[0].length: 4
            arr2D[1].length: 2
        *///:~
    }


    /*
    测试数组元素的初始化
        1. 数组元素都会被初始化为默认的 零值，引用类型 包括 包装类型 都会被初始化为 null
        2. interface 以及 abstract class 都可直接创建数组，数组支持协变，每个元素需要进行初始化

    */
    private static void arrayInit() {
        List<Integer>[] ls = new List[4];
        log("ls: " + Arrays.toString(ls));
        Integer[] arr = new Integer[2];
        log("arr: " + Arrays.toString(arr));

        /* Output:

            ls: [null, null, null, null]
            arr: [null, null]
        *///:~
    }

    /*
    测试 Arrays # deepToString
    */
    private static void arrayToString() {
        int[][][] arr = {
                            {
                                {1, 2, 3},
                                {4, 5, 6}
                            },
                            {
                                {7, 8, 9}
                            }
                        };

        log(Arrays.deepToString(arr));

        int[][] arrNesting = null;
//        arrNesting[0] = arrNesting;
        log(Arrays.deepToString(arrNesting));
    }

    public static void main(String[] args) {
//        asList();
//        arrayCreate();
        arrayInit();
//        arrayToString();
    }

}
