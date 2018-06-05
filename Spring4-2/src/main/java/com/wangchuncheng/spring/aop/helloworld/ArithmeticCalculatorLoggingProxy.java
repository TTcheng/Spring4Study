package com.wangchuncheng.spring.aop.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 日志代理
 */
public class ArithmeticCalculatorLoggingProxy {
    private ArithmeticCalculator target;

    public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
        this.target = target;
    }

    public ArithmeticCalculator getLoggingProxy() {
        ArithmeticCalculator proxy = null;
        //代理对象由哪一个类加载器负责加载
        ClassLoader loader = target.getClass().getClassLoader();
        //代理对象的类型，即其中有哪些方法
        Class[] interfaces = new Class[]{ArithmeticCalculator.class};
        //当调用代理对象其中的方法时，该执行的代码
        InvocationHandler h = new InvocationHandler() {
            /**
             * proxy:正在返回的那个代理对象，一般情况下，在invoke方法中都不使用该对象。
             * method:正在被调用的方法
             * args:调用方法时传入的参数
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("The method "+method.getName()+" begins with "+ Arrays.asList(args));
                Object result = method.invoke(target,args);
                System.out.println("The method "+method.getName()+" end with return "+ result);
                return result;
            }
        };
        proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);
        return proxy;
    }

    public ArithmeticCalculator getTarget() {
        return target;
    }

    public void setTarget(ArithmeticCalculator target) {
        this.target = target;
    }
}
