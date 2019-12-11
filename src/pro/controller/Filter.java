package pro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Filter {
  public Filter( HttpServletRequest request ) {
    HttpSession session = request.getSession();
    System.out.println(session.isNew());
  }
}
