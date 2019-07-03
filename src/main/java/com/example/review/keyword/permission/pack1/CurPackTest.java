package com.example.review.keyword.permission.pack1;
/**
 * ClassName: CurPackTest.java
 * Author: chenyiAlone
 * Create Time: 2019/7/3 16:13
 * Description: 同包的权限测试
 */
/*
同包下可以通过对象实例，访问拥有包权限以上的属性：
    1. public
    2. protected
    3. default
 */
public class CurPackTest {
    private void test() {
        Permission permission = new Permission();
        permission.pubVal = 1;
        permission.defVal = 1;
        permission.proVal = 1;
//!        permission.priVal = 1;   // private param can be used
    }
}
