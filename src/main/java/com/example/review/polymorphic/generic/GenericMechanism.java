package com.example.review.polymorphic.generic;

import com.example.review.polymorphic.generic.democlass.Holder;
/**
 * ClassName: GenericMechanism.java
 * Author: chenyiAlone
 * Create Time: 2019/7/27 23:09
 * Description: 测试泛型的原理
 * 总结:
 *      1. 泛型动作都发生在边界
 *          void set(T t)，传入的方法在静态类型检查，确保类型无误
 *          T get()，插入对传递出去的值的转型
 *
 *
 */
public class GenericMechanism {


    public static void main(String[] args) {
        Holder<Integer> h = new Holder<Integer>();
        h.set(Integer.valueOf(10));
        Integer i = h.get();

        /* Decompile:

          public static void main(java.lang.String[]);
            Code:
               0: new           #2                  // class com/example/review/polymorphic/generic/GenericMechanism$Holder
               3: dup
               4: aconst_null
               5: invokespecial #3                  // Method com/example/review/polymorphic/generic/GenericMechanism$Holder."<init>":(Lcom/example/review/polymorphic/generic/GenericMechanism$1;)V
               8: astore_1
               9: aload_1
              10: bipush        10
              12: invokestatic  #4                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
              15: invokevirtual #5                  // Method com/example/review/polymorphic/generic/GenericMechanism$Holder.set:(Ljava/lang/Object;)V
              18: aload_1
              19: invokevirtual #6                  // Method com/example/review/polymorphic/generic/GenericMechanism$Holder.get:()Ljava/lang/Object;

              22: checkcast     #7                  // class java/lang/Integer

              25: astore_2
              26: return
        *///:~
    }

}
