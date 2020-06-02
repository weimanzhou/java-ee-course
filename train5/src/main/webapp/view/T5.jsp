<%--
  Created by IntelliJ IDEA.
  User: snowflake
  Date: 2020/5/18
  Time: 0:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物简易计算器</title>
</head>
<body>
<form action="/calculate" method="get">
    <h2>购物简易计算器</h2>
    <label for="num1">数一</label>
    <input id="num1" name="num1" type="number" placeholder="请输入第一个数">
    <label for="num2">数二</label>
    <input id="num2" name="num2" type="number" placeholder="请输入第二个数">
    <label for="+">+</label>
    <input type="radio" id="+" name="operation" value="+" onclick="calculate('+')">
    <label for="-">-</label>
    <input type="radio" id="-" name="operation" value="-" onclick="calculate('-')">
    <label for="*">*</label>
    <input type="radio" id="*" name="operation" value="*" onclick="calculate('*')">
    <label for="/">/</label>
    <input type="radio" id="/" name="operation" value="/" onclick="calculate('/')">
    <label for="calculate-result">计算结果</label>
    <input id="calculate-result" type="text">
    <input type="submit" value="提交">
</form>
</body>
</html>
