package com.xiaochen.goodsmanager.view;

import com.xiaochen.goodsmanager.entity.Goods;
import com.xiaochen.goodsmanager.service.GoodsServiceDao;
import com.xiaochen.goodsmanager.service.GoodsServiceDaoimpl.GoodsServiceDaoimpl;
import com.xiaochen.goodsmanager.service.GoodsServiceDaoimpl.LimitServiceDaoimpl;
import com.xiaochen.goodsmanager.service.LimitServiceDao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class GoodsView {
    Scanner input = new Scanner(System.in);
    GoodsServiceDao goodsServiceDao = new GoodsServiceDaoimpl();
    LimitServiceDao limitDao=new LimitServiceDaoimpl();

    /*
    上架商品
     */
    public void addgoods() {
        Goods goods = new Goods();
        System.out.println("输入商品名称");
        goods.setGname(input.next());
        System.out.println("输入商品价格");
        goods.setGprice(input.next());
        try {
            boolean goodsadd = goodsServiceDao.goodsadd(goods);
            if (goodsadd) {
                System.out.println("添加成功");
            } else {
                System.out.println("请检查");
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
   下架商品
    */
    public void delgoods() {
        Goods goods = new Goods();
        System.out.println("输入要删除的商品id");
        int id = input.nextInt();
        goods.setGid(id);
        int gid = goods.getGid();
        try {
            boolean goodsdel = goodsServiceDao.goodsdel(goods, gid);
            if (goodsdel) {
                System.out.println("下架成功");
            } else {
                System.out.println("下架异常:请检查");
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
   修改商品信息
    */
    public void updategoods() {
        Goods goods = new Goods();
        System.out.println("输入商品名称");
        goods.setGname(input.next());
        System.out.println("输入商品价格");
        goods.setGprice(input.next());
        System.out.println("输入商品id");
        int id = input.nextInt();
        goods.setGid(id);
        int gid = goods.getGid();
        try {
            boolean goodsdel = goodsServiceDao.goodsupdate(goods, gid);
            if (goodsdel) {
                System.out.println("修改成功");
            } else {
                System.out.println("修改异常:请检查");
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
      查看商品信息
       */
    public void showgoods() {
        Goods goods = new Goods();
        System.out.println("输入商品id");
        int id = input.nextInt();
        try {
            List goodshow = goodsServiceDao.goodshow(goods, id);
            String s = goodshow.toString();
            System.out.println(s);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /*
     查看所有商品信息
      */
    public void showsgoods() {
        Goods goods = new Goods();
        try {
            List goodshows = goodsServiceDao.goodshows(goods);
            for (Object goodshow : goodshows) {
                System.out.println(goodshow);
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
    public void limitgoods(){
        Goods goods = new Goods();
        System.out.println("输入页数");
        Integer id = input.nextInt();
        try {
            try {
                limitDao.Limit(goods,id);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}