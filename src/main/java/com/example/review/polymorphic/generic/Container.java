package com.example.review.polymorphic.generic;

import com.example.util.democlass.Sub;
import com.example.util.democlass.Super;

import java.util.ArrayList;
import java.util.List;

import static com.example.util.Utils.log;
/**
 * ClassName: Container.java
 * Author: chenyiAlone
 * Create Time: 2019/7/27 10:36
 * Description: 测试两种容器的写法
 *
 *  1. 两种写法的强制类型转化都会出现 uncheck warning
 *  2.
 *
 */
public class Container {
    static class ListTArr<T> {
        private T[] arr;
        private int index;
        private ListTArr() {
            this(10);
        }

        private ListTArr(int len) {
            arr = (T[]) new Object[len];    // Unchecked cast: 'java.lang.Object[]' to 'T[]'
            index = 0;
        }

        private void add(T t) {
            arr[index++] = t;
        }

        private T get(int index) {
            return arr[index];
        }

        private T[] getArr() {
            return arr;
        }


        @Override
        public String toString() {
            return getString(arr, index);
        }
    }

    static class ListObjArr<T> {
        private Object[] arr;
        private int index;
        private ListObjArr() {
            this(10);
        }

        private ListObjArr(int len) {
            arr = new Object[len];
            index = 0;
        }

        private void add(T t) {
            arr[index++] = t;
        }

        private T get(int index) {
            return (T)arr[index];   // Unchecked cast: 'java.lang.Object' to 'T'
        }

        private T[] getArr() {
            return (T[])arr;
        }

        @Override
        public String toString() {
            return getString(arr, index);
        }
    }

    private static void genericContainerUseTArr() {
        ListTArr<Integer> list = new ListTArr<>(10);
        list.add(1);
        list.add(2);
        log(list.toString());
        Integer i = list.get(1);
        log("i: " + i);
        Integer[] arr = list.getArr();
        log(arr.toString());


        /* Output:

            [1, 2]
            i: 2

            Exception in thread "main" java.lang.ClassCastException: class [Ljava.lang.Object; cannot be cast
            to class [Ljava.lang.Integer; ([Ljava.lang.Object; and [Ljava.lang.Integer; are in module
            java.base of loader 'bootstrap')
                at com.example.review.polymorphic.generic.Container.genericContainerUseTArr(Container.java:81)
                at com.example.review.polymorphic.generic.Container.main(Container.java:108)
        *///:~
    }

    private static void genericContainerUseObjArr() {
        ListObjArr<Integer> list = new ListObjArr<>(10);
        list.add(2);
        list.add(4);
        log(list.toString());

        Integer i = list.get(0);
        log("i: " + i);

        Integer[] arr = list.getArr();   // Error
        log(arr.toString());  // Error

        /* Output:

            [2, 4]
            i: 2
            Exception in thread "main" java.lang.ClassCastException: class [Ljava.lang.Object; cannot be cast
            to class [Ljava.lang.Integer; ([Ljava.lang.Object; and [Ljava.lang.Integer; are in module
            java.base of loader 'bootstrap')
                at com.example.review.polymorphic.generic.Container.genericContainerUseObjArr(Container.java:105)
                at com.example.review.polymorphic.generic.Container.main(Container.java:127)
        *///:~
    }

    private static <T> String getString(T[] arr, int index) {
        StringBuilder ret = new StringBuilder("[");
        for (int i = 0; i < index; i++) {
            ret.append(arr[i]).append(", ");
        }
        if (ret.length() > 1) ret.setLength(ret.length() - 2);
        ret.append("]");
        return ret.toString();
    }

    /*
    测试数组的协变
        1. 接收的类型并不会影响数组的实际类型，数组的世界类型在创建的时候就已经确定了
        2. 强制类型转化只能向上转型，或者向其本省的类型进行窄化向下转型，此外的转型都会抛出 ClassCastException 类型转化异常

    */
    private static void arrayTypeCast() {
        Object[] arr = new Integer[3];
        Integer[] arrObj = (Integer[]) arr;
        arr[1] = Integer.valueOf(1);
//!        arr[2] = new Object();   // Error: ArrayStoreException

        arrObj[1] = Integer.valueOf(10);
//!        arrObj[2] = new Object();    // Error

        log("arr instanceof Object[]: " + (arr instanceof Object[]));
        log("arr instanceof Integer[]: " + (arr instanceof Integer[]));

//!        Integer[] castArr = (Integer[])new Object[3];    // Error: ClassCastException

        /* Output:

            arr instanceof Object[]: true
            arr instanceof Integer[]: true
        *///:~
    }


    /*
    测试泛型是否支持协变类型
    */
    private static void listTypeCast() {

        List<Super> list = new ArrayList<>();
//        List<Fruit> list2 = new ArrayList<Apple>();
        list.add(new Sub());

//        GenericBound<Fruit> bound = new GenericBound<Apple>();

    }

    public static void main(String[] args) {
//        genericContainerUseTArr();    // T[] 作为
//        genericContainerUseObjArr();
        arrayTypeCast();
//        listTypeCast();
    }


}
