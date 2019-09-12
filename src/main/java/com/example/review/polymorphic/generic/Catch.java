package com.example.review.polymorphic.generic;

import com.example.util.democlass.Holder;
import com.example.util.democlass.Sub;

import static com.example.util.Utils.log;

/**
 * ClassName: Catch.java
 * Author: chenyiAlone
 * Create Time: 2019/7/27 22:39
 * Description: 测试泛型捕获
 */
public class Catch {


    private static <T> void f1(Holder<T> holder) {
        T t = holder.get();
        log("T: " + t);
    }

    private static void f2(Holder<?> holder) {
        f1(holder);
    }


    private static void genericCatch() {
        Holder holder = new Holder<Sub>(new Sub());
        f2(holder);
        f1(holder);  // Warning

        /* Output:

            T: Sub{}
        *///:~
    }


    public static void main(String[] args) {
        genericCatch();
    }

}
