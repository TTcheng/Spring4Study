package com.wangchuncheng.spring.aop.helloworld;

/**
 * 动态代理
 */
public class Main {
    public static void main(String[] args) {
//        ArithmeticCalculatorImpl calculator = null;
//        calculator = new ArithmeticCalculatorImpl();
        ArithmeticCalculator calculator = new ArithmeticCalculatorImpl();
        ArithmeticCalculator proxy = new ArithmeticCalculatorLoggingProxy(calculator).getLoggingProxy();
        int res = proxy.add(1,2);
        System.out.println(res);
    }
}
