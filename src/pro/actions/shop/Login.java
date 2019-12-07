package pro.actions.shop;

import javax.servlet.http.HttpServletRequest;

public class Login implements ActionsClassInterface {
  @Override
  public void doAction(HttpServletRequest request) {
    Object data = request.getParameter("data");
    System.out.println(data);
    System.out.println("data");
  }
}

