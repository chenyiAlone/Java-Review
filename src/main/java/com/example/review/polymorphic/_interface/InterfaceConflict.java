package com.example.review.polymorphic._interface;
/**
 * ClassName: InterfaceConflict.java
 * Author: chenyiAlone
 * Create Time: 2019/7/14 15:20
 * Description: 测试接口组合的冲突
 *
 * 1. 接口可以继承两个拥有相同非 default 默认方法的接口
 * 2. 接口继承两个拥有相同方法的
 *
 */
public class InterfaceConflict {
    interface Inter1 { void f(); }
    interface Inter2 { void f(); }
    interface Inter3 extends Inter1 { void f(); }
    interface Inter4 extends Inter1, Inter2 {}
    interface Inter5 extends Inter1, Inter2 { void f(); }


    interface Inter6 { default void f() {} }
    interface Inter7 { default void f() {} }
    interface Inter8 extends Inter6 { void f(); }
//!    interface Inter9 extends Inter6, Inter7 {}
    interface Inter10 extends Inter6, Inter7 { void f(); }
    interface Inter11 extends Inter6, Inter7 { default void f() {} }

}
