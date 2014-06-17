/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package serverETOM;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Alessandro Marcucci
 */
public class Main {


    private static Connection conn;
    public static Connection getConnessione(){
        return conn;
    }
    public static String avvia(){
        String risposta="";
        System.out.println("avvio connessione");
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Excel Driver (*.xls)};DBQ = C:\\desktop\\diagnosi.xls");
            System.out.println("connessione database stabilita");
            
        }
        catch(ClassNotFoundException e){
            risposta="driver non trovato";
            return risposta;
                
        }
        catch(SQLException e){
            risposta="è stata rilevata:"+ e.getMessage();
            
        }
        System.out.println(risposta);
        return risposta;
    }

    public Vector getCatchBirthdate() throws SQLException{
        String errore = avvia();
        Statement s = conn.createStatement();
        String query = "SELECT * FROM [diagnosi].B";
        String app = "";
        Vector ris = new Vector();

        ResultSet r = s.executeQuery(query);
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(query);
           while (rs.next()) {
                     app = rs.getString("Birthdate");
                     ris.add(app);
           }
           st.close();
           conn.close();
            }
        catch(Exception ec)
            {
                ec.printStackTrace();
                StringBuilder temp=new StringBuilder();
                temp.append("errore/n");
                temp.append(ec.getMessage());
                System.out.println("L'errore ÃƒÂ¨"+ec.getMessage());
            }
      }
      return ris;
      }
}

   


