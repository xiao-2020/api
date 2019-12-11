package pro;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test implements TestInterface {
  
  public static void main( String[] args ) {
    TestInterface.doAction(Test.class);
  }
  
  
  public void test() {
    System.out.println("Test OK");
  }
}

