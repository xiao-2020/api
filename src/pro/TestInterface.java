package pro;

import java.lang.reflect.Method;

public interface TestInterface {
  public static void doAction() {
    try {
      Method method = TestInterface.class.getMethod("test");
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
  }
  
}
