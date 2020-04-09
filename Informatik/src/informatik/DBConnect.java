package informatik;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

class DBConnect{
  public static void main(String[] args) {
    Connection conn = null;
    
    try {
      String url = "jdbc:sqlite:F:/NetBeansProjects/Informatik/db/informatik.db";
      conn = DriverManager.getConnection(url);
      
      Statement stmt = null;
      String query = "INSERT INTO Konto (KontoID) VALUES (1)";
      try {
          stmt = conn.createStatement();
          ResultSet rs = stmt.executeQuery(query);
          while (rs.next()) {
              String name = rs.getString("");
              System.out.println(rs);
          }
      } catch (SQLException e ) {
          throw new Error("Problem", e);
      } finally {
          if (stmt != null) { stmt.close(); }
      }

    } catch (SQLException e) {
        throw new Error("Problem", e);
    } finally {
      try {
        if (conn != null) {
            conn.close();
        }
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      }
    }
  }
}


