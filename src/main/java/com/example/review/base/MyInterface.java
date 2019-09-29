package com.example.review.base;

public interface MyInterface {
    boolean isTrue();

    default boolean isTrue(boolean b) {
        return !b;
    }
}
