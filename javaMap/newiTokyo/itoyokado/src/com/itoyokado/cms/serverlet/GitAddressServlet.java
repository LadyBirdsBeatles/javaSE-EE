package com.itoyokado.cms.serverlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "AddressServlet",urlPatterns = {"/sendAddress"})
public class GitAddressServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String address = request.getParameter("Address");
        String scope = request.getParameter("Scope");
        System.out.println(address);
        System.out.println(scope);
        request.getRequestDispatcher("/SysUserServlet").forward(request, response);
        String flag = null;
        PrintWriter writer = response.getWriter();
        if (address.equals(null)&&scope.equals(null)) {
            flag = "FALL";
        } else {

            flag = "SUCCESS";
        }
        writer.print("{\"flag\":\"" + flag + "\"}");
        writer.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
