package util;

public class DealString {
  public static String CapitalInitials(String string) {
    return string.substring(0, 1).toUpperCase() + string.substring(1);
  }
}
