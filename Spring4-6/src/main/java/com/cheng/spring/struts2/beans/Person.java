package com.cheng.spring.struts2.beans;

public class Person {
    private String name;

    public void hello(){
        System.out.println("Hello My name is "+ name);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
