package xyz.snowflake.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author snowflake
 * @version v1.0
 * @package xyz.snowflake.controller
 * @title CalculateController
 * @description
 * @date 2020/5/18 - 0:21
 */
@WebServlet(name = "calculateController", urlPatterns = "/calculate")
public class CalculateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取到 num1 和 num2
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        String type = req.getParameter("operation");

        // 强转
        int number1 = Integer.parseInt(num1);
        int number2 = Integer.parseInt(num2);

        double result = 0.0;
        switch (type) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                if (number2 == 0) {
                    resp.getOutputStream().print("结果出错");
                    return;
                } else {
                    result = number1 * 1.0 / number2;
                }
                break;
            default:
                resp.getOutputStream().print("结果出错");
                return;
        }
        resp.getOutputStream().print(result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
