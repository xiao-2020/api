package pro.actions.shop;

import pro.controller.Request;

public class User implements ActionsClassInterface {
  @Override
  public void doAction( Request request ) {
    System.out.println("User doAction");
    String methodName = request.getSubActionName();
    ActionsClassInterface.callMethod(User.class, methodName);
  }
  
  public void login() {
    System.out.println("user login");
  }
  
  public void loginout() {
    System.out.println("user loginout");
  }
}
