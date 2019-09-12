package com.example.review.polymorphic.generic;

import com.example.util.democlass.Holder;
import com.example.util.democlass.Sub;
import com.example.util.democlass.Super;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.util.Utils.log;

/**
 * ClassName: Wildcard.java
 * Author: chenyiAlone
 * Create Time: 2019/7/27 16:24
 * Description: 测试通配符
 */
public class Wildcard {

    private static List list1;
    private static List<?> list2;
    private static List<? extends Object> list3;

    private static void g1(List list) {
        list1 = list;
        list2 = list;
//!        list3 = list;    // Warning
    }

    private static void g2(List<?> list) {
        list1 = list;
        list2 = list;
        list3 = list;
    }

    private static void g3(List<? extends Object> list) {
        list1 = list;
        list2 = list;
        list3 = list;

    }

    private static void genericCatch() {
        Holder h1 = new Holder();
        Holder<?> h2 = new Holder();
//!        Holder<? extends Object> h3 = new Holder();  // Warning


    }


    /** 注意这是边界，不是通配符！类比边界不能写成 T super MyClass */
//!    private static <T super Sub> void superBond() {} // Error!

    private static <T extends Sub> void extendsBound() {}


    /*
    测试通配符
        1. ? extends Type 作为泛型类型的时候，插入操作都会失效，获取操作正常 接收类型为 UpperBound
                插入: 对于 ? extends Type 这一个通配符而言而言，并不能知道确切类型，所以所有关于泛型的插入一刀切
                获取: 能够统配的类型肯定为 Type 的导出类型(子类型)
                    UpperBound u = list.get(index);

        2. ? super Type 作为泛型类型的时候，插入 extends LowerBound 的对象正常，获取的接收类型为实际类型
                插入: 编译器可以知道统配的类型是 LowerBound 的基类型(父类型)，所以 LowerBound 以及他的导出类型(子类型)肯定可以插入
                获取: 对于 ? super LowerBound 只知道为 LowerBound 的一个基类型，对于 ? super LowerBound 的接受类型就为 Object (根类型)

                    list = new ArrayList<Type>();
                    Type t = list.get(index);

    */
    private static void wildcard(List<? extends Super> paramList) {
        List<? extends Super> upperList = new ArrayList<Sub>(Arrays.asList(new Sub[]{new Sub()}));
//!        upperList.add(new Super());  // Error
//!        upperList.add(new Sub());    // Error

//!        Sub us = upperList.get(0);   // Error
        Super us = upperList.get(0);
        log("us: " + us);


        List<? super Sub> lowerList = new ArrayList<Super>();
//!        lowerList.add(new Super());  // Error
        lowerList.add(new Sub());

        Object ls = lowerList.get(0);

        log("ls: " + ls);

        /* Output:

            us: com.example.util.democlass.Sub@2f4d3709
            ls: com.example.util.democlass.Sub@2f4d3709
        *///:~

    }

    /*
    测试通配符的含义
        1. 通配符是一种准确泛型的占位符，自定该处的泛型的边界
        2. ? super Sub 的含义是 List 的泛型是 Sub 的父类，所以可以插入指定边界类型以及他的导出类型
        3. 使用 ?
    */
    private static void f1(List<? super Sub> list) {
//!        list.add(new Super());   // 通配符的含义是一个替代符号
        list.add(new Sub());

//!        Sub sub = list.get(1);   // Error
        Object sub = list.get(1);

    }

    private static void f2(List<?> list) {
//!        list.add(new Super());   // 通配符的含义是一个替代符号
//        list.add(new Sub());

//!        Sub sub = list.get(1);   // Error
        Object sub = list.get(1);

    }

    public static void main(String[] args) {
        wildcard(null);
    }

}
