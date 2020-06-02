<%--
  Created by IntelliJ IDEA.
  User: snowflake
  Date: 2020/5/18
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.Arrays" language="java" %>
<html>
<head>
    <title>注册接收界面</title>
</head>
<body>
<%
    // 获取到用户名
    String name = request.getParameter("username");
    // 获取到密码
    String password = request.getParameter("password");
    // 获取到院校地区名
    String universityLocation = request.getParameter("university-location");
    // 获取到年纪
    String nj = request.getParameter("nj");
    // 获取到社团
    String[] sts = request.getParameterValues("st");
    // 获取到说明
    String description = request.getParameter("extra");


    out.println("名称：" + name + "<br>");
    out.println("密码：" + password + "<br>");
    out.println("地区：" + universityLocation + "<br>");
    out.println("年纪：" + nj + "<br>");
    out.println("社团：" + Arrays.toString(sts) + "<br>");
    out.println("说明：" + description + "<br>");
%>
</body>
</html>
