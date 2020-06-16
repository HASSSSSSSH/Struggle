package test;

import java.lang.ref.WeakReference;

public class WeakReferenceTest {

    public static void main(String args[]) {
        WeakReferenceTest instance = new WeakReferenceTest();

        // 1 - testA
        Object o1 = new Object();
        WeakReference weak1 = instance.testA(o1);
        System.out.println(weak1.get());
        System.gc();
        System.out.println(weak1.get());

        // 2 - testA
        WeakReference<Object> o2 = new WeakReference<>(new Object());
        WeakReference weak2 = instance.testA(o2.get());
        System.out.println(weak2.get());
        System.gc();
        System.out.println(weak2.get());

        // testB
        WeakReference weak3 = instance.testB();
        System.out.println(weak3.get());
        System.gc();
        System.out.println(weak3.get());

        // 3 - testA
        WeakReference weak4 = instance.testA(new Object());
        System.out.println(weak4.get());
        System.gc();
        System.out.println(weak4.get());
    }

    public WeakReference<Object> testA(Object o) {
        return new WeakReference<>(o);
    }

    public WeakReference<Object> testB() {
        Object o = new Object();
        return new WeakReference<>(o);
    }

    public WeakReference<Object> testC() {
        String s = new String("A");
        return new WeakReference<>(s);
    }

    public WeakReference<Object> testD() {
        String s = "A";
        return new WeakReference<>(s);
    }
}
