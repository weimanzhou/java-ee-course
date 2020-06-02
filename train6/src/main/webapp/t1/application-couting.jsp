<%--
  Created by IntelliJ IDEA.
  User: snowflake
  Date: 2020/6/2
  Time: 9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>网站计数器</title>
</head>
<body>
    <%
        Object countOBJ = application.getAttribute("counting");
        int count = 1;
        if (countOBJ == null) {
            application.setAttribute("counting", 1);
        } else {
            count = Integer.parseInt(countOBJ + "") + 1;
            application.setAttribute("counting", count);
        }

        out.println("你是第" + count + "位访问者");
    %>
</body>
</html>
