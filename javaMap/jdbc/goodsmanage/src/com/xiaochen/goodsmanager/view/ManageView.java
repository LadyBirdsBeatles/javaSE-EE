package com.xiaochen.goodsmanager.view;

import com.xiaochen.goodsmanager.common.Verification;
import com.xiaochen.goodsmanager.entity.Admin;
import com.xiaochen.goodsmanager.entity.Employee;
import com.xiaochen.goodsmanager.service.GoodsServiceDaoimpl.LimitServiceDaoimpl;
import com.xiaochen.goodsmanager.service.GoodsServiceDaoimpl.ManageServiceDaoimpl;
import com.xiaochen.goodsmanager.service.LimitServiceDao;
import com.xiaochen.goodsmanager.service.ManageServiceDao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * 管理层
 */
public class ManageView {
    private ManageServiceDao manageServiceDao = new ManageServiceDaoimpl();
    LimitServiceDao limitDao = new LimitServiceDaoimpl();
    private Scanner input = new Scanner(System.in);
    Date date = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    String newdate = format.format(date);


    /*
    管理员登陆
     */
    public int adminlogin() {
        Admin admin = new Admin();
        System.out.println("请输入用户名");
        admin.setAccount(input.next());
        System.out.println("请输入密码");
        String inpwd = input.next();
        // String pwd = MD5Creater.getMD5(inpwd);
        admin.setPwd(inpwd);
        try {
            int adminlogin = manageServiceDao.adminlogin(admin);
            if (adminlogin == 1) {
                System.out.println("*********************************************");
                System.out.println("登陆成功:你的身份是**超级管理员**你可以管理员工");
                System.out.println("*********************************************");
                return  1;
            } else if (adminlogin == 0) {
                System.out.println("*****************************************");
                System.out.println("登陆成功:你的身份是**管理员**只能管理商品");
                System.out.println("*****************************************");
                return  0;
            } else {
                System.out.println("请检查用户名或密码");
            }

        } catch (SQLException e) {
            System.out.println("用户不存在或输入错误");
        } catch (ClassNotFoundException e) {
            System.out.println("操作异常");
        }
        return -1;
    }

    /*
    添加员工
     */
    public void addemp() {
        Employee employee = new Employee();
        employee.setEhiredate(newdate);
        System.out.println("输入姓名");
        employee.setEname(input.next());
        System.out.println("输入性别");
        employee.setEgender(input.next());
        System.out.println("输入年龄");
        employee.setEage(input.nextInt());
        System.out.println("输入生日");
        employee.setEbirthday(input.next());
        System.out.println("输入部门");
        employee.setDepartment(input.next());
        System.out.println("输入职务");
        employee.setEjob(input.next());
        System.out.println("输入电话号码");
        String inphonenumber = input.next();
        boolean s = Verification.checkCellphone(inphonenumber);
        if (s) {
            employee.setEphonenumber(inphonenumber);
        } else {
            System.out.println("手机号码格式有误");
        }
        System.out.println("输入备注");
        employee.setEcomment(input.next());
        try {
            boolean empadd = manageServiceDao.empadd(employee);
            if (empadd) {
                System.out.println("注册成功");
            } else {
                System.out.println("检查输入的信息");
            }
        } catch (IllegalAccessException e) {
            System.out.println("类型不匹配");
        } catch (SQLException e) {
            System.out.println("类型不匹配");
        } catch (ClassNotFoundException e) {
            System.out.println("类型不匹配");
        }
    }

    /*
    开除员工
     */
    public void delemp() {
        Employee employee = new Employee();
        System.out.println("输入id");
        Integer id = input.nextInt();
        employee.setEid(id);
        int eid = employee.getEid();
        try {
            boolean empdel = manageServiceDao.empdel(employee, eid);
            if (empdel) {
                System.out.println("删除成功");
            } else {
                System.out.println(" 请检查输入");
            }
        } catch (IllegalAccessException e) {

        } catch (SQLException e) {

        } catch (ClassNotFoundException e) {

        }
    }

    /*
    修改员工信息
     */
    public void updateemp() {
        Employee employee = new Employee();
        String newdate = format.format(date);
        employee.setEhiredate(newdate);
        System.out.println("输入姓名");
        employee.setEname(input.next());
        System.out.println("输入性别");
        employee.setEgender(input.next());
        System.out.println("输入年龄");
        employee.setEage(input.nextInt());
        System.out.println("输入生日");
        employee.setEbirthday(input.next());
        System.out.println("输入部门");
        employee.setDepartment(input.next());
        System.out.println("输入职务");
        employee.setEjob(input.next());
        System.out.println("输入电话号码");
        employee.setEphonenumber(input.next());
        System.out.println("输入备注");
        employee.setEcomment(input.next());
        System.out.println("输入id");
        Integer id = input.nextInt();
        employee.setEid(id);
        int eid = employee.getEid();
        try {
            boolean empupdate = manageServiceDao.empupdate(employee, eid);
            if (empupdate) {
                System.out.println("修改成功");
            } else {
                System.out.println(" 请检查输入");
            }
        } catch (IllegalAccessException e) {

        } catch (SQLException e) {

        } catch (ClassNotFoundException e) {

        }

    }

    /*
    查看员工信息
     */
    public void showemp() {
        Employee employee = new Employee();
        System.out.println("输入id");
        int id = input.nextInt();
        // employee.setEid(id);
        try {
            List empshow = manageServiceDao.empshow(employee, id);
            for (Object o : empshow) {
                System.out.println(o);
            }
        } catch (ClassNotFoundException e) {

        } catch (SQLException e) {

        } catch (InstantiationException e) {

        } catch (IllegalAccessException e) {

        } catch (InvocationTargetException e) {

        }
    }

    /*
    查看所有员工信息
     */
    public void showallemp() {
        Employee employee = new Employee();
        try {
            List empshows = manageServiceDao.empshows(employee);
            for (Object empshow : empshows) {
                System.out.println(empshow);
            }
        } catch (ClassNotFoundException e) {

        } catch (SQLException e) {

        } catch (InvocationTargetException e) {

        } catch (InstantiationException e) {

        } catch (IllegalAccessException e) {

        }
    }

    /**
     * 看记录
     */
    public void limitemp() {
        Employee employee = new Employee();
        System.out.println("输入页数");
        Integer id = input.nextInt();
        try {
            limitDao.Limit(employee, id);
        } catch (SQLException e) {

        } catch (ClassNotFoundException e) {

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
