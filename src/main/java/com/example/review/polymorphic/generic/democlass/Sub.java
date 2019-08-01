package com.example.review.polymorphic.generic.democlass;

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
