package com.wangchuncheng.spring.beansfactory;

import com.wangchuncheng.spring.beans.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 通过工厂方法配置bean
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-factory.xml");
        Car car1 = (Car) ctx.getBean("car1");
        System.out.println("car1:" + car1);

        Car car2 = (Car) ctx.getBean("car2");
        System.out.println("car1:" + car2);
    }
}
