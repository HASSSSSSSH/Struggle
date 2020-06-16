package test;

import java.util.WeakHashMap;

public class WeakHashMapTest {

    private Object o1 = new Object();

    public static void main(String args[]) {
        WeakHashMapTest instance = new WeakHashMapTest();


        // testE
//        WeakHashMap e = instance.testE();
//        System.out.println(e);
//        System.gc();
//        System.out.println(e);

        // testF
        WeakHashMap map = instance.testL();
        System.out.println(map);
        System.gc();
        System.out.println(map);

//        instance.testD();
//        instance.testC();
//        instance.testA();
//        instance.testB();
    }

    public WeakHashMap testA() {
        WeakHashMap<String, String> weakHashMap = new WeakHashMap<>();
        String s = new String("sss");
        weakHashMap.put(s, "7777777");
        System.out.println(weakHashMap);
        System.gc();
        System.out.println(weakHashMap);
        return weakHashMap;
    }

    public WeakHashMap testB() {
        WeakHashMap<String, String> weakHashMap = new WeakHashMap<>();
        String s = "sss";
        weakHashMap.put(s, "7777777");

        System.gc();

        System.out.println(weakHashMap);
        return weakHashMap;
    }

    public WeakHashMap testC() {
        WeakHashMap<String, String> weakHashMap = new WeakHashMap<>();
        weakHashMap.put(new String("sss"), "7777777");

        System.gc();

        System.out.println(weakHashMap);
        return weakHashMap;
    }

    public WeakHashMap testD() {
        WeakHashMap<Object, String> weakHashMap = new WeakHashMap<>();
        Object o = new Object();
        weakHashMap.put(o, "7777777");

        System.gc();

        System.out.println(weakHashMap);
        return weakHashMap;
    }

    public WeakHashMap testE() {
        WeakHashMap<Object, String> weakHashMap = new WeakHashMap<>();
        weakHashMap.put(new Object(), "value");
        System.out.println(weakHashMap);
        System.gc();
        System.out.println(weakHashMap);
        return weakHashMap;
    }

    public WeakHashMap testF() {
        WeakHashMap<Object, String> weakHashMap = new WeakHashMap<>();
        Object o = new Object();
        weakHashMap.put(o, "value");
        System.out.println(weakHashMap);
        System.gc();
        System.out.println(weakHashMap);
        return weakHashMap;
    }

    public WeakHashMap testG() {
        WeakHashMap<Object, String> weakHashMap = new WeakHashMap<>();
        String s = "key";
        weakHashMap.put(s, "value");
        System.out.println(weakHashMap);
        System.gc();
        System.out.println(weakHashMap);
        return weakHashMap;
    }

    public WeakHashMap testH() {
        WeakHashMap<Object, String> weakHashMap = new WeakHashMap<>();
        String s = new String("key");
        weakHashMap.put(s, "value");
        System.out.println(weakHashMap);
        System.gc();
        System.out.println(weakHashMap);
        return weakHashMap;
    }

    public WeakHashMap testI() {
        WeakHashMap<Object, String> weakHashMap = new WeakHashMap<>();
        weakHashMap.put(1, "value");
        System.out.println(weakHashMap);
        System.gc();
        System.out.println(weakHashMap);
        return weakHashMap;
    }

    public WeakHashMap testJ() {
        WeakHashMap<Object, String> weakHashMap = new WeakHashMap<>();
        Integer i = new Integer(1);
        weakHashMap.put(i, "value");
        System.out.println(weakHashMap);
        System.gc();
        System.out.println(weakHashMap);
        return weakHashMap;
    }

    public WeakHashMap testK() {
        WeakHashMap<Object, String> weakHashMap = new WeakHashMap<>();
        weakHashMap.put(false, "value");
        System.out.println(weakHashMap);
        System.gc();
        System.out.println(weakHashMap);
        return weakHashMap;
    }

    public WeakHashMap testL() {
        WeakHashMap<Object, String> weakHashMap = new WeakHashMap<>();
        Boolean b = new Boolean(false);
        weakHashMap.put(b, "value");
        System.out.println(weakHashMap);
        System.gc();
        System.out.println(weakHashMap);
        return weakHashMap;
    }
}
