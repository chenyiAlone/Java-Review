package com.example.review.map;

import java.util.HashMap;

import static com.example.util.Utils.log;
/**
 * ClassName: _HashMap.java
 * Author: chenyiAlone
 * Create Time: 2019/7/17 15:24
 * Description: 测试 HashMap 保存对象的特点
 */
public class _HashMap {

    static class MyString {
        final String str;
        private MyString(String str) {
            this.str = str;
        }
        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public boolean equals(Object obj) {
            return str.equals(obj);
        }
    }
    public static void main(String[] args) {
        HashMap<MyString, Integer> map = new HashMap<>();
        map.put(new MyString("aa"), 0);
        map.put(new MyString("bb"), 1);
        log("map.size(): " + map.size());
    }
}
