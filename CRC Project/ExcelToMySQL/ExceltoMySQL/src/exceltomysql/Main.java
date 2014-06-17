/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exceltomysql;
import java.sql.*;
import java.util.*;
/**
 *
 * @author alessandro marcucci
 */
public class Main {

        public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String DBUrl = "jdbc:odbc:diagnosi";
        String user = "";
        String password = "";
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection c = DriverManager.getConnection(DBUrl, user, password);
        Statement s = c.createStatement();

        ResultSet rs = s.executeQuery("SELECT * FROM diagnosi.csv foglio1");
        while (rs.next()){
            System.out.println(rs.getString("nome"));
        }

        
    }

}
