package com.example.review.polymorphic.generic;

import com.example.util.democlass.Sub;
import com.example.util.democlass.Super;

/**
 * ClassName: CovariationAndInversion.java
 * Author: chenyiAlone
 * Create Time: 2019/7/27 18:00
 * Description: 测试协变和逆变
 *
 *
 */
public class CovariationAndInversion {

    private static Super parameterCovariant(Super su) { return new Sub(); }

    /*
    测试 协变参数类型
    */
    private static void parameterCovariantTest() {
        parameterCovariant(new Sub());
        parameterCovariant(new Super());
    }

    /*
    测试 协变返回类型
        导出类(子类)重写的父类方法 的 返回类型 可以是父类方法的 导出类型(子类)
    */
    private static void returnParameterCovariant() {
        /* Output:

            Super: Super get()
            Sub extends Super: Sub get()
        *///:~
    }

    /*
    测试 数组 和 泛型 是否支持协变
        1. 数组支持
        2. 泛型不支持
    */
    private static void covariant() {
        Number[] arr = new Integer[10]; // 数组支持协变
        arr[1] = Integer.valueOf(1);

        /** 泛型不支持协变 */
//!        List<Number> list = new ArrayList<Integer>();    // Error
    }

}
