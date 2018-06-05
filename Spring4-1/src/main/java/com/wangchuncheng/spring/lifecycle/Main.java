package com.wangchuncheng.spring.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * IOC容器中bean的生命周期
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-lifecycle.xml");
        Car car = (Car) ctx.getBean("car");
        System.out.println(car);
        ((ClassPathXmlApplicationContext) ctx).close();
    }
}
