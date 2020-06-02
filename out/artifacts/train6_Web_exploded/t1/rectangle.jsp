<%--
  Created by IntelliJ IDEA.
  User: snowflake
  Date: 2020/6/2
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>矩形</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    String w = request.getParameter("w");
    String h = request.getParameter("h");
    if (w != null && h != null) {
        out.println("area=" + Integer.parseInt(w) * Integer.parseInt(h));
    }
//    Rectangle rectangle = new Rectangle();
//    if (w != null && h != null) {
//        rectangle.setWidth(Integer.parseInt(w));
//        rectangle.setHeight(Integer.parseInt(h));
//        out.println("area=" + rectangle.getArea());
//    }
%>
<form action="/t1/rectangle.jsp">
    <label for="w">长=</label>
    <input type="text" name="w" id="w">
    <label for="h">宽=</label>
    <input type="text" name="h" id="h">
    <input type=submit value="提交">
</form>
</body>
</html>
