package com.example.review.initialization.order;
/**
 * ClassName: InitOrder.java
 * Author: chenyiAlone
 * Create Time: 2019/7/5 16:50
 * Description: 测试对象的初始化顺序
 */

/*
总结:

类的初始化由构造器来进行，但是是由 new 关键字触发的

在 static属性调用内部调用了 new InitOrder() 的时候会直接执行 构造器 方法，这时候还未完成对静态属性的初始化

第一次调用这个类，调用 静态属性 或者 构造器，触发类加载，完成对 static 变量的初始化，这个过程进行且仅进行一次
1. InitOrder 拥有 main 方法，触发了类加载器
2. 初始化了 t 的静态成员变量 k
3. 调用了 t1= new InitOrder("obj 1-> constructor"); ，初始化 t1 静态成员变量
    1. 初始化 t1 的 非静态成员变量/域
    2. 调用构造器，完成了 t1 的初始化

4.调用  t2 = new InitOrder("obj 2-> constructor");，初始化 t2 静态成员变量
    1. 初始化了 t2 的非静态成员变量
    2. 调用构造器，完成了 t2 的初始化

    (这两种调用都忽略了静态属性直接初始化非静态成员变量)
5. 初始化 t 的静态块
6. 初始化 t 的非静态成员变量/块
7. 调用 t 的构造器，完成初始化
*/
public class InitOrder {

    private static int k = 0;
    private static InitOrder t1 = new InitOrder("obj 1-> constructor");
    private static InitOrder t2 = new InitOrder("obj 2-> constructor");
    private static int i = print("static-param");
    private static int n = 99;
    private int a = 0;
    public int nonStatic = print("non-static param");

    {
        print("non-static block");
    }

    static {
        print("static block");
    }

    private InitOrder(String str) {
        System.out.format("%2d: i=%-2d, n=%-3d, %s\n", (++k), i, n, str);
        ++i;    ++n;
    }

    private static int print(String str) {
        System.out.format("%2d: i=%-2d, n=%-3d, %s\n", (++k), i, n, str);
        ++n;
        return ++i;
    }

    public static void main(String args[]) {
        InitOrder t = new InitOrder("initOrder-> constructor");


        /*///:~

             1: i=0 , n=0  , non-static param
             2: i=1 , n=1  , non-static block
             3: i=2 , n=2  , obj 1-> constructor

             4: i=3 , n=3  , non-static param
             5: i=4 , n=4  , non-static block
             6: i=5 , n=5  , obj 2-> constructor

             7: i=6 , n=6  , static-param
             8: i=7 , n=99 , static block
             9: i=8 , n=100, non-static param
            10: i=9 , n=101, non-static block
            11: i=10, n=102, initOrder-> constructor
         */
    }


}
