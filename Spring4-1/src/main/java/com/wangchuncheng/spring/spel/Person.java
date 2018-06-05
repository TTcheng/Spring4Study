package com.wangchuncheng.spring.spel;

public class Person extends com.wangchuncheng.spring.beans.Person {
    //if car.getPrice(
    private String level;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Person{" +
                "level='" + level + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }
}
