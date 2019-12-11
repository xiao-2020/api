package pro.controller;

import javax.servlet.http.HttpServletRequest;

import util.DealString;

import java.io.UnsupportedEncodingException;

public class Request {
  
  private String actionName;
  
  private String subActionName;

  /*
   *  @param {request} 传入请求对象
   * */
  public Request( HttpServletRequest request ) {
    try {
      request.setCharacterEncoding("utf-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    // 1、 处理url
    String url = request.getRequestURI();
    System.out.println(url);
    dealUrl(url);
    // 2、 处理session
    
    // 3、 处理请求体  处理json
  }
  
  private void dealUrl( String url ) {
    String validUrl = url.replaceAll("/api/|\\.*", "");
    String[] urlArr = validUrl.split("/", 2);
    // 存入 url 对应的 行为类名 和 子方法名
    System.out.println(urlArr[0]);
    System.out.println(urlArr[1]);
    this.setActionName(DealString.CapitalInitials(urlArr[0]));
    this.setSubActionName(DealString.CapitalInitials(urlArr[1]));
  }
  
  public String getActionName() {
    return actionName;
  }
  
  public void setActionName( String actionName ) {
    this.actionName = actionName;
  }
  
  public String getSubActionName() {
    return subActionName;
  }
  
  public void setSubActionName( String subActionName ) {
    this.subActionName = subActionName;
  }
}
