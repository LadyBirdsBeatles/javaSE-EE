package com.xiaochen.goodsmanager.Servlet;
import com.xiaochen.goodsmanager.entity.Admin;
import com.xiaochen.goodsmanager.service.GoodsServiceDaoimpl.ManageServiceDaoimpl;
import com.xiaochen.goodsmanager.service.ManageServiceDao;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "AdminServlet" ,urlPatterns = {"/admin"})
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        System.out.println(username + pwd);
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        Admin admin = new Admin();
        admin.setAccount(username);
        admin.setPwd(pwd);
        Cookie cookie = new Cookie("uname", "pwd");
        cookie.setMaxAge(10);
        ManageServiceDao manageServiceDao = new ManageServiceDaoimpl();
        PrintWriter pw = response.getWriter();
        try {
            int adminlogin = manageServiceDao.adminlogin(admin);
            if (adminlogin == 1) {
                pw.print("{\"status\":\"true\"}");
                request.setAttribute("name",username);
                request.setAttribute("pwd",pwd);
                response.sendRedirect("/rgister");
                Cookie[] cookies = request.getCookies();
                request.setAttribute("cookies",cookies);
                HttpSession session = request.getSession(true);
                System.out.println(session);
                //request.getRequestDispatcher("/rgister").forward(request,response);
                System.out.println("登陆成功:你的身份是**超级管理员**你可以管理员工");
            } else if (adminlogin == 0) {
                System.out.println("登陆成功:你的身份是**管理员**只能管理商品");
                pw.print("{\"status\":\"true\"}");
                this.getServletContext().setAttribute("name",username);
                this.getServletContext().setAttribute("pwd",pwd);
                response.sendRedirect("/rgister");
               // request.getRequestDispatcher("/rgister").forward(request,response);
               // this.getServletContext().getRequestDispatcher("/rgister").forward(request,response);
            } else {
                pw.print("{\"status\":\"false\"}");
                System.out.println("请检查用户名或密码");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        pw.flush();
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request,response);
    }
}
