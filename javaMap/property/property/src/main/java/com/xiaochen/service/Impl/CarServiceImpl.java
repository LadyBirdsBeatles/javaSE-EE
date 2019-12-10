package com.xiaochen.service.Impl;

import com.xiaochen.mapper.CarMapper;
import com.xiaochen.pojo.Car;
import com.xiaochen.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("CarService")
public class CarServiceImpl implements CarService {

    private CarMapper carMapper;
    //构造方法
    @Autowired
    public CarServiceImpl(CarMapper carMapper){
        this.carMapper = carMapper;
    }


    @Override
    public int insertCar(Car car) {
        return this.carMapper.insertCar(car);
    }

    @Override
    public int updateCar(Car car) {
        return this.carMapper.updateCar(car);
    }

    @Override
    public List<Car> selectCar(Car car) {
        return this.carMapper.selectCar(car);
    }

    @Override
    public List<Car> selectCarList(Map maps) {
        return this.carMapper.selectCarList(maps);
    }
}
