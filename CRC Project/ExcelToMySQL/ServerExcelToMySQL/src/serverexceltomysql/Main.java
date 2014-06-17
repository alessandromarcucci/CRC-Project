/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package serverexceltomysql;
import java.sql.*;
import java.util.*;

/**
 *
 * @author alessandro marcucci
 */
public class Main {

    //private static Connection conn;
    //public static Connection getConnessione(){
      //  return conn;
   // }
    /*public static String avvia(){
        String risposta="";
        System.out.println("avvio connessione");
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn=DriverManager.getConnection(dbUrl, user, password);
            System.out.println("connessione database stabilita");
        }
        catch(ClassNotFoundException e){
            risposta="driver non trovato";
            return risposta;

        }
        catch(SQLException e){
            risposta="Ã¨ stata rilevata:"+ e.getMessage();

        }

        System.out.println(risposta);

        return risposta;
    }*/

  public class Preleva{
        String dbUrl = "jdbc:odbc:people";
        String user = "";
        String password = "";

        // Load the driver (registers itself)
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection c = DriverManager.getConnection(dbUrl, user, password);
        Statement s = c.createStatement();
        // SQL code:
        ResultSet r = s.executeQuery("SELECT FIRST, LAST, EMAIL " + "FROM people.csv people " + "WHERE " + "LAST=" + args[0] + '"));

        while(r.next()) {
        // Capitalization doesn't matter:
        System.out.println(r.getString("Last") + ", "+ r.getString("fIRST")+ ": " + r.getString("EMAIL") );
        }
  s.close(); // Also closes ResultSet
 }
    }

}
