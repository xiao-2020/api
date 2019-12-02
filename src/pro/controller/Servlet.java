package pro.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Class;
import java.util.Enumeration;

import util.DealString;
import util.ActionsClassInterface;
public class Servlet extends HttpServlet {
  
  public Servlet () {}
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    filter();
    enterRequest(request, response);
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
    // 获取请求地址
    String uri = request.getRequestURI();
  
    /**
     * 抽离具体的url  根据 url 找到对应的不同的类类型
     *
     */
    System.out.println(uri);
    System.out.println(request.getParameter("a"));
    String action = uri.substring(5);
    // 处理成首字母大写
    String actions = DealString.CapitalInitials(action); // Test
    System.out.println("跳转类名：" + actions);
    try {
      // 获取包下的类
      Class _class = Class.forName(String.format("pro.actions.shop.%s", actions));
      // 实例动态类
      ActionsClassInterface newInstance = (ActionsClassInterface) _class.getDeclaredConstructor().newInstance();
      // 调用动态类的入口方法
      newInstance.doAction(request);
    } catch (Exception e) {
      e.printStackTrace();
    }
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();
    out.println("aaa");
  
  }

}
