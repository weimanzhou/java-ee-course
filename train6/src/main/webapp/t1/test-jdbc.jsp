<%@ page import="xyz.snowflake.Customer" %>
<%@ page import="xyz.snowflake.dao.CustomerDao" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: snowflake
  Date: 2020/6/2
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试JDBC</title>
</head>
<body>
<%
    CustomerDao dao = new CustomerDao();
    String editid = "";
    String opttype = request.getParameter("opttype");
    if ("delete".equals(opttype)) {
        String cid = request.getParameter("cid");
        if (cid != null) {
            dao.deleteByCid(cid);
        }
    }
    if ("update".equals(opttype)) {
        String cid = request.getParameter("cid");
        String cname = request.getParameter("cname");
        String cphone = request.getParameter("cphone");
        if (cid != null) {
            Customer cus = new Customer();
            cus.setCustomerId(cid);
            cus.setName(cname);
            cus.setPhone(cphone);
            dao.updateCustomer(cus);
        }
    }
    if ("edit".equals(opttype)) {
        editid = request.getParameter("cid");
    }
    List<Customer> clist = dao.findAll();
%>

<center>
    <table width="60%" border="1">
        <%
            for (Customer cus : clist) {
                out.println("<tr>");
                if (!cus.getCustomerId().equals(editid)) {
                    out.println("<td>" + cus.getCustomerId() + "</td>");
                    out.println("<td>" + cus.getName() + "</td>");
                    out.println("<td>" + cus.getPhone() + "</td>");
                    out.println("<td><a href='customer.jsp?opttype=delete&cid=" + cus.getCustomerId() + "'>Delete</a>");
                    out.println("<a href='customer.jsp?opttype=edit&cid=" + cus.getCustomerId() + "'>Edit</a></td>");
                } else {
                    out.println("<form action='customer.jsp' method=post>");
                    out.println("<input type='hidden' name='opttype' value='update' >");
                    out.println("<input type='hidden' name='cid' value='" + cus.getCustomerId() + "' >");

                    out.println("<td>" + cus.getCustomerId() + "</td>");
                    out.println("<td><input type='text' name='cname' value='" + cus.getName() + "'></td>");
                    out.println("<td><input type='text' name='cphone' value='" + cus.getPhone() + "'></td>");
                    out.println("<td><input type='submit' value='确定'>");
                    out.println("<input type=reset value='取消'></td>");
                    out.println("</form>");
                }
                out.println("</tr>");
            }
        %>
    </table>
</center>
</body>
</html>
