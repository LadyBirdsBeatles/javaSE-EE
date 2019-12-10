package com.xiaochen.controller;

import com.xiaochen.pojo.Car;
import com.xiaochen.pojo.Park;
import com.xiaochen.pojo.ParkUpdatePojo;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/park")
public class ParkController {

    private ParkService parkService;
    private UserService userService;
    private CarService carService;

    @Autowired
    public ParkController(ParkService parkService, UserService userService, CarService carService) {
        this.parkService = parkService;
        this.carService = carService;
        this.userService = userService;
    }


    public void insertPark(User user, Car car) {
        System.out.println("后台:park/sale------------------");
        System.out.println("user:" + user);
        System.out.println("car:" + car);
        List<User> users = userService.selectUser(user);
        List<Car> cars = carService.selectCar(car);
        User getuser = users.get(0);
        Car getcar = cars.get(0);
        System.out.println("查出来的user:" + getuser);
        System.out.println("查出来的car:" + getcar);
        Park park = new Park();
        park.setParkUid(getuser.getUserId());


    }

    @RequestMapping("/sale")
    @ResponseBody
    public Map updatePark(@RequestBody ParkUpdatePojo pojo) {
        System.out.println("注入的对象:-------------");
        Map map = new HashMap();
        System.out.println(pojo);
        Park park = new Park();
        User user = new User();
        Car car = new Car();
        user.setUserName(pojo.getUserName());
        user.setUserPhonenumber(pojo.getUserPhonenumber());
        car.setCarCard(pojo.getCarCard());
        park.setParkId(pojo.getParkId());
        if (pojo.getCarCard() != "") {
            car = carService.selectCar(car).get(0);
            park.setParkCid(car.getCarId());
        }
        user = userService.selectUser(user).get(0);

        park.setParkUid(user.getUserId());
        int i = parkService.updatePark(park);
        if (i == 1) {
            map.put("msg", "添加成功!");
            map.put("returncode", 1);
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


    @RequestMapping("/parklist")
    @ResponseBody
    public void selectPark(HttpServletResponse response, HttpServletRequest request) {
        System.out.println("后台:park/parklist--------");
        Map map = new HashMap<>();
        Park park = new Park();
        List<Park> parks = parkService.selectParkList(park);
        System.out.println(parks);
        map.put("data", parks);
        map.put("msg", "");
        map.put("code", "");
        map.put("count", parks.size());
        response.setCharacterEncoding("utf-8");
        JSONObject json = new JSONObject(map);
        try {
            response.getWriter().write(json.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Park> selectParkList(Park park) {
        return this.parkService.selectParkList(park);
    }

}
