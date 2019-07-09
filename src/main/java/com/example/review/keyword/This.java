package com.example.review.keyword;
/**
 * ClassName: This.java
 * Author: chenyiAlone
 * Create Time: 2019/7/3 21:21
 * Description: 测试 this 关键字
 */
public class This {
    private int value;

    private This() { }

    /*
    this 在构造器中调用构造器
        1. 必须在第一句
        2. 能且只能调用一次
    */
    private This(int value) {
        this();
        this.value = value;
    }

    @Override
    public String toString() {
        return "This{" +
                "value=" + value +
                '}';
    }

    private This bindValue(int value) {
        this.value = value;
        return this;
    }

    private void paramWithoutThis(int value) {
        System.out.println("without: " + value);
    }

    private void paramUseThis(int value) {
        System.out.println("useThis: " + this.value);
    }

    /*
    测试 形参 和 成员变量 相同的时候，加与不加 this 关键字分别调用的是谁
        1. 加    成员变量
        2. 不加  形参
    */
    private static void thisObjRef() {
        This _this = new This(1);
        System.out.println("_this.value: " + _this.value);

        _this.paramUseThis(2);
        _this.paramWithoutThis(2);
        /*///:~

            _this.value: 1
            useThis: 1
            without: 2
        */

    }


    /*
    测试 this 关键字作为返回值
        可以形成串行调用
    */
    private static void asReturnVal() {
        This _this = new This(1);
        _this.bindValue(2).bindValue(3).bindValue(4);
        System.out.println(_this);
    }


    class Inner {
        private void innerTest() {
            this.test();
            test();
            This.this.test();
            int i = 1;
        }
        private void test() {
            System.out.println("inner class test");
        }
    }
    private void test() {
        System.out.println("out class test");
    }

    /*
    测试 ClassName.this 的作用
        当外部类的方法和内部类的方法的重名的时候，ClassName.this 用于锁定外部类对象，进而可以调用外部类的成员变量和方法
        test() 和 this.test() 都会调用当前对象的方法，即内部类对象，所以都是调用了内部类的成员变量和方法
     */
    private static void classNameThis() {
        Inner inner = new This().new Inner();
        inner.innerTest();
        /*///:~

            inner class test
            inner class test
            out class test
         */
    }


    public static void main(String[] args) {
//        asReturnVal();
//        thisObjRef();
        classNameThis();
    }

}
