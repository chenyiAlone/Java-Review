package com.example.review.keyword;
/**
 * ClassName: Final.java
 * Author: chenyiAlone
 * Create Time: 2019/7/3 22:19
 * Description: 测试 final 关键字
 */
public class Final {
    private final int i = 3;
    private final Integer integer = 2;
    private final String str = "";

    private final int initVal;

    private Final() {
//！        initialization();  // 必须直接在构造器中完成初始化
        initVal = 1;
    }
    /*
    在构造器中，调用初 initialization() 始化方法中实现初始化是不可行的！ x
    */
    private final void init() {
//!        this.initVal = 2;
    }
    /*
    测试 final 修饰的数据
        不管是 基本类型 还是 包装类型，使用了 final 关键字修饰以后都不能进行修改操作
    */
    private static void finalData() {
        Final _final = new Final();
//!        _final.integer = 4;
//!        _final.integer += 4;
//!        _final.i = 5;
//!        _final.i += 5;
//!        _final.str = "2";
//!        _final.str += "2";
    }

    public static void main(String[] args) {
        finalData();
    }
}
