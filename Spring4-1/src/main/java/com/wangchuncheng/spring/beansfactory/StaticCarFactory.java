package com.wangchuncheng.spring.beansfactory;

import com.wangchuncheng.spring.beans.Car;

import java.util.HashMap;
import java.util.Map;

/**
 * 静态工厂方法：直接调用某一个静态方法就可以返回Bean的实例
 */
public class StaticCarFactory {
    private static Map<String,Car> cars = new HashMap<String, Car>();
    static {
        cars.put("audi",new Car("audi","Shangqi",300000,240));
        cars.put("ford",new Car("ford","GM",400000,250));
    }
    //静态工厂方法
    public static Car getCar(String name){
        return cars.get(name);
    }
}
