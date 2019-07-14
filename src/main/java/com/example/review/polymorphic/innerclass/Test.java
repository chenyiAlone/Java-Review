package com.example.review.polymorphic.innerclass;

public class Test {
    public static void main(String[] args) {
        OutClass outClass = new OutClass();
//        OutClass.InnerClass innerClass = outClass.getInnerClass();
        Object innerClass = outClass.getInnerClass();
    }
}
