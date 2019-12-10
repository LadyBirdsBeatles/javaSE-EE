package com.xiaochen.controller;

import com.xiaochen.pojo.Car;
import com.xiaochen.pojo.CarAddPojo;
import com.xiaochen.pojo.Park;
import com.xiaochen.pojo.User;
import com.xiaochen.service.CarService;
import com.xiaochen.service.ParkService;
import com.xiaochen.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/cars")
@Controller
public class CarController {

    private CarService carService;
    private UserService userService;
    private ParkService parkService;

    @Autowired
    public CarController(CarService carService, UserService userService, ParkService parkService) {
        System.out.println("--------------------------CarController构造函数");
        this.carService = carService;
        this.userService = userService;
        this.parkService = parkService;
    }


    public Map selectCar(Car car, HttpServletResponse response, HttpServletRequest request) {
        Map map = new HashMap<>();
        List<Car> cars = carService.selectCar(car);

        return map;
    }

    @RequestMapping("/carlist")
    public void selectCarList(HttpServletResponse response, HttpServletRequest request,Integer page ,Integer limit) {
        System.out.println("后台:cars/carlist--------");
        Map map = new HashMap<>();
        Map maps = new HashMap<>();
        Car car = new Car();
        User user = new User();
        maps.put("page",page);
        maps.put("limits",limit);
        List<Car> cars = carService.selectCarList(maps);
        System.out.println(cars);
        map.put("data", cars);
        map.put("code", "");
        map.put("msg", "");
        map.put("count", cars.size());
        JSONObject json = new JSONObject(map);
        response.setCharacterEncoding("utf-8");
        try {
            response.getWriter().write(json.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/caradd")
    @ResponseBody
    public Map insert(@RequestBody CarAddPojo carAddPojo) {
        Map map = new HashMap();
        System.out.println("注入的对象：----------------");
        System.out.println(carAddPojo);
        User user = new User();
        Car car = new Car();
        user.setUserName(carAddPojo.getUserName());
        user.setUserPhonenumber(carAddPojo.getUserPhone());
        car.setCarCard(carAddPojo.getCarCard());
        car.setCarStartdate(carAddPojo.getCarStartdate());
        car.setCarEnddate(carAddPojo.getCarEnddate());
        car.setCarPid(carAddPojo.getCarPid());
        System.out.println("注入的对象结束-----------------");
        System.out.println("封装后的对象:----------------");
        System.out.println("car:---" + car);
        System.out.println("user:" + user);
        System.out.println("封装后的对象结束:----------------");
        List<User> users = userService.selectUser(user);
        user = users.get(0);
        System.out.println("查询出来的user" + user);
        car.setCarUid(user.getUserId());
//        car.setCarUid(userService.selectUser(user).get(0).getUserId()); //将输入的用户名和电话联查出用户id,写入car对应字段中
        System.out.println("注入数据库的car:" + car);
        int i = carService.insertCar(car);
        if (car.getCarPid() != null) {
            Park park = new Park();
            park.setParkId(car.getCarPid());
            park.setParkUid(user.getUserId());
            park.setParkSaledate(new Date());
            parkService.updatePark(park);
        }
        if (i == 1) {
            map.put("returncode", 1);
            map.put("msg", "添加成功!");
            map.put("data", "");
            map.put("code", "");
        } else {
            map.put("returncode", -1);
            map.put("msg", "添加失败!");
            map.put("data", "");
            map.put("code", "");
        }

        return map;
    }

    @RequestMapping("/carupdate")
    @ResponseBody
    public Map updateCar(@RequestBody CarAddPojo carAddPojo) {
        System.out.println("注入的对象：----------------");
        System.out.println(carAddPojo);
        User user = new User();
        Map map = new HashMap();
        Car car = new Car();
        user.setUserPhonenumber(carAddPojo.getUserPhone());
        user.setUserName(carAddPojo.getUserName());
        car.setCarCard(carAddPojo.getCarCard());
        car = carService.selectCar(car).get(0);
        car.setCarStartdate(carAddPojo.getCarStartdate());
        car.setCarEnddate(carAddPojo.getCarEnddate());
        car.setCarPid(carAddPojo.getCarPid());
        System.out.println("注入的对象结束-----------------");
        System.out.println("封装后的对象:----------------");
        System.out.println("user:" + user);
        System.out.println("car:---" + car);
        System.out.println("封装后的对象结束:----------------");
        List<User> users = userService.selectUser(user);
        user = users.get(0);
        System.out.println("查询出来的user" + user);
        car.setCarUid(user.getUserId());
        //将输入的用户名和电话联查出用户id,写入car对应字段中
        System.out.println("注入数据库的car:" + car);
        int i = carService.updateCar(car);
        if (i == 1) {
            if (car.getCarPid() != null) {
            Park park = new Park();
            park.setParkId(car.getCarPid());
            park.setParkSaledate(new Date());
            park.setParkUid(user.getUserId());
            park.setParkCid(car.getCarId());
            parkService.updatePark(park);
        }
            map.put("returncode", 1);
            map.put("msg", "添加成功!");
            map.put("data", "");
            map.put("code", "");
        } else {
            map.put("returncode", -1);
            map.put("msg", "添加失败!");
            map.put("data", "");
            map.put("code", "");
        }

        return map;

    }
}
