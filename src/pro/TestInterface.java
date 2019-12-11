package pro;

import java.lang.reflect.Method;

public interface TestInterface {
  public static void doAction( Class _class ) {
    try {
      Method method = _class.getMethod("test");
      Object cls = _class.getDeclaredConstructor().newInstance();
      method.invoke(cls);
    } catch (Exception e) {
      throw new RuntimeException("Wrong", e);
    }
  }
  
}
