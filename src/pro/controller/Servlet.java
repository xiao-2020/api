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

import util.Test;
import util.DealString;
public class Servlet extends HttpServlet {
  
  public Servlet () {}
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    filter();
    enterGetRequest(request, response);
  }
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    filter();
    enterGetRequest(request, response);
  }
  // 拦截器
  public void filter() {
  
  }
  // 入口方法
  public void enterGetRequest(HttpServletRequest request, HttpServletResponse response) {
    // 获取请求地址
    String uri = request.getRequestURI();
    String test = uri.substring(5);
    String tt = DealString.CapitalInitials(test);
  
    Test.doActions();
    
  }
  
  public void enterPostRequest(HttpServletRequest request, HttpServletResponse response) {
  
  }
  public void dispatchServlet() {
  
  }
}
