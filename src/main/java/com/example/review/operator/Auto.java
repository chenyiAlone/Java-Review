package com.example.review.operator;
/**
 * ClassName: Auto.java
 * Author: chenyiAlone
 * Create Time: 2019/7/2 21:17
 * Description: 测试自加、自减运算符
 * 总结：
 *      int i = 0;
 *      i = i++;
 *      //~ i == 0 : true
 * 1. 后缀自加运算
 *      1. 将原来的值保存到临时变量 temp
 *      2. 将原来的值 i += 1;
 *      3. 返回 temp 的值
 *
 *      }
 *
 *
 */
public class Auto {

    /*
    模拟后置递增操作
        #include <iostream>
        using namespace std;

        int analogPostInc(int &i) {
            int temp = i;   // 1.
            i += 1;
            return temp;
        }

        int main() {
            int i = 0;
            analogPostInc(i);   // 模拟递增
            cout << i << endl;

            i = 0;
            i = analogPostInc(i);   // 模拟 i = i++;
            cout << i << endl;
            return 0;
        }
    */

    private static void testPostInc() {
        int i = 0;
        i = i++;
        System.out.println("i = " + i);

        ///:~ i = 0
    }

    private static void testPostSub() {
        int i = 0;
        i = i--;
        System.out.println("i = " + i);

        ///:~ i = 0
    }

    public static void main(String[] args) {
//        testPostInc(); // 1. 后置自加运算符的性质
        testPostSub();  // 2. 后置自减
    }
}
