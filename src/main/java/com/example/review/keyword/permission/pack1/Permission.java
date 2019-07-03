package com.example.review.keyword.permission.pack1;
/**
 * ClassName: Permission.java
 * Author: chenyiAlone
 * Create Time: 2019/7/3 16:13
 * Description: 权限测试类，拥有四种权限的属性
 */
public class Permission {

    public int pubVal;

    int defVal;

    protected int proVal;

    private int priVal;

    private void test() {
        this.pubVal = 1;
        this.proVal = 1;
        this.defVal = 1;
        this.priVal = 1;

    }

}
