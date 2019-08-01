package com.example.review.polymorphic.generic.democlass;

import java.lang.reflect.InvocationTargetException;

public class Holder<T> {
    T t;

    public Holder(T t) {
        this.t = t;
    }

    public Holder() {
    }

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}

