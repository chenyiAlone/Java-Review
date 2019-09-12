package com.example.review.array;

import java.util.Random;

import static com.example.util.Utils.log;

/**
 * ClassName: Generic.java
 * Author: chenyiAlone
 * Create Time: 2019/9/12 14:54
 * Description: 测试 java 中的数组和泛型
 *
 */
public class Generic {
    static class Inner<E> {

        private Random random = new Random();

        private E[] es = (E[])new Object[5];
        private Object[] os = new Object[5];

        /*
        测试泛型数组
        */
        private void genericArray() {
            E[] es1 = (E[])new Object[5];
        }

        /*
        E[] 泛型数组直接获取 泛型对象
        */
        private E getE() {
            return es[random.nextInt(es.length)];
        }

        /*
        Object[] obj数组获取数组元素强制转换为 泛型对象
        */
        private E getO() {
            return (E)os[random.nextInt(os.length)];
        }

    }

    /*
    测试创建 泛型类的数组
    */
    public static void main(String[] args) {
        Inner[] ins1 = new Inner[5];
        Inner<Integer>[] ins2 = new Inner[5];
        Inner<Integer>[] ins3 = (Inner<Integer>[])new Inner[5];

        Inner<Integer>[] ins4 = (Inner<Integer>[])ins1;

//!        Inner<Integer>[] ins5 = new Inner<Integer>[5];   //! Error

        log("ins1: " + ins1);
        log("ins2: " + ins2);
        log("ins3: " + ins3);
        log("ins4: " + ins4);


        /* Output:

            ins1: [Lcom.example.review.array.Generic$Inner;@10f87f48
            ins2: [Lcom.example.review.array.Generic$Inner;@2f4d3709
            ins3: [Lcom.example.review.array.Generic$Inner;@4e50df2e
            ins4: [Lcom.example.review.array.Generic$Inner;@10f87f48
        *///:~
    }
}
