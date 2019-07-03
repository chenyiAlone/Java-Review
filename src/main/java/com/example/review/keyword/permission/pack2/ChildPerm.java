package com.example.review.keyword.permission.pack2;

import com.example.review.keyword.permission.pack1.Permission;
/**
 * ClassName: ChildPerm.java
 * Author: chenyiAlone
 * Create Time: 2019/7/3 16:12
 * Description: 子类的权限测试
 */
public class ChildPerm extends Permission {

    private void setParentParam(int i) {
        super.pubVal = i;
//!        super.defVal = i;    // child class cannot use default param
//!        super.priVal = i;    // child class cannot use private param
        super.proVal = i;
    }

    // static 静态方法(例如 main) 只能通过对象实例的引用来访问
    public static void staticMethodTest() {
        Permission permission = new ChildPerm();
        permission.pubVal = 1;
//!        permission.proVal = 1;  // protected cannot be used
//!        permission.defVal = 1;  // default cannot be used
//!        permission.priVal = 1;  // private cannot be used
    }
}
