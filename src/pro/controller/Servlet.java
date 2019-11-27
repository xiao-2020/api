package pro.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.lang.Class;
import util.Test;
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
  public void enterRequest(HttpServletRequest request, HttpServletResponse response) {
    // 获取请求地址
    String uri = request.getRequestURI();
    /**
     * 抽离具体的url  根据 url 找到对应的不同的类类型
     *
     */
    String action = uri.substring(5);
    // 处理成首字母大写
    String actions = DealString.CapitalInitials(action); // Test
    System.out.println(actions);
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
  }
  
  public void enterPostRequest(HttpServletRequest request, HttpServletResponse response) {
  
  }
}
