package pro.actions.shop;


import pro.controller.Request;

public interface ActionsClassInterface {
  public void doAction( Request request );

  public static void doSth() {
    System.out.println("do Sth");
  };
}
