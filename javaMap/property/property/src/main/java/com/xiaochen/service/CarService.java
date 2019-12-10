package com.xiaochen.service;

import com.xiaochen.pojo.Car;

import java.util.List;
import java.util.Map;

public interface CarService {
    int insertCar(Car car); //增加车辆信息

    int updateCar(Car car);//修改登记车辆信息

    List<Car> selectCar(Car car);  //查找车辆信息,返回的事一个列表

    List<Car> selectCarList(Map maps);
}
