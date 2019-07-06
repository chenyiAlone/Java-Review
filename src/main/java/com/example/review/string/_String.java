package com.example.review.string;

/**
 * ClassName: _String.java
 * Author: chenyiAlone
 * Create Time: 2019/7/3 21:04
 * Description: 测试 String
 */
public class _String {


    /*
    测试重载的操作符 + 和 += ,何时转换为 String 类型，以及其中的引用

        表达式会根据操作符的结合律来进行执行，当遇到第一个 String 类型，就将当前的类型直接提升到 String，即当前变为 String 环境
        在 String 环境中的对象引用都会调用被引用对象的 toString() 来得到一个 String 用于拼接字符串、
        在 str += obj + a * b; 中
            1. 先执行 a * b 此时的结果的为 int 类型
            2. 执行 obj + ret，此时 obj 对对象引用而 a * b 的结果为 int，非 String 环境报错

    */
    private static void addOperator() {
        int a = 3, b = 4;
        Object obj = new Object();
        String str = "";
        str += a * b;
        str += obj;
//!        str += obj + a * b;    // 优先级: * > + > +=
        str += a * b + "" + obj;
        System.out.println("str: " + str);
    }

    /*
    测试字符串拼接在 jvm 中的实现，需要注意的是反编译的实现需要放置 main() 方法中才能完全反编译出来
        $javap -c _String

        字节码信息在: _String-Decompile.txt
    总结：
        拼接 "" 的直接字符串 和 String 对象引用 在反编译的结果中，并不是完全相同
            1. 连续的""直接字符串会如同 33 行，将连续的 ""直接字符串使用 ldc 一次性完成加载
            2. 存在 String 对象引用的拼接都会先 new StringBuilder 并完成初始化，使用 StringBuilder.append(String str)
                来拼接单个 String 或者是连续的 ""直接字符串
            3. 每一个拼接串表达式比如 str = "" + "" 或者 str += "" 这种，都会创建一个 StringBuilder 对象来拼接字符串
                代码的证明在 ByteCode1，和 ByteCode1-Decompile.txt 反编译字节码中
    */
    private static void strSplice() {
        String a = "who";
        String b = " are";
        String c = " you?";
        String str1 = a + b + c;
        String str2 = "who" + " are" + " you";
        String str3 = a + " are" + " you";
        String str4 = "who" + b + " you";
        String str5 = "who" + " are" + c;
    }
    /*
    测试 intern() 方法以及 String 常量池的性质 1


    */
    private static void stringPool1() {
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println("s1 == s2: " + (s == s2));

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println("s3 == s4: " + (s3 == s4));
    }
    /*
    测试 intern() 方法以及 String 常量池的性质 2

        1. 单纯的字面拼接和直接使用字面量的性质是一致的
        2. String 对象都可以使用 str.inter() 方法
    */
    private static void stringPool2() {
        String s1 = new String("2") + new String("3");
//        s1.intern();
        String s2 = "23";
        System.out.println("s1 == s2: " + (s1 == s2));

        s1 = "4" + "5";
        s2 = "45";
        System.out.println("s1 == s2: " + (s1 == s2));

        String s3 = new String("1") + new String("1");
        String s4 = "11";
        s3.intern();
        System.out.println("s3 == s4: " + (s3 == s4));
    }

    private static void constPool() {
        String a = "123";
        String b = new String("123");
        System.out.println("a == b: " + (a == b));
        System.out.println("a == b.intern(): " + (a == b.intern()));

        String c = new String("456");
        String d = "456";
        System.out.println("c == d: " + (c == d));
        System.out.println("c.intern() == d: " + (c.intern() == d));

        /*///:~

            a == b: false
            a == b.intern(): true

            c == d: false
            c == d.intern(): true
         */
    }

    public static void main(String[] args) {
//        addOperator();  // 字符创拼接
//        stringPool1();  // String 常量池 1
//        stringPool2();  // String 常量池 2
        constPool();
    }

}
