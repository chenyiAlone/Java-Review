package com.example.review.polymorphic._extends;

import java.lang.ref.WeakReference;
import static com.example.util.Utils.*;
/**
 * ClassName: _Object.java
 * Author: chenyiAlone
 * Create Time: 2019/7/11 11:29
 * Description: 分析 java 的根类 Object
 */
public class _Object {

    /*
     测试同一个类的不同实例对象得到的 Class 对象实例是否为同一个
         同一个类的不同实例对象得到的 Class 对象实例是为同一个 Class 对象实例
    */
    private static void getClassTest() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Class clazz1 = obj1.getClass();
        Class clazz2 = obj2.getClass();

        System.out.println("obj1 == obj2: " + (obj1 == obj2));
        System.out.println("lazz1 == clazz2: " + (clazz1 == clazz2));
        System.out.println("clazz1.equals(clazz2): " + clazz1.equals(clazz2));

        /* Output:

            obj1 == obj2: false
            lazz1 == clazz2: true
            clazz1.equals(clazz2): true
        *///:~
    }

    /*
    测试 finalize() 方法的调用时机
        一个对象要被回收的时候，将会调用他的 finalize() 方法
     */
    private static void finalizeTest() {
        InnerTestClass finalizeTest = new InnerTestClass();
        WeakReference<InnerTestClass> weaks = new WeakReference<>(finalizeTest);
        System.out.println("---------- ref is not null ---------- ");
        System.gc();
        System.out.println("---------- ref is null ---------- ");
        finalizeTest = null;
        System.gc();

        /* Output:

            ---------- ref is not null ----------
            ---------- ref is null ----------
            InnerTestClass, hash = 34801522
         *///:~
    }


    /*
    测试 clone() 方法  (1) 直接调用
     */
    private static void SuperCloneTest() {
        SuperClone obj = new SuperClone();
        try {
            System.out.println(obj == obj.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        /*

            java.lang.CloneNotSupportedException: _Object$SuperClone
                at java.base/java.lang.Object.clone(Native Method)
                at _Object$SuperClone.clone(_Object.java:93)
                at _Object.SuperCloneTest(_Object.java:65)
                at _Object.main(_Object.java:87)
         *///:~
    }


    /*
   测试 Object # notify 方法不使用同步
    */
    private static void notifyTest() {
        _Object obj = new _Object();
        log("notify test", '-');
        obj.notify();
    }

    /*
    测试 wait() 方法不在同步中使用
        wait() 方法必须在 synchronized 环境中使用，synchronized 关键字 或者 synchronized(obj) 同步块

     */
    private static void waitTest() {
        _Object obj = new _Object();
        log("wait test", '-');
        try {
            obj.wait(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log("wait() end...");

        /*

            ---------- wait test ----------
            Exception in thread "main" java.lang.IllegalMonitorStateException
                at java.base/java.lang.Object.wait(Native Method)
                at _Object.waitTest(_Object.java:87)
                at _Object.waitAndNotifyTest(_Object.java:148)
                at _Object.main(_Object.java:159)
         *///:~
    }


    /*
    测试 Object # wait 的正确使用方法
     */
    private static void waitSyncTest() {
        _Object obj = new _Object();
        log("wait Sync test", '>', 1);
        new Thread() {
            @Override
            public void run() {
                try {
                    for (int i = 1; i <= 5; i++) {
                        sleep(1000);
                        log("sleep " + i + " s");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log("another thread -----> notify obj thread", -1);
                synchronized (obj) {
                    obj.notify();
                }
            }
        }.start();

        synchronized (obj) {
            try {
                obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log("quit wait status", '<', -1);

        /*

            >>>>>>>>>> wait Sync test >>>>>>>>>>

            sleep 1 s
            sleep 2 s
            sleep 3 s
            sleep 4 s
            sleep 5 s

            another thread -----> notify obj thread

            <<<<<<<<<< quit wait status <<<<<<<<<<
         *///:~
    }

    private static void waitAndNotifyTest() {
//        waitTest();   // wait() 测试
//        notifyTest();
        waitSyncTest();
    }

    private static void cloneTestImplTest() {}

    public static void main(String[] args) {
//        getClassTest();    // Object # getClass
//        finalizeTest();     // Object # finalize
//        SuperCloneTest();   // ObjectImpl # super.clone
        waitAndNotifyTest();    // Object # wait + Object # notify
    }

    static class SuperClone {
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    static class InnerTestClass {

        @Override
        protected void finalize() throws Throwable {
            log("InnerTestClass, hash = " + hashCode());
        }

    }

}
