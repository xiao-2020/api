package pro.controller;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import pro.util.DealString;

import java.io.*;

public class Request {

  private String actionName;

  private String subActionName;

  /*
   *  @param {request} 传入请求对象
   * */
  public Request(HttpServletRequest request) {
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

    BufferedReader br = null;
    try {
      br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF8"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    String line = null;
    StringBuilder sb = new StringBuilder();

    try {
      while ((line = br.readLine()) != null) {
        sb.append(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

//    Object obj = JSON.parse(sb.toString());
    JSONObject obj = JSONObject.parseObject(sb.toString());
    JSONObject obj1 = obj.getJSONObject("data");
    System.out.println(obj1);
    
  }

  private void dealUrl(String url) {
    String validUrl = url.replaceAll("/api/|\\.htm", "");
    String[] urlArr = validUrl.split("/", 2);
    // 存入 url 对应的 行为类名 和 子方法名
    this.setActionName(DealString.CapitalInitials(urlArr[0]));
    this.setSubActionName(urlArr[1]);
  }

  public String getActionName() {
    return actionName;
  }

  public void setActionName(String actionName) {
    this.actionName = actionName;
  }

  public String getSubActionName() {
    return subActionName;
  }

  public void setSubActionName(String subActionName) {
    this.subActionName = subActionName;
  }
}
