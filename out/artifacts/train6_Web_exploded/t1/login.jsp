<%--
  Created by IntelliJ IDEA.
  User: snowflake
  Date: 2020/6/2
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>
    <style>
        label {
            display: inline-block;
            width: 200px;
            text-align: right;
        }
    </style>
</head>
<body>
    <div>
        <form action="/t1/login-action.jsp">
            <label for="username">用户名：</label>
            <input type="text" name="username" id="username" placeholder="请输入用户名">
            <br>
            <label for="password">密码：</label>
            <input type="password" name="password" id="password" placeholder="请输入密码">
            <br>
            <label></label>
            <input type="submit" value="登陆">
        </form>
    </div>
</body>
</html>
