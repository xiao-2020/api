package pro.actions.shop;

import pro.controller.Request;

public class Goods implements ActionsClassInterface {
  @Override
  public void doAction( Request request ) {
    String methodName = request.getSubActionName();
    ActionsClassInterface.callMethod(Goods.class, methodName);
  }
  
  public void read() {
    System.out.println("Goods Add");
  }
  
  public void update() {
    System.out.println("Goods update");
  }
}

