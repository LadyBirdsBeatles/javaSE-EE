package com.xiaochen.goodsmanager.view;

import com.xiaochen.goodsmanager.entity.Particulars;
import com.xiaochen.goodsmanager.service.GoodsServiceDaoimpl.LimitServiceDaoimpl;
import com.xiaochen.goodsmanager.service.GoodsServiceDaoimpl.ParticularsServiceDaoimp;
import com.xiaochen.goodsmanager.service.LimitServiceDao;
import com.xiaochen.goodsmanager.service.ParticularsServiceDao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * 商品详情试图
 */
public class ParticularsView {
    Scanner input = new Scanner(System.in);
    ParticularsServiceDao particularsServiceDao = new ParticularsServiceDaoimp();
    LimitServiceDao limitDao = new LimitServiceDaoimpl();

    /*
    添加详情
     */
    public void particadd() {
        Particulars particulars = new Particulars();
        System.out.println("商品编号");
        particulars.setGid(input.nextInt());
        System.out.println("输入商品重量");
        particulars.setPweight(input.nextInt());
        System.out.println("录入生产日期");
        particulars.setPmanufacture(input.next());
        System.out.println("输入保质期");
        particulars.setPexpiration(input.nextInt());
        System.out.println("输入商品类型");
        particulars.setPtype(input.next());
        System.out.println("输入厂商名称");
        particulars.setPsuppliername(input.next());
        System.out.println("输入厂商地址");
        particulars.setPaddress(input.next());
        System.out.println("输入厂商电话");
        particulars.setPhonenumber(input.next());
        System.out.println("输入备注");
        particulars.setEcomment(input.next());
        try {
            boolean particadd = particularsServiceDao.particadd(particulars);
            if (particadd) {
                System.out.println("添加成功");
            } else {
                System.out.println("操作异常:添加失败");
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /*
    删除详情
     */
    public void particdel() {
        Particulars particulars = new Particulars();
        System.out.println("输入id");
        Integer id = input.nextInt();
        particulars.setPid(id);
        int pid = particulars.getPid();
        try {
            boolean particdel = particularsServiceDao.particdel(particulars, pid);
            if (particdel) {
                System.out.println("删除成功");
            } else {
                System.out.println("操作异常:删除失败");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /*
   修改详情
    */
    public void particupdate() {
        Particulars particulars = new Particulars();
        System.out.println("商品编号");
        particulars.setGid(input.nextInt());
        System.out.println("输入商品重量");
        particulars.setPweight(input.nextInt());
        System.out.println("录入生产日期");
        particulars.setPmanufacture(input.next());
        System.out.println("输入保质期");
        particulars.setPexpiration(input.nextInt());
        System.out.println("输入商品类型");
        particulars.setPtype(input.next());
        System.out.println("输入厂商名称");
        particulars.setPsuppliername(input.next());
        System.out.println("输入厂商地址");
        particulars.setPaddress(input.next());
        System.out.println("输入厂商电话");
        particulars.setPhonenumber(input.next());
        System.out.println("输入备注");
        particulars.setEcomment(input.next());
        System.out.println("输入id");
        Integer id = input.nextInt();
        try {
            boolean particupdate = particularsServiceDao.particupdate(particulars, id);
            if (particupdate) {
                System.out.println("修改成功");
            } else {
                System.out.println("操作异常:修改失败");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /*
    查看详情
     */
    public void particshow() {
        Particulars particulars = new Particulars();
        try {
            List particshow = particularsServiceDao.particshow(particulars);
            for (Object o : particshow) {
                String s = o.toString();
                System.out.println(s);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }

    /**
     * 看记录
     */
    public void limitpartic() {
        Particulars particulars = new Particulars();
        System.out.println("输入页数");
        Integer id = input.nextInt();
        try {
            limitDao.Limit(particulars, id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}