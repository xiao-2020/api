package pro.controller;

import pro.actions.shop.ActionsClassInterface;
import util.DealString;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet extends HttpServlet {

    public Servlet() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        filter();
        enterRequest(request, response);
    }

    // 拦截器
    public void filter() {

    }


    // 入口方法
    public void enterRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        // 获取请求地址
        String uri = request.getRequestURI();
        /**
         * 抽离具体的url  根据 url 找到对应的不同的类类型
         *
         */
        System.out.println(uri);
        String action = uri.substring(5);
        // 处理成首字母大写
        String actions = DealString.CapitalInitials(action);
        System.out.println("跳转类名：" + actions);
        try {
            // 获取包下的类
            Class actionClass = Class.forName(String.format("pro.actions.shop.%s", actions));
            // 实例动态类
            ActionsClassInterface newInstance = (ActionsClassInterface) actionClass.getDeclaredConstructor().newInstance();
            // 调用动态类的入口方法
            newInstance.doAction(request);
        } catch (Exception e) {
            throw new RuntimeException("动态获取类失败：" + action, e);
        }
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("aaa");
    }

}
