package pro.actions.shop;


import pro.controller.Request;

import java.lang.reflect.Method;

public interface ActionsClassInterface {
  void doAction( Request request );
  
  static void callMethod( Class cls, String methodName ) {
    try {
      Method method = cls.getMethod(methodName);
      Object instance = cls.getDeclaredConstructor().newInstance();
      method.invoke(instance);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
