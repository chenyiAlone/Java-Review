package com.example.review.keyword.permission.pack2;

import com.example.review.keyword.permission.pack1.Permission;
/**
 * ClassName: OtherPackTest.java
 * Author: chenyiAlone
 * Create Time: 2019/7/3 16:15
 * Description: 不同包的权限测试
 */
public class OtherPackTest {
    private void test(){
        Permission permission = new Permission();
        permission.pubVal = 1;
//!        permission.defVal = 1;   // default cannot be used
//!        permission.proVal = 1;   // protected cannot be used
//!        permission.priVal = 1;   // private cannot be used
    }
}
