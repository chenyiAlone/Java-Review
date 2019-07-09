package com.example.review.initialization.member;
/**
 * ClassName: Varargs.java
 * Author: chenyiAlone
 * Create Time: 2019/7/9 12:35
 * Description: 测试可变参数
 */
public class Varargs {

    private static void cout(Integer ... vars) {
        for (int var : vars)
            System.out.print(var + ", ");
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] vars1 = new Integer[]{1, 2, 3};
        int[] vars2 = {4, 3, 2, 1, };   // 可以以 , 结尾
        cout(vars1);
//!        cout(vars2); // 基本类型的数组不能进行自动装箱和拆箱
        cout(4, 3, 2, 1);
    }

}
