package com.example.util.democlass;

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

