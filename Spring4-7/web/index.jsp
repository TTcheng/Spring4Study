<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="com.cheng.spring.struts2.beans.Person" %><%--
  Created by IntelliJ IDEA.
  User: WangChunCheng
  Date: 2018/6/3
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
    Person person = context.getBean(Person.class);
    person.hello();
  %>
  </body>
</html>
