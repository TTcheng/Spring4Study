package com.wangchuncheng.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        /**
         * 传统方式：*/
//        //创建对象
//        HelloWorld helloWorld = new HelloWorld();
//        //为name赋值
//        helloWorld.setName("Jesse");
//        //say hello
//        helloWorld.hello();

        /**
         * Spring方式：
         */
        //1、创建Spring的IOC容器对象,这里会创建xml文件中的bean对象，并按xml中的配置为属性赋值
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //2、从IOC容器中获取Bean示例
        HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorld");
        //say hello
        helloWorld.hello();

        Car car = (Car) ctx.getBean("car");
        System.out.println(car);

        Person person = (Person) ctx.getBean("person");
        System.out.println(person);

        RichPerson richPerson = (RichPerson) ctx.getBean("richPerson");
        System.out.println(richPerson);

        RichPerson richPerson1 = (RichPerson) ctx.getBean("richPerson2");
        System.out.println(richPerson1);

        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        System.out.println(dataSource);
    }
}
