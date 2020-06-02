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
</head>
<body>
<div>
    <%
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("username".equals(username) && "password".equals(password)) {
            request.getRequestDispatcher("/t1/login-success.jsp").forward(request, response);
        }
    %>
</div>
</body>
</html>
