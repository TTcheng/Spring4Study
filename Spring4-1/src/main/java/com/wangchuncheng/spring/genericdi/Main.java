package com.wangchuncheng.spring.genericdi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 泛型依赖注入
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-genericdi.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.add();
    }
}
