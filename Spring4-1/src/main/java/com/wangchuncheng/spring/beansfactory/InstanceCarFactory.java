package com.wangchuncheng.spring.beansfactory;

import com.wangchuncheng.spring.beans.Car;

import java.util.HashMap;
import java.util.Map;

public class InstanceCarFactory {
    private Map<String,Car> cars = null;
    public InstanceCarFactory(){
        cars = new HashMap<String, Car>();
        cars.put("audi",new Car("audi","Shangqi",300000,240));
        cars.put("ford",new Car("ford","GM",400000,250));
    }
    public Car getCar(String brand) {
        return cars.get(brand);
    }
}
