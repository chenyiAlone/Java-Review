package com.example.review.polymorphic;
/**
 * ClassName: Domain.java
 * Author: chenyiAlone
 * Create Time: 2019/7/14 22:43
 * Description: 展示 java 中的作用域
 */
public class Domain {

    private static int classParam = 1;  // 1. 类级 作用域

    private int instance = 2;   // 2. 对象实例级 作用域


    { /* 3. 块级 的作用域，初始化块和静态块都属于这个级别，
            以及常见的 if for 等块状结构 */

    }

    private void test() {   // 方法级的作用域
        int i = 3;
    }

}
