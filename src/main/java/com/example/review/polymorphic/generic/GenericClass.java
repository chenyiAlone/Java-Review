package com.example.review.polymorphic.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: GenericClass.java
 * Author: chenyiAlone
 * Create Time: 2019/7/16 17:36
 * Description: 测试泛型类的性质
 */
public class GenericClass<T> {

    T value;

    public GenericClass(T t) {
        this.value = t;
    }

    /* com.example.review.polymorphic.generic.GenericClass.this' cannot be referenced from a static context! */
//!    private static void staticMethod(T t) {} // Error

    private List<T> getList() {
        return new ArrayList<T>();
    }


    class TwoTuple<A, B> {}

    class ThreeTuple<D, E, F> extends TwoTuple<D, E> {
        D d;
        E e;
        F f;
    }
    class ThreeTuple2<D, E, F> extends TwoTuple {}

    class FourTuple1<D, F> extends ThreeTuple<Integer, String, String> {}
    class FourTuple2<D> extends ThreeTuple<D, String, String> {}


}
