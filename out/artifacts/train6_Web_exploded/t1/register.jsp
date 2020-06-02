<%--
  Created by IntelliJ IDEA.
  User: snowflake
  Date: 2020/6/2
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<div>
    <form method="post" action="/t1/register-info.jsp">
        <table border="0" align="center">
            <tr>
                <td>用户姓名：</td>
                <td><input type="text" name="name" style="width:250px;"/></td>
            </tr>
            <tr>
                <td>博客地址：</td>
                <td><input type="url" name="blog" style="width:250px;"/></td>
            </tr>
            <tr>
                <td>兴趣爱好：</td>
                <td>
                    <input type="checkbox" name="interests" value="足球"/>足球
                    <input type="checkbox" name="interests" value="篮球"/>篮球
                    <input type="checkbox" name="interests" value="羽毛球"/>羽毛球
                    <input type="checkbox" name="interests" value="乒乓球"/>乒乓球
                </td>
            </tr>
            <!-- 以下是提交、取消按钮 -->
            <tr>
                <td>
                    <input type="submit" value="提交"/>
                </td>
                <td>
                    <input type="reset" value="取消"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
