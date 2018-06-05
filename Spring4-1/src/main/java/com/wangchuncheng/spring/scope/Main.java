package com.wangchuncheng.spring.scope;

import com.wangchuncheng.spring.beans.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bean的作用域
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-scope.xml");
        Car car = (Car) ctx.getBean("car");
        Car car1 = (Car) ctx.getBean("car");
        //scope=singleton时为true
        //scope=prototype时为false
        System.out.println(car == car1);
    }
}
