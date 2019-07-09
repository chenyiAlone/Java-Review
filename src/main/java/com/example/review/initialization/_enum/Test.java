package com.example.review.initialization._enum;
/**
 * ClassName: Test.java
 * Author: chenyiAlone
 * Create Time: 2019/7/9 17:39
 * Description: 测试枚举类的测试类
 */
public class Test {

    public static void main(String[] args) {
        for (_Enum e : _Enum.values())
            System.out.println("Enum.name: " + e + ", order: " + e.ordinal());
        switch (_Enum.ENUM1) {

        }
    }

}
