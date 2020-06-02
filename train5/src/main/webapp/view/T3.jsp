<%--
  Created by IntelliJ IDEA.
  User: snowflake
  Date: 2020/5/17
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%!
        public void fib(int n) {
            int s = 1;
            for (int i = 2; i <= n; i++)
            s *= i;
            return s;
        }

        for (int n = 1; n <= 10; n++)
            out.println(n + "!=" + fib(n));
            out.flush();
    %>
</body>
</html>
