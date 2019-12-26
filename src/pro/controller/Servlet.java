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
  
  
  @Override
  protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    System.out.println("doGet");
    doPost(request, response);
  }
  
  @Override
  protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    System.out.println("doPost");
    
    // 处理请求对象
    Request Request = new Request(request);
    // entry
    enterRequest(Request, response);
  }
  
  // 入口方法
  public void enterRequest( Request request, HttpServletResponse response ) throws IOException {
    response.setCharacterEncoding("utf-8");
    String actions = request.getActionName();
    try {
      // 获取包下的类
      Class actionClass = Class.forName(String.format("pro.actions.shop.%s", actions));
      // 实例动态类
      ActionsClassInterface newInstance = (ActionsClassInterface) actionClass.getDeclaredConstructor().newInstance();
      // 调用动态类的入口方法
      newInstance.doAction(request);
    } catch (Exception e) {
      throw new RuntimeException("动态获取类失败：" + actions, e);
    }
//    response.setContentType("text/html;charset=utf-8");
//    PrintWriter out = response.getWriter();
//    out.println("aaa");
  }
  
}
