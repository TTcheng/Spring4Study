package com.wangchuncheng.spring.relation;

import com.wangchuncheng.spring.autowire.Address;
import com.wangchuncheng.spring.autowire.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bean之间的关系
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-relation.xml");
        Address address = (Address) ctx.getBean("address");
        Address address2 = (Address) ctx.getBean("address2");
        System.out.println(address);
        System.out.println(address2);

        Person person = (Person) ctx.getBean("person");
        System.out.println(person);
    }
}
