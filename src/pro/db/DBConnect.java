package pro.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnect {
  public static final String url = "jdbc:mysql://127.0.0.1:3306/user";
  public static final String name = "com.mysql.jdbc.Driver";
  public static final String user = "root";
  public static final String password = "abc123";
  
  private Connection connection = null;
  
  private PreparedStatement pst = null;
  
  
  public DBConnect(String sql) {
    try {
      // 指定链接类型
      Class.forName(name);
      connection = DriverManager.getConnection(url, name, password); // 链接数据
      pst = connection.prepareStatement(sql);
    } catch (Exception e) {
      throw new RuntimeException("链接数据库失败！", e);
    }
  }
  
  public void close() {
    try {
      this.connection.close();
      this.pst.close();
    } catch (Exception e) {
      throw new RuntimeException("关闭失败", e);
    }
  }
}
