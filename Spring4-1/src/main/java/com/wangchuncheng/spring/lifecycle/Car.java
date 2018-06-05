package com.wangchuncheng.spring.lifecycle;

public class Car{
    private String brand;

    public Car() {
        System.out.println("Car's Constructor...");
    }
    public void onInit(){
        System.out.println("init...");
    }
    public void destroy(){
        System.out.println("destroy...");
    }
    public void setBrand(String brand) {
        System.out.println("setAttribute...");
        this.brand = brand;
    }
}
