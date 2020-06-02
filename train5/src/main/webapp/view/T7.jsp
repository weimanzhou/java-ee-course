<%--
  Created by IntelliJ IDEA.
  User: snowflake
  Date: 2020/5/18
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <form action="T7-2.jsp" method="get">
        <label for="student-name">同学名</label>
        <input id="student-name" type="text" name="username" placeholder="请输入姓名"><br>
        <label for="password">密码</label>
        <input id="password" type="password" name="password" placeholder="请输入密码"><br>
        院校地名：
        <label for="n">北校区</label>
        <input id="n" type="radio" name="university-location" value="北校区">
        <label for="s">南校区</label>
        <input id="s" type="radio" name="university-location" value="南校区">
        <label for="e">北校区</label>
        <input id="e" type="radio" name="university-location" value="东校区">
        <br>
        <label for="nj">年纪</label>
        <select name="nj" id="nj">
            <option value="大一">大一</option>
            <option value="大二">大二</option>
            <option value="大三">大三</option>
            <option value="大四">大四</option>
        </select>
        <br>
        社团：
        <label for="wd">舞蹈</label>
        <input type="checkbox" name="st" id="wd" value="舞蹈">
        <label for="sy">摄影</label>
        <input type="checkbox" name="st" id="sy" value="摄影">
        <label for="lq">篮球</label>
        <input type="checkbox" name="st" id="lq" value="篮球">
        <br>
        <label for="extra">说明：</label>
        <textarea name="extra" id="extra" cols="30" rows="10"></textarea>
        <br>
        <input type="submit" value="保存">
        <input type="button" value="退出" onclick="reset()">
    </form>
</body>
</html>
