package com.wangchuncheng.spring.beans;

import java.util.List;

public class RichPerson extends Person{
    List<Car> cars;

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "RichPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cars=" + cars +
                '}';
    }
}
