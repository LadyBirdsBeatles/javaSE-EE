<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
    <a href="admin/index.html">登陆</a>
  <%for (int i=0;i<10;i++){%>
  <div style="background-color: pink;width: 50px;height: 50px;line-height: 50px;margin: 2px auto;text-align: center "><%out.print(i);%></div>
  <%}%><%out.println("\t");%>
  </body>
</html>