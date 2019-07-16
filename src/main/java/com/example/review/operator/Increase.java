package com.example.review.operator;

public class Increase {
    public static void main(String[] args) {
        int count = 2;
        count = count++;

        System.out.println(count);


        /* Output:

            Compiled from "Increase.java"
            public class com.example.review.operator.Increase {
              public com.example.review.operator.Increase();
                Code:
                   0: aload_0
                   1: invokespecial #1                  // Method java/lang/Object."<init>":()V
                   4: return

              public static void main(java.lang.String[]);
                Code:
                   0: iconst_2
                   1: istore_1
                   2: iload_1
                   3: iinc          1, 1
                   6: istore_1
                   7: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
                  10: iload_1
                  11: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
                  14: return
            }
        *///:~
    }
}
