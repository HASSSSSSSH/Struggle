package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Reference: https://www.liaoxuefeng.com/wiki/1252599548343744/1264804593397984
 */
public class Main {

    public static void main(String[] args) {
        Main instance = new Main();

        instance.test1();

        instance.test2();
    }

    public void test1() {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) {
                System.out.println(method);
                if (method.getName().equals("hello")) {
                    System.out.println("hello world, " + args[0]);
                }
                return null;
            }
        };

        IHello hello = (IHello) Proxy.newProxyInstance(
                IHello.class.getClassLoader(), // 传入ClassLoader
                new Class[]{IHello.class}, // 传入要实现的接口
                handler); // 传入处理调用方法的InvocationHandler
        hello.hello("Bob");
    }

    public void test2() {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) {
                System.out.println(method);
                if (method.getName().equals("hello")) {
                    System.out.println("hello world, " + args[0]);
                }
                return null;
            }
        };

        IIHello hello = new HelloDynamicProxy(handler);

        try {
            hello.hello("Bob");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public interface IHello {
        void hello(String s);
    }

    public interface IIHello {
        void hello(String s) throws Throwable;
    }

    // 动态代理实际上是JVM在运行期动态创建class字节码并加载的过程
    // 把上面的动态代理改写为静态实现类大概长这样
    public class HelloDynamicProxy implements IIHello {

        InvocationHandler handler;

        public HelloDynamicProxy(InvocationHandler handler) {
            this.handler = handler;
        }

        public void hello(String name) throws Throwable {
            handler.invoke(
                    this,
                    IIHello.class.getMethod("hello", String.class),
                    new Object[]{name});
        }
    }
}
