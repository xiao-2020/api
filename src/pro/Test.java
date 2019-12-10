package pro;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test implements TestInterface {
  public static void doAction() {
    try {
      Method method = Test.class.getMethod("test");
      try {
        method.invoke(Test.class.getDeclaredConstructor().newInstance());
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      } catch (InvocationTargetException e) {
        e.printStackTrace();
      } catch (InstantiationException e) {
        e.printStackTrace();
      }
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
  }
  
  public static void main( String[] args ) {
    Test.doAction();
  }
  
  
  public void test() {
    System.out.println("Test OK");
  }
}

