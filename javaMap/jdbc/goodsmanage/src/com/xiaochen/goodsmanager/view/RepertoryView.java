package com.xiaochen.goodsmanager.view;

import com.xiaochen.goodsmanager.entity.Repertory;
import com.xiaochen.goodsmanager.service.GoodsServiceDaoimpl.LimitServiceDaoimpl;
import com.xiaochen.goodsmanager.service.GoodsServiceDaoimpl.RepertoryServiceDaoimpl;
import com.xiaochen.goodsmanager.service.LimitServiceDao;
import com.xiaochen.goodsmanager.service.RepertoryServiceDao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class RepertoryView {
    private Scanner input = new Scanner(System.in);
    private RepertoryServiceDao repertoryServiceDao = new RepertoryServiceDaoimpl();
    LimitServiceDao limitDao = new LimitServiceDaoimpl();
    Date date = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    String newdate = format.format(date);

    /*
        add库存
         */
    public void repertoryadd() {
        Repertory repertory = new Repertory();
        repertory.setRdata(newdate);
        System.out.println("商品编号");
        repertory.setGid(input.nextInt());
        System.out.println("输入商品总量");
        repertory.setSnumber(input.nextInt());
        System.out.println("是否售出:0是.1否");
        repertory.setRoutnumber(input.nextInt());
        System.out.println("输入保剩余库存");
        repertory.setResidue(input.nextInt());
        System.out.println("输入备注");
        repertory.setEcomment(input.next());
        try {
            boolean repertoryadd = repertoryServiceDao.repertoryadd(repertory);
            if (repertoryadd) {
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
       删除库存
        */
    public void repertorydel() {
        Repertory repertory = new Repertory();
        System.out.println("输入id");
        Integer id = input.nextInt();
        repertory.setRid(id);
        int rid = repertory.getRid();
        try {
            boolean repertorydel = repertoryServiceDao.repertorydel(repertory, rid);
            if (repertorydel) {
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
       修改库存
        */
    public void repertoryup() {
        Repertory repertory = new Repertory();
        repertory.setRdata(newdate);
        System.out.println("商品编号");
        repertory.setGid(input.nextInt());
        System.out.println("输入商品总量");
        repertory.setSnumber(input.nextInt());
        System.out.println("是否售出:0是.1否");
        repertory.setRoutnumber(input.nextInt());
        System.out.println("输入保剩余库存");
        repertory.setResidue(input.nextInt());
        System.out.println("输入备注");
        repertory.setEcomment(input.next());
        System.out.println("输入id");
        Integer id = input.nextInt();
        repertory.setRid(id);
        int rid = repertory.getRid();
        try {
            boolean repertoryupdate = repertoryServiceDao.repertoryupdate(repertory, rid);
            if (repertoryupdate) {
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
       查看库存
        */
    public void repertoryshow() {
        Repertory repertory = new Repertory();
        System.out.println("输入id");
        Integer id = input.nextInt();
        try {
            List repertoryshow = repertoryServiceDao.repertoryshow(repertory, id);
            String s = repertoryshow.toString();
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
       查看所有库存
        */
    public void repertoryallshows() {
        Repertory repertory = new Repertory();
        try {
            List repertoryshows = repertoryServiceDao.repertoryshows(repertory);
            for (Object repertoryshow : repertoryshows) {
                System.out.println(repertoryshows);
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
    public void limitrepertory() {
        Repertory repertory = new Repertory();
        System.out.println("输入页数");
        Integer id = input.nextInt();
        try {
            try {
                limitDao.Limit(repertory,id);
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