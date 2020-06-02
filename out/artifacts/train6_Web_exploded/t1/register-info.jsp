<%--
  Created by IntelliJ IDEA.
  User: snowflake
  Date: 2020/6/2
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");       //设置请求编码
    String name = request.getParameter("name");  //获取用户名
    String blog = request.getParameter("blog");  //获取博客地址

    //获取兴趣爱好
    String[] interests = request.getParameterValues("interests");
    String interStr = "";
    if (interests != null) {
        for (String item : interests) {
            interStr += item + ";";
        }
    }
%>
<html>
<head>
    <title>注册信息</title>
</head>
<body>
    用户姓名：<%= name %><br/>
    博客地址：<%= blog %><br/>
    兴趣爱好：<%= interStr %>
</body>
</html>
