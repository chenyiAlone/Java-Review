package com.example.review.operator;

/**
 * ClassName: Equals.java
 * Author: chenyiAlone
 * Create Time: 2019/7/3 10:38
 * Description: 用于测试 == 运算符
 */
public class Equals {
    private static class Demo {
        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }
    private static class A {
        private A(int value) {
            this.value = value;
        }
        int value;
        @Override
        public boolean equals(Object obj) {
            if (obj instanceof A) {
                return this.value ==((A) obj).value;
            }
            return false;
        }
    }

    private static void operatorTest() {
        A a1 = new A(12);
        A a2 = new A(12);
        System.out.println(a1);
        System.out.println(a2);
        System.out.println("a1 == a2: " + (a1 == a2));
        System.out.println("a1.equals(a2): " + a1.equals(a2));



        /*///:~

            false
            true
        */
        /*
        java 12 source
            public class Object {
                public boolean equals(Object obj) {
                    return (this == obj);   // Object 中的方法默认比较的引用
                }
            }
        */
    }

    public static void main(String[] args) {
        operatorTest(); // 测试 == 和 equals() 方法的区别
    }
}
