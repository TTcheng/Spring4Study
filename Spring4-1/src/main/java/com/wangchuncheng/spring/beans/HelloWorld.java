package com.wangchuncheng.spring.beans;

public class HelloWorld {
    private String name;

    public HelloWorld() {
        System.out.println("constructor");
    }
    public void setName(String name) {
        System.out.println("set name");
        this.name = name;
    }
    public void hello(){
        System.out.println("Hello "+name);
    }
}
