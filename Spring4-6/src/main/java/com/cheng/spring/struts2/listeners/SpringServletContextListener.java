package com.cheng.spring.struts2.listeners;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
public class SpringServletContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //获取Spring配置文件的名称
        ServletContext servletContext = servletContextEvent.getServletContext();
        String config = servletContext.getInitParameter("configuration");
        //1、创建IOC容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        //2、把IOC容器放在ServletContext的一个属性中
        servletContext.setAttribute("ApplicationContext",ctx);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

}
