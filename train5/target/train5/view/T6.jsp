<%--
  Created by IntelliJ IDEA.
  User: snowflake
  Date: 2020/5/18
  Time: 0:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人所得税</title>
    <style>
        .label {
            text-align: center;
        }

        .button {
            margin: 0 auto;
            display: flex;
        }

        .button input {
            flex: 1;
        }
    </style>
</head>
<body>
<%!
    public double calculate(int shouru, int sdsze) {
        return (shouru + sdsze) * 0.3;
    }
%>
<%
    // 获取到 收入
    String shouruStr = request.getParameter("month-comein");
    String sdszeStr = request.getParameter("sdsze");

    if (shouruStr == null || "".equals(shouruStr))
        request.setAttribute("result", 0.0);
    if (sdszeStr == null || "".equals(sdszeStr))
        request.setAttribute("result", 0.0);

    // 强转
    try {
        int shouru = Integer.parseInt(shouruStr);
        int sdsze = Integer.parseInt(sdszeStr);
        request.setAttribute("result", calculate(shouru, sdsze)) ;
        request.setAttribute("shouru", shouru);
        request.setAttribute("sdsze", sdsze);
    } catch (Exception e) {
        request.setAttribute("result", 0.0);
    }
%>

<form id="form" action="T6.jsp">
    <table border="1" cellspacing="0">
        <thead>
        <tr>
            <td colspan="2" class="label">个人所得税计算器</td>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>请输入你的月收入</td>
            <td>
                <label for="month-comein"></label>
                <input id="month-comein" name="month-comein" type="number" value="<%=request.getAttribute("shouru")%>">
            </td>
        </tr>
        <tr>
            <td>请输入所得税增额</td>
            <td><input name="sdsze" type="number" value="<%=request.getAttribute("sdsze")%>"></td>
        </tr>
        <tr>
            <td>所得税</td>
            <td><input name="sds" type="number" value="<%=request.getAttribute("result")%>"></td>
        </tr>
        <tr>
            <td colspan="2">
                <div class="button">
                    <input type="submit" value="计算">
                    <input type="button" value="重置" onclick="reset()">
                </div>
            </td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>
