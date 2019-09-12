package com.example.review.polymorphic.generic;

import com.example.util.democlass.Sub;
import com.example.util.democlass.Super;

import static com.example.util.Utils.log;

/**
 * ClassName: SelfBound.java
 * Author: chenyiAlone
 * Create Time: 2019/8/1 22:28
 * Description: 测试自限定类型
 * 总结:
 *      1. 自限定泛型可以将泛型指定一为 class A extends Bound<A>，只有类 A 满足了这种声明方式，
 *          才能作为该类的泛型参数
 *
 *      2. 自限定的作用就是使基类中的类型，随着子类的指定而发生变化，将父类的方茴类型指定为了 Derived 这个导出类型
 *          1. 基类为一个简单的泛型类
 *              class Basic<E>
 *          2. 子类实现自限定
 *              class Derived extends Basic<Derived> {}
 *
 *
 */
public class SelfBound {
    static class Bound<E extends Bound<E>> {}

    static class A extends Bound<A> {}
    static class B extends Bound<B> {}

    static class C extends Bound<A> {}

    static class D {}

//!    static class E extends SelfBound<D> {}   // Error


    static class OrdinarySetter {
        void set(Super su) {
            log("OrdinarySetter # set");
        }
    }

    static class DerivedSetter extends OrdinarySetter {
        void set(Sub su) {  // 这里并不是 Override，方法的参数不同为不同的方法
            log("DerivedSetter # set");
        }
    }


    /*
    测试直接继承
        测试子类的方法的 参数类型 和 父类不一致，为两个不同的方法，方法重载

    */
    private static void ordinaryArgument() {
        Super su = new Super();
        Sub sub = new Sub();

        DerivedSetter derivedSetter = new DerivedSetter();
        derivedSetter.set(su);
        derivedSetter.set(sub);

        /* Output:

            OrdinarySetter # set
            DerivedSetter # set
        *///:~
    }


    static class GenericSetter<T> {
        void set(T t) {
            log("GenericSetter # set");
        }
    }

    static class DerivedGS extends GenericSetter<Sub> {
        @Override
        void set(Sub sub) {
            super.set(sub);
            log("DerivedGS # set");
        }
    }


    /*
    测试自限定继承
        DerivedGS 中调用 super.set(sub) 方法成功，说明这个方法为紫了重写父类方法，
        可以看出 DerivedGS # set 覆盖了父类的方法，属于方法重写
    */
    private static void genericInheritance() {
        Super su = new Super();
        Sub sub = new Sub();

        DerivedGS derivedGS = new DerivedGS();
//!        derivedSetter.set(su);   // Error
        derivedGS.set(sub);

        /* Output:

            DerivedGS # set
        *///:~
    }

    public static void main(String[] args) {
//        ordinaryArgument();     // 直接继承
        genericInheritance();   // 自限定泛型继承
    }

}
