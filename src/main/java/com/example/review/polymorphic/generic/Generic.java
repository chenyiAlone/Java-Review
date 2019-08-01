package com.example.review.polymorphic.generic;

import java.util.List;
import java.util.Random;

import static com.example.util.Utils.printArr;
/**
 * ClassName: Generic.java
 * Author: chenyiAlone
 * Create Time: 2019/7/27 10:21
 * Description: 测试泛型的使用
 */
public class Generic {

    interface Generate<T> {
        T generate();
    }
    static class IntegerGenerate implements Generate<Integer> {
        private Random random;

        private IntegerGenerate() {
            this.random = new Random();
        }
        @Override
        public Integer generate() {
            return new Random().nextInt(100);
        }
    }

    private static <T> T[] generateArr() {
        return (T[])new Object[10];
    }

    private static <T> T[] array(T[] arr, Generate<T> gen) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = gen.generate();
        }
        return arr;
    }


    private static <T> void method() {
        List<? extends GenericBound> list = null;
//        list.add(new GenericBound());
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[10];
        arr = array(arr, new IntegerGenerate());
        printArr(arr);

        int[] intArr = {1, 2, 3};
//        printArr((Integer[])intArr);

        Integer[] arr1 = Generic.<Integer>generateArr();
        arr1[1] = 2;

    }
}
