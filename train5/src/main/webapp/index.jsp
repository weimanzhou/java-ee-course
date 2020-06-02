<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<h2>Hello World!</h2>
<%!
    public int fib(int n) {
        int s = 1;
        for (int i = 2; i <= n; i++)
            s *= i;
        return s;
    }
%>
<%
    for (int n = 1; n <= 10; n++) {
        out.print(n + "!=" + fib(n) + "<br>");
        out.flush();
    }
%>
</body>
