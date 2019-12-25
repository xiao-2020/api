package pro.actions.shop;

import pro.controller.Request;

public class User implements ActionsClassInterface {
  private Request request;
  @Override
  public void doAction( Request request ) {
    this.request = request;
    String methodName = request.getSubActionName();
    ActionsClassInterface.callMethod(User.class, methodName);
  }
  
  public void login() {
  }
  
  public void loginout() {
  }
}
