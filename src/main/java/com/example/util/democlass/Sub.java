package com.example.util.democlass;

public class Sub extends Super {

    @Override
    public Sub get() {
        return this;
    }

    @Override
    public String toString() {
        return "Sub{}";
    }
}
