package com.example.review.keyword;
/**
 * ClassName: Static.java
 * Author: chenyiAlone
 * Create Time: 2019/7/4 20:11
 * Description: 测试 static 关键字
 */
public class Static {
    private static int value = 0;
    private Static() {}

    private Static(int value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return ".value: " + Static.value;
    }
    /*
    使用了 static 修饰的变量会独立出来，不会与包含它的类的任何实例对象关联再一起
    */
    private static void staticParam() {
        Static s1 = new Static();
        Static s2 = new Static();
        s1.value++;

        System.out.println("s1" + s1);
        System.out.println("s2" + s2);

        /*///:~

            s1.value: 1
            s2.value: 1
        */
    }

    public static void main(String[] args) {
        staticParam();
    }
}
