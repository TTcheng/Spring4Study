package com.wangchuncheng.spring.annotation;

import com.wangchuncheng.spring.annotation.controller.UserController;
import com.wangchuncheng.spring.annotation.repository.UserRepositoryImpl;
import com.wangchuncheng.spring.annotation.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring注解
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-annotation.xml");
//        TestObject testObject = (TestObject) ctx.getBean("testObject");
//        System.out.println(testObject);
//
        UserController userController = (UserController) ctx.getBean("userController");
        System.out.println(userController);
        userController.execute();
//
//        UserRepositoryImpl userRepository = (UserRepositoryImpl) ctx.getBean("userRepository");
//        System.out.println(userRepository);
//
//        UserService userService = (UserService) ctx.getBean("userService");
//        System.out.println(userService);


    }
}
