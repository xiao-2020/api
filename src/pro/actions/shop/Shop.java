package pro.actions.shop;

import pro.controller.Request;


public class Shop implements ActionsClassInterface {
  
  @Override
  public void doAction( Request request ) {
    String methodName = request.getSubActionName();
    ActionsClassInterface.callMethod(Shop.class, methodName);
  }
  
  public void add() {
    System.out.println("Shop Add");
  }
  
  public void update() {
    System.out.println("Shop Update");
  }
}
