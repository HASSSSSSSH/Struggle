package test;

public class VolatileTest {

    private boolean isOverWithoutVolatile = false;
    private volatile boolean isOver = false;

    public static void main(String[] args) {
        VolatileTest instance = new VolatileTest();
//        instance.testA();
//        instance.testB();
//        instance.testC();
        instance.testD();
    }

    public void testA() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isOver) ;
                System.out.println("looping end");
            }
        });
        thread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isOver = true;
    }

    public void testB() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isOverWithoutVolatile) ;
                System.out.println("looping end");
            }
        });
        thread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isOverWithoutVolatile = true;
    }

    public void testC() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isOver) {
                    System.out.println("looping");
                }
                System.out.println("looping end");
            }
        });
        thread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isOver = true;
    }

    //    System.out.println源码如下:
    //
    //    public void println(Object x) {
    //        String s = String.valueOf(x);
    //        synchronized (this) {
    //            print(s);
    //            newLine();
    //        }
    //    }
    //
    //    可以发现是println方法是加了synchronized的，jvm中对锁的优化有一条为
    //    锁的粗化，如果一系列的连续操作都对同一个对象反复加锁和解锁
    //    甚至加锁操作是出现在循环体中的，那即使没有线程竞争
    //    频繁地进行互斥同步操作也会导致不必要的性能损耗。
    //    如果虚拟机探测到有这样一串零碎的操作都对同一个对象加锁，
    //    将会把加锁同步的范围扩展（膨胀）到整个操作序列的外部（由多次加锁编程只加锁一次）
    //    即是：
    //
    //    synchronized {
    //        while (isOver) {
    //            Sout();
    //        }
    //    }
    //    所以synchronized会将isOver 的值在锁释放前刷回共享内存
    public void testD() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isOverWithoutVolatile) {
                    System.out.println("looping");
                }
                System.out.println("looping end");
            }
        });
        thread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isOverWithoutVolatile = true;
    }
}
