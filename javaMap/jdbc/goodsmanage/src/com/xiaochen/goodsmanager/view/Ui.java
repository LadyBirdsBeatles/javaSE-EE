package com.xiaochen.goodsmanager.view;

import com.xiaochen.goodsmanager.view.GoodsView;
import com.xiaochen.goodsmanager.view.ManageView;
import com.xiaochen.goodsmanager.view.ParticularsView;
import com.xiaochen.goodsmanager.view.RepertoryView;

import java.util.Scanner;

/**
 * 展示页面
 */
public class Ui {
    ManageView manageView = new ManageView();
    RepertoryView repertoryView = new RepertoryView();
    GoodsView goodsView = new GoodsView();
    ParticularsView particularsView = new ParticularsView();
    Scanner input = new Scanner(System.in);

    /**
     * 主菜单
     */
    public void menu() {
        System.out.println("****************************************");
        System.out.println("***  请根据相应的提示选择您想要的功能 ***");
        System.out.println("**          1、登陆                   **");
        System.out.println("**          0、退出                   **");
        System.out.println("**          9、退出系统               **");
        System.out.println("****************************************");

    }

    /**
     * 退出
     */
    public void exit() {
        System.out.print("输入0退出：");
        int exit = input.nextInt();
        while (exit != 0) {
            System.out.print("输入0退出：");
            exit = input.nextInt();
        }
    }

    /**
     * 选择区
     */
    public void show() {
        System.out.println("--------------------------------------");
        System.out.println("---欢迎来到六组小超市后台管理系统----");
        System.out.println("--------------------------------------");
        while (true) {
            menu();
            System.out.print("请选择您想使用的功能:");
            if (!input.hasNextInt()) {
                System.out.println("输入有误！系统退出");
                System.exit(0);
            }
            int select = input.nextInt();
            switch (select) {
                case 1:
                    int adminlogin = manageView.adminlogin();
                    if (adminlogin == 1) {
                        ko:
                        while (true){
                        System.out.println("1:添加员工信息 2:查看员工信息 3:修改员工信息 4 查看某员工信息 5 开除员工 6: 查看指定页员工信息1");
                        int u = input.nextInt();
                        switch (u) {
                            case 1:
                                manageView.addemp();
                                exit();
                                break;
                            case 2:
                                manageView.showallemp();
                                exit();
                                break;
                            case 3:
                                manageView.updateemp();
                                exit();
                                break;
                            case 4:
                                manageView.showemp();
                                exit();
                                break;
                            case 5:
                                manageView.delemp();
                                exit();
                                break;
                            case 6:
                                manageView.limitemp();
                                exit();
                                break;
                            case 7:
                                break ko;
                                default:
                                    System.out.println("输入有误");
                                    exit();
                                    break;
                        }
                        }
                    } else if (adminlogin == 0) {
                        System.out.println("1:商品管理 2:商品详情管理 3:商品库存管理");
                        int m = input.nextInt();
                        if (m == 1) {
                            ok:
                            while (true){
                            System.out.println("你正在管理商品");
                            System.out.println("1:查看商品 2:修改商品 3:删除商品 4 查看所有个 5查看指定页  6:添加商品");
                            int g = input.nextInt();
                            switch (g) {
                                case 1:
                                    goodsView.showgoods();
                                    exit();
                                    break;
                                case 2:
                                    goodsView.updategoods();
                                    break;
                                case 3:
                                    goodsView.delgoods();
                                    exit();
                                    break;
                                case 4:
                                    goodsView.showsgoods();
                                    exit();
                                    break;
                                case 5:
                                    goodsView.limitgoods();
                                    exit();
                                    break;
                                case 6:
                                    goodsView.addgoods();
                                    exit();
                                    break;
                                case 7:
                                    break ok;
                                    default:
                                        System.out.println("输入异常");
                                        exit();
                                        break ;
                            }}
                        } else if (m == 2) {
                            ok:
                            for (;;){
                            System.out.println("你正在管理商品详情");
                            System.out.println("1:查看详情 2:删除详情 3:查看指定页 4 修改详情 5 添加详情 ");
                            int p = input.nextInt();
                            switch (p) {
                                case 1:
                                    particularsView.particshow();
                                    exit();
                                    break;
                                case 2:
                                    particularsView.particdel();
                                    exit();
                                    break;
                                case 3:
                                    particularsView.limitpartic();
                                    exit();
                                    break;
                                case 4:
                                    particularsView.particupdate();
                                    exit();
                                    break;
                                case 5:
                                    particularsView.particadd();
                                    exit();
                                    break;
                                case 6:
                                    break ok;
                                    default:
                                        System.out.println("输入异常");
                                        exit();
                                        break ;
                            }
                            }
                        } else if (m == 3) {
                            System.out.println("你正在管理仓库");
                            ok:
                            while (true) {
                                System.out.println("1:查看库存 2:更新库存 3:查看库存 4 出库 5 入库 6: 查看指定页");
                                int r = input.nextInt();
                                switch (r) {
                                    case 1:
                                        repertoryView.repertoryallshows();
                                        exit();
                                        break;
                                    case 2:
                                        repertoryView.repertoryup();
                                        exit();
                                        break;
                                    case 3:
                                        repertoryView.repertoryshow();
                                        exit();
                                        break;
                                    case 4:
                                        repertoryView.repertorydel();
                                        exit();
                                        break;
                                    case 5:
                                        repertoryView.repertoryadd();
                                        break;
                                    case 6:
                                        repertoryView.limitrepertory();
                                        exit();
                                        break;
                                    case 7:
                                        break ok;
                                    default:
                                        System.out.println("输入异常");
                                        exit();
                                        break;
                                }

                            }
                        } else {
                            System.out.println("输入有误");
                        }

                        exit();
                        break;

                    }
                case 9:
                    if (select == 9) {
                        System.out.println("拜拜,欢迎下次光临");
                        System.exit(0);
                        break;
                    }
            }
        }

    }

}
