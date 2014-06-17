/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package serverCRC;

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
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/crc?user=root&password=adriano");
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

//Controlla se l'username e password inseriti sono corretti e se si è amministratore o utenti
    public static String VerificaUser(String username, String password){
        String Query="SELECT * FROM utenti WHERE username = '"+ username +"'AND passw = '"+ password +"'";
        String Querycheck="SELECT * FROM utenti WHERE username= '"+username + "'AND passw = '"+password +"'AND amministratore = '0'";
        String errore=avvia();
        String ob="";
        if (errore.equals("")){
            try{
                Statement st=getConnessione().createStatement();
                ResultSet rs=st.executeQuery(Query);
                rs.first();
                String temp1=rs.getString(1);
                if(temp1.equals("")){
                    ob="non trovato";
                }
                else{
                    ob="si";
                    System.out.println(ob);
                }
                Statement st1=getConnessione().createStatement();
                ResultSet rs1=st1.executeQuery(Querycheck);
                if(rs1.first()){
                    ob="U";
                }
                else{
                    ob="A";
                }
                System.out.println(ob);
                conn.close();
            }
            catch(Exception ec){
                ec.printStackTrace();
                StringBuilder temp=new StringBuilder();
                temp.append("errore/n");
                temp.append(ec.getMessage());
                System.out.println("L'errore è"+ec.getMessage());
                ob = temp.toString();
            }
        }
        System.out.println(ob);
        return ob;
    }
    
    public static String VerificaUserAd(String username){
        String errore=avvia();
       String sql  ="SELECT * FROM utenti WHERE username = '"+ username + "'";
       int c = 0;
       String s = "";
       if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           if (rs.first()){
                s = rs.getString("amministratore");
          }
            }
        catch(Exception ec)
            {
                ec.printStackTrace();
                StringBuilder temp=new StringBuilder();
                temp.append("errore/n");
                temp.append(ec.getMessage());
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
    c = Integer.valueOf(s);
    return s;
    }

    public static String VerificaUsername(String username){
        String Query="SELECT * FROM utenti WHERE username = '"+ username +"'";
        String Querycheck="SELECT * FROM utenti WHERE username= '"+username + "'AND amministratore = '0'";
        String errore=avvia();
        String ob="";
        
        if (errore.equals("")){
            try{
                Statement st=getConnessione().createStatement();
                ResultSet rs=st.executeQuery(Query);
                rs.first();
                String temp1=rs.getString(1);
                if(temp1.equals("")){
                    ob="non trovato";
                }
                else{
                    ob="si";
                    System.out.println(ob);
                }
                Statement st1=getConnessione().createStatement();
                ResultSet rs1=st1.executeQuery(Querycheck);
                if(rs1.first()){
                    ob="U";
                }
                else{
                    ob="A";
                }
                System.out.println(ob);
                conn.close();
            }
            catch(Exception ec){
                ec.printStackTrace();
                StringBuilder temp=new StringBuilder();
                temp.append("errore/n");
                temp.append(ec.getMessage());
                System.out.println("L'errore è"+ec.getMessage());
                ob = temp.toString();
            }
        }
        System.out.println(ob);
        return ob;
    }

    // Invia i dati per inserire un nuovo utente nel database
    public static String salvaUser(String codice ,String nome, String cognome, String data, String indirizzo, String mail, String username ,String password)
   {
        String query = "";
        query = "INSERT INTO utenti (cf , nome , cognome , data , indirizzo , mail , username , passw , amministratore) "
                    + "VALUES ('" + codice + "','" + nome + "','" + cognome + "','" + data + "','" + indirizzo + "','" + mail + "','" + username + "','" + password + "','0')";

        String errore=avvia();
        String ris = "no";


         if (errore.equals("")) {
                  try {
                        Statement st = getConnessione().createStatement();
                        int rs = st.executeUpdate(query);

                        st.close();
                        conn.close();
                        ris = "si";
                  } catch (SQLException e) {
                        System.out.println("Errore: " + e.getMessage());
                        return ris;
                  }
            }
            return ris;
      }
//Invia i dati per caricare i nomi dei libri
 public Vector getUser() throws SQLException
   {
        String SQL ="SELECT username FROM utenti WHERE amministratore = '0'";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("username");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
         return ris;
    }
 //Invia i dati per caricare i nomi dei libri
 public Vector getCode() throws SQLException
   {
        String SQL ="SELECT cf FROM utenti WHERE amministratore = '0'";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("cf");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

  public Vector getUserName() throws SQLException
   {
        String SQL ="SELECT nome FROM utenti WHERE amministratore = '0'";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("nome");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

   public Vector getUserSecondName() throws SQLException
   {
        String SQL ="SELECT cognome FROM utenti WHERE amministratore = '0'";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("cognome");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

    public Vector getUserDate() throws SQLException
   {
        String SQL ="SELECT data FROM utenti WHERE amministratore = '0'";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("data");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

 //Invia i dati del libro che dovrà essere cancellato
public static void deleteUser(String codice){

        String queryupdate = "DELETE FROM utenti WHERE cf= '"+ codice +"'";
        String errore=avvia();
         if (errore.equals("")) {
                  try {
                        Statement st = getConnessione().createStatement();
                        int rs = st.executeUpdate(queryupdate);
                                System.out.println("query cancella user");

                        st.close();
                        conn.close();
                  } catch (SQLException e) {
                        System.out.println("Errore: " + e.getMessage());

                  }
            }
        System.out.println("fine cancella user");
      }

public static void deleteRic(String id){
        
        String queryupdate = "DELETE FROM ricoveri WHERE idricovero= '"+ id +"'";
        String errore=avvia();
         if (errore.equals("")) {
                  try {
                        Statement st = getConnessione().createStatement();
                        int rs = st.executeUpdate(queryupdate);
                                System.out.println("query cancella user");

                        st.close();
                        conn.close();
                  } catch (SQLException e) {
                        System.out.println("Errore: " + e.getMessage());

                  }
            }
        System.out.println("fine cancella user");
      }


    public static String checkPaziente(String code){
        String sql = "SELECT * FROM pazienti WHERE codicefiscale = '"+ code +"'";
        String errore=avvia();
        String ob="libero";

         if (errore.equals("")){
         try{
               Statement st=getConnessione().createStatement();
               ResultSet rs=st.executeQuery(sql);
                if(rs.first())
                    {
                       ob="occupato";
                    }
               conn.close();
            }
            catch(Exception ec){
                ec.printStackTrace();
                StringBuilder temp=new StringBuilder();
                temp.append("errore/n");
                temp.append(ec.getMessage());
                System.out.println("L'errore Ã¨"+ec.getMessage());
                ob=temp.toString();
              }
        }
        System.out.println(ob);
        return ob;
    }

    // Invia i dati per inserire un nuovo libro nel database
    public static String newPaziente(String code, String cognome, String nome, String data, String anni, String sesso)
   {
        String query = "INSERT INTO pazienti (codicefiscale , cognome , nome , datanascita , età , sesso) "
                    + "VALUES ('" + code + "','" + cognome + "','" + nome + "','" + data + "','" + anni + "','" + sesso + "')";

        String errore=avvia();
        String ris = "no";


         if (errore.equals("")) {
                  try {
                        Statement st = getConnessione().createStatement();
                        int rs = st.executeUpdate(query);

                        st.close();
                        conn.close();
                        ris = "si";
                  } catch (SQLException e) {
                        System.out.println("Errore: " + e.getMessage());
                        return ris;
                  }
            }
            System.out.println(ris);
            return ris;
      }


    public static String newRicovero(String id, String code, String dataR, String durata, String dataD, String DRG, String prima, String iceprima,
              String seconda, String iceseconda, String terza, String iceterza, String quarta, String icequarta, String NPC, String dataC, String creat,
              String CRC, String cinqueclassi, String dueclassi, String diabete, String ipertensione)
   {
        System.out.println("ci siamo?");
        String query = "INSERT INTO ricoveri (idricovero, codice, dataRic, durata, dataDim, DRG, prima, iceprima, seconda,iceseconda, terza, iceterza, quarta, icequarta, NPC, colldate, creat, CRC, 5classi, 2classi, diabete, ipertensione) "
                    + "VALUES ('" + id + "','" + code + "','" + dataR + "','" + durata + "','" + dataD + "','" + DRG + "','" + prima + "','" + iceprima + "','" + seconda + "','" + iceseconda + "','" + terza + "','" + iceterza + "','" + quarta + "','" + icequarta + "','" + NPC + "','" + dataC + "','" + creat + "','" + CRC + "','" + cinqueclassi + "','" + dueclassi + "','" + diabete + "','" + ipertensione + "')";

        String errore=avvia();
        String ris = "no";

        System.out.println("ma cazzo1");
         if (errore.equals("")) {
             System.out.println("ma cazzo2");
                  try {
                        Statement st = getConnessione().createStatement();
                        System.out.println("prima della query tutto ok");
                        int rs = st.executeUpdate(query);
                        st.close();
                        conn.close();
                        ris = "si";
                  } catch (SQLException e) {
                        System.out.println("Errore: " + e.getMessage());
                        return ris;
                  }
            }
            System.out.println(ris);
            return ris;
      }

    //carica la lista dei nomi dei libri della prenotazione
 public String getName(String username) throws SQLException
   {
       String errore=avvia();
       String sql  ="SELECT * FROM utenti WHERE username = '"+ username +"'";
       String name = "";

       if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           if (rs.first()){
            String nome = rs.getString(2);
            String surname= rs.getString(3);
            name= (nome + " " + surname);

          }
            }
        catch(Exception ec)
            {
                ec.printStackTrace();
                StringBuilder temp=new StringBuilder();
                temp.append("errore/n");
                temp.append(ec.getMessage());
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
    return name;
 }

 public Vector getAllName() throws SQLException
   {
        String SQL ="SELECT cognome FROM pazienti";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("cognome");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
         return ris;
    }

 public Vector getIDRic() throws SQLException
   {
        String SQL ="SELECT idricovero FROM ricoveri";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("idricovero");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
         return ris;
    }

 public Vector getCodeRic() throws SQLException
   {
        String SQL ="SELECT codice FROM ricoveri";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("codice");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
         return ris;
    }
 public Vector getDatarRic() throws SQLException
   {
        String SQL ="SELECT dataRic FROM ricoveri";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("dataRic");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
         return ris;
    }

 public Vector getDatadRic() throws SQLException
   {
        String SQL ="SELECT dataDim FROM ricoveri";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("dataDim");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
         return ris;
    }

 
 public Vector getDRGRic() throws SQLException
   {
        String SQL ="SELECT DRG FROM ricoveri";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("DRG");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
         return ris;
    }

 public Vector getDate() throws SQLException
   {
        String SQL ="SELECT dataricovero FROM ricoveri";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("dataricovero");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
         return ris;
    }

 public String getCode1(String nome,String cognome) throws SQLException
   {
       String errore=avvia();
       String sql  ="SELECT * FROM ricoveri WHERE nome = '"+ nome + "'AND cognome = '"+ cognome +"'";
       String c = "";

       if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           if (rs.first()){
                c = rs.getString(1);
          }
            }
        catch(Exception ec)
            {
                ec.printStackTrace();
                StringBuilder temp=new StringBuilder();
                temp.append("errore/n");
                temp.append(ec.getMessage());
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
    return c;
 }

 public String getDate1(String nome,String cognome) throws SQLException
   {
       String errore=avvia();
       String sql  ="SELECT * FROM ricoveri WHERE nome = '"+ nome + "'AND cognome = '"+ cognome +"'";
       String c = "";

       if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           if (rs.first()){
                c = rs.getString(4);
          }
            }
        catch(Exception ec)
            {
                ec.printStackTrace();
                StringBuilder temp=new StringBuilder();
                temp.append("errore/n");
                temp.append(ec.getMessage());
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
    return c;
 }

 public String getEtà1(String nome,String cognome) throws SQLException
   {
       String errore=avvia();
       String sql  ="SELECT * FROM ricoveri WHERE nome = '"+ nome + "'AND cognome = '"+ cognome +"'";
       String c = "";

       if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           if (rs.first()){
                c = rs.getString(5);
          }
            }
        catch(Exception ec)
            {
                ec.printStackTrace();
                StringBuilder temp=new StringBuilder();
                temp.append("errore/n");
                temp.append(ec.getMessage());
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
    return c;
 }

 public String getDataR1(String ID) throws SQLException
   {
       String errore=avvia();
       String sql  ="SELECT dataRic FROM ricoveri WHERE idricovero = '"+ ID + "'";
       String c = "";

       if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           if (rs.first()){
                c = rs.getString("dataRic");
          }
            }
        catch(Exception ec)
            {
                ec.printStackTrace();
                StringBuilder temp=new StringBuilder();
                temp.append("errore/n");
                temp.append(ec.getMessage());
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
    return c;
 }
public String getDataD1(String ID) throws SQLException
   {
       String errore=avvia();
       String sql  ="SELECT dataDim FROM ricoveri WHERE idricovero = '"+ ID + "'";
       String c = "";

       if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           if (rs.first()){
                c = rs.getString("dataDim");
          }
            }
        catch(Exception ec)
            {
                ec.printStackTrace();
                StringBuilder temp=new StringBuilder();
                temp.append("errore/n");
                temp.append(ec.getMessage());
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
    return c;
 }
public String getDurata1(String ID) throws SQLException
   {
       String errore=avvia();
       String sql  ="SELECT durata FROM ricoveri WHERE idricovero = '"+ ID + "'";
       String c = "";

       if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           if (rs.first()){
                c = rs.getString("durata");
          }
            }
        catch(Exception ec)
            {
                ec.printStackTrace();
                StringBuilder temp=new StringBuilder();
                temp.append("errore/n");
                temp.append(ec.getMessage());
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
    return c;
 }
public String getDRG1(String ID) throws SQLException
   {
       String errore=avvia();
       String sql  ="SELECT DRG FROM ricoveri WHERE idricovero = '"+ ID + "'";
       String c = "";

       if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           if (rs.first()){
                c = rs.getString("DRG");
          }
            }
        catch(Exception ec)
            {
                ec.printStackTrace();
                StringBuilder temp=new StringBuilder();
                temp.append("errore/n");
                temp.append(ec.getMessage());
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
    return c;
 }

public String getPrima1(String ID) throws SQLException
   {
       String errore=avvia();
       String sql  ="SELECT prima FROM ricoveri WHERE idricovero = '"+ ID + "'";
       String c = "";

       if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           if (rs.first()){
                c = rs.getString("prima");
          }
           if (c.equals("NULL")){
               c = "";
           }
            }
        catch(Exception ec)
            {
                ec.printStackTrace();
                StringBuilder temp=new StringBuilder();
                temp.append("errore/n");
                temp.append(ec.getMessage());
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
    return c;
 }

public String getIcePrima1(String ID) throws SQLException
   {
       String errore=avvia();
       String sql  ="SELECT iceprima FROM ricoveri WHERE idricovero = '"+ ID + "'";
       String c = "";

       if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           if (rs.first()){
                c = rs.getString("iceprima");
          }
           if ( c.equals("NULL")){
               c = "";
           }
            }
        catch(Exception ec)
            {
                ec.printStackTrace();
                StringBuilder temp=new StringBuilder();
                temp.append("errore/n");
                temp.append(ec.getMessage());
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
    return c;
 }

public String getSeconda1(String ID) throws SQLException
   {
       String errore=avvia();
       String sql  ="SELECT seconda FROM ricoveri WHERE idricovero = '"+ ID + "'";
       String c = "";

       if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           if (rs.first()){
                c = rs.getString("seconda");
          }
           if (c.equals("NULL")){
               c = "";
           }
            }
        catch(Exception ec)
            {
                ec.printStackTrace();
                StringBuilder temp=new StringBuilder();
                temp.append("errore/n");
                temp.append(ec.getMessage());
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
    return c;
 }

public String getIceSeconda1(String ID) throws SQLException
   {
       String errore=avvia();
       String sql  ="SELECT iceseconda FROM ricoveri WHERE idricovero = '"+ ID + "'";
       String c = "";

       if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           if (rs.first()){
                c = rs.getString("iceseconda");
          }
           if ( c.equals("NULL")){
               c = "";
           }
            }
        catch(Exception ec)
            {
                ec.printStackTrace();
                StringBuilder temp=new StringBuilder();
                temp.append("errore/n");
                temp.append(ec.getMessage());
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
    return c;
 }

public String getTerza1(String ID) throws SQLException
   {
       String errore=avvia();
       String sql  ="SELECT terza FROM ricoveri WHERE idricovero = '"+ ID + "'";
       String c = "";

       if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           if (rs.first()){
                c = rs.getString("terza");
          }
           if (c.equals("NULL")){
               c = "";
           }
            }
        catch(Exception ec)
            {
                ec.printStackTrace();
                StringBuilder temp=new StringBuilder();
                temp.append("errore/n");
                temp.append(ec.getMessage());
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
    return c;
 }

public String getIceTerza1(String ID) throws SQLException
   {
       String errore=avvia();
       String sql  ="SELECT iceterza FROM ricoveri WHERE idricovero = '"+ ID + "'";
       String c = "";

       if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           if (rs.first()){
                c = rs.getString("iceterza");
          }
           if ( c.equals("NULL")){
               c = "";
           }
            }
        catch(Exception ec)
            {
                ec.printStackTrace();
                StringBuilder temp=new StringBuilder();
                temp.append("errore/n");
                temp.append(ec.getMessage());
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
    return c;
 }

public String getQuarta1(String ID) throws SQLException
   {
       String errore=avvia();
       String sql  ="SELECT quarta FROM ricoveri WHERE idricovero = '"+ ID + "'";
       String c = "";

       if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           if (rs.first()){
                c = rs.getString("quarta");
          }
           if (c.equals("NULL")){
               c = "";
           }
            }
        catch(Exception ec)
            {
                ec.printStackTrace();
                StringBuilder temp=new StringBuilder();
                temp.append("errore/n");
                temp.append(ec.getMessage());
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
    return c;
 }

public String getIceQuarta1(String ID) throws SQLException
   {
       String errore=avvia();
       String sql  ="SELECT icequarta FROM ricoveri WHERE idricovero = '"+ ID + "'";
       String c = "";

       if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           if (rs.first()){
                c = rs.getString("icequarta");
          }
           if ( c.equals("NULL")){
               c = "";
           }
            }
        catch(Exception ec)
            {
                ec.printStackTrace();
                StringBuilder temp=new StringBuilder();
                temp.append("errore/n");
                temp.append(ec.getMessage());
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
    return c;
 }
public String getNPC1(String ID) throws SQLException
   {
       String errore=avvia();
       String sql  ="SELECT NPC FROM ricoveri WHERE idricovero = '"+ ID + "'";
       String c = "";

       if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           if (rs.first()){
                c = rs.getString("NPC");
          }
            }
        catch(Exception ec)
            {
                ec.printStackTrace();
                StringBuilder temp=new StringBuilder();
                temp.append("errore/n");
                temp.append(ec.getMessage());
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
    return c;
 }
public String getColldate1(String ID) throws SQLException
   {
       String errore=avvia();
       String sql  ="SELECT colldate FROM ricoveri WHERE idricovero = '"+ ID + "'";
       String c = "";

       if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           if (rs.first()){
                c = rs.getString("colldate");
          }
            }
        catch(Exception ec)
            {
                ec.printStackTrace();
                StringBuilder temp=new StringBuilder();
                temp.append("errore/n");
                temp.append(ec.getMessage());
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
    return c;
 }

public String getCreat1(String ID) throws SQLException
   {
       String errore=avvia();
       String sql  ="SELECT creat FROM ricoveri WHERE idricovero = '"+ ID + "'";
       String c = "";

       if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           if (rs.first()){
                c = rs.getString("creat");
          }
            }
        catch(Exception ec)
            {
                ec.printStackTrace();
                StringBuilder temp=new StringBuilder();
                temp.append("errore/n");
                temp.append(ec.getMessage());
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
    return c;
 }

public String getCRC1(String ID) throws SQLException
   {
       String errore=avvia();
       String sql  ="SELECT CRC FROM ricoveri WHERE idricovero = '"+ ID + "'";
       String c = "";

       if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           if (rs.first()){
                c = rs.getString("CRC");
          }
            }
        catch(Exception ec)
            {
                ec.printStackTrace();
                StringBuilder temp=new StringBuilder();
                temp.append("errore/n");
                temp.append(ec.getMessage());
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
    return c;
 }

public String get2classi1(String ID) throws SQLException
   {
       String errore=avvia();
       String sql  ="SELECT 2classi FROM ricoveri WHERE idricovero = '"+ ID + "'";
       String c = "";

       if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           if (rs.first()){
                c = rs.getString("2classi");
          }
            }
        catch(Exception ec)
            {
                ec.printStackTrace();
                StringBuilder temp=new StringBuilder();
                temp.append("errore/n");
                temp.append(ec.getMessage());
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
    return c;
 }

public String get5classi1(String ID) throws SQLException
   {
       String errore=avvia();
       String sql  ="SELECT 5classi FROM ricoveri WHERE idricovero = '"+ ID + "'";
       String c = "";

       if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           if (rs.first()){
                c = rs.getString("5classi");
          }
            }
        catch(Exception ec)
            {
                ec.printStackTrace();
                StringBuilder temp=new StringBuilder();
                temp.append("errore/n");
                temp.append(ec.getMessage());
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
    return c;
 }

public String UpdateRic(String ID, String code, String dataR, String durata ,String dataD, String DRG, String prima, String iceprima, String seconda,
                                String iceseconda, String terza, String iceterza, String quarta, String icequarta, String contab, String dataC, String creat,
                                String CRC, String cinqueclassi, String dueclassi, String diabete, String ipertensione)
   {
        String ret = "no";
        System.out.println("je la famo?");
        //String query = "UPDATE ricoveri SET idricovero ='"+ code +"'WHERE idricovero='"+ ID +"'";
        String queryupdate = "UPDATE ricoveri SET codice ='"+ code +"'WHERE idricovero='"+ ID +"'";
        System.out.println("non je la famo");
        String query = "UPDATE ricoveri SET dataRic ='"+ dataR +"'WHERE idricovero='"+ ID +"'";
        String query1 = "UPDATE ricoveri SET durata ='"+ durata +"'WHERE idricovero='"+ ID +"'";
        String query2 = "UPDATE ricoveri SET dataDim ='"+ dataD +"'WHERE idricovero='"+ ID +"'";
        String query3 = "UPDATE ricoveri SET DRG ='"+ DRG +"'WHERE idricovero='"+ ID +"'";
        String query4 = "UPDATE ricoveri SET prima ='"+ prima +"'WHERE idricovero='"+ ID +"'";
        String query5 = "UPDATE ricoveri SET iceprima ='"+ iceprima +"'WHERE idricovero='"+ ID +"'";
        String query6 = "UPDATE ricoveri SET seconda ='"+ seconda +"'WHERE idricovero='"+ ID +"'";
        String query7 = "UPDATE ricoveri SET iceseconda ='"+ iceseconda +"'WHERE idricovero='"+ ID +"'";
        String query8 = "UPDATE ricoveri SET terza ='"+ terza +"'WHERE idricovero='"+ ID +"'";
        String query9 = "UPDATE ricoveri SET iceterza ='"+ iceterza +"'WHERE idricovero='"+ ID +"'";
        String query10 = "UPDATE ricoveri SET quarta ='"+ quarta +"'WHERE idricovero='"+ ID +"'";
        String query11 = "UPDATE ricoveri SET icequarta ='"+ icequarta +"'WHERE idricovero='"+ ID +"'";
        String query12 = "UPDATE ricoveri SET NPC ='"+ contab +"'WHERE idricovero='"+ ID +"'";
        String query13 = "UPDATE ricoveri SET colldate='"+ dataC +"'WHERE idricovero='"+ ID +"'";
        String query14 = "UPDATE ricoveri SET creat ='"+ creat +"'WHERE idricovero='"+ ID +"'";
        String query15 = "UPDATE ricoveri SET CRC ='"+ CRC +"'WHERE idricovero='"+ ID +"'";
        String query16 = "UPDATE ricoveri SET 5classi ='"+ cinqueclassi +"'WHERE idricovero='"+ ID +"'";
        String query17 = "UPDATE ricoveri SET 2classi ='"+ dueclassi +"'WHERE idricovero='"+ ID +"'";
        String query18 = "UPDATE ricoveri SET diabete ='"+ diabete +"'WHERE idricovero='"+ ID +"'";
        String query19 = "UPDATE ricoveri SET ipertensione ='"+ ipertensione +"'WHERE idricovero='"+ ID +"'";

        String errore=avvia();
         if (errore.equals("")) {
                  try {
                        Statement st = getConnessione().createStatement();
                        int rs = st.executeUpdate(queryupdate);
                        
                        int rs1 =st.executeUpdate(query);
                        int rs2 =st.executeUpdate(query1);
                        int rs3 =st.executeUpdate(query2);
                        int rs4 =st.executeUpdate(query3);
                        int rs5 =st.executeUpdate(query5);
                        int rs6 =st.executeUpdate(query6);
                        int rs7 =st.executeUpdate(query7);
                        int rs8 =st.executeUpdate(query8);
                        int rs9 =st.executeUpdate(query9);
                        int rs10 =st.executeUpdate(query10);
                        int rs11 =st.executeUpdate(query11);
                        int rs12 =st.executeUpdate(query12);
                        int rs13 =st.executeUpdate(query13);
                        int rs14 =st.executeUpdate(query14);
                        int rs15 =st.executeUpdate(query15);
                        int rs16 =st.executeUpdate(query16);
                        int rs17 =st.executeUpdate(query17);
                        int rs18 =st.executeUpdate(query18);
                        int rs19 =st.executeUpdate(query19);
                        ret = "si";
                        st.close();
                        conn.close();

                  } catch (SQLException e) {
                        System.out.println("Errore: " + e.getMessage());

                  }

            }

            return ret;
      }


public Vector getMDC() throws SQLException
   {
        String SQL ="SELECT DRG FROM ricoveri";
        Vector ris = new Vector();
        String app = "";
        String app2 = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("DRG");
                     ResultSet mdc = st.executeQuery("SELECT MDC FROM DRG WHERE idDRG= '"+ app + "'");
                     app2 = mdc.getString("MDC");
                     ris.add(app2);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
         return ris;
    }

public Vector getTipo() throws SQLException
   {
        String SQL ="SELECT DRG FROM ricoveri";
        Vector ris = new Vector();
        String app = "";
        String app2 = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("DRG");
                     ResultSet type = st.executeQuery("SELECT tipo FROM DRG WHERE idDRG= '"+ app + "'");
                     app2 = type.getString("tipo");
                     ris.add(app2);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
         return ris;
    }

public Vector getDescrizione() throws SQLException
   {
        String SQL ="SELECT DRG FROM ricoveri";
        Vector ris = new Vector();
        String app = "";
        String app2 = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("DRG");
                     ResultSet desc = st.executeQuery("SELECT descrizione FROM DRG WHERE idDRG= '"+ app + "'");
                     app2 = desc.getString("descrizione");
                     ris.add(app2);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
         return ris;
    }

public Vector getPeso() throws SQLException
   {
        String SQL ="SELECT DRG FROM ricoveri";
        Vector ris = new Vector();
        String app = "";
        String app2 = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("DRG");
                     ResultSet peso = st.executeQuery("SELECT peso FROM DRG WHERE idDRG= '"+ app + "'");
                     app2 = peso.getString("peso");
                     ris.add(app2);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
         return ris;
    }

public Vector getSoglia() throws SQLException
   {
        String SQL ="SELECT DRG FROM ricoveri";
        Vector ris = new Vector();
        String app = "";
        String app2 = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("DRG");
                     ResultSet soglia = st.executeQuery("SELECT soglia FROM DRG WHERE idDRG= '"+ app + "'");
                     app2 = soglia.getString("soglia");
                     ris.add(app2);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
         return ris;
    }


public Vector getAllCode() throws SQLException
   {
        String SQL ="SELECT codfiscale FROM ricoveri";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("codfiscale");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        return ris;
    }

public Vector getAllSex() throws SQLException
   {
        String SQL ="SELECT sesso FROM ricoveri";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("sesso");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        return ris;
    }

public Vector getAllAge() throws SQLException
   {
        String SQL ="SELECT età FROM ricoveri";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("età");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        return ris;
    }

public Vector getAllDatar() throws SQLException
   {
        String SQL ="SELECT dataricovero FROM ricoveri";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("dataricovero");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        return ris;
    }

public Vector getAllDatad() throws SQLException
   {
        String SQL ="SELECT datadimissione FROM ricoveri";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("datadimissione");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        return ris;
    }

public Vector getAllDurata() throws SQLException
   {
        String SQL ="SELECT durataricovero FROM ricoveri";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("durataricovero");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        return ris;
    }

public Vector getAllDRG() throws SQLException
   {
        String SQL ="SELECT DRG FROM ricoveri";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("DRG");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        return ris;
    }


public Vector getAllPrima() throws SQLException
   {
        String SQL ="SELECT primadiagnosi FROM ricoveri";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("primadiagnosi");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        return ris;
    }

public Vector getAllIceprima() throws SQLException
   {
        String SQL ="SELECT iceprimadiagnosi FROM ricoveri";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("iceprimadiagnosi");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        return ris;
    }

public Vector getAllSeconda() throws SQLException
   {
        String SQL ="SELECT secondadiagnosi FROM ricoveri";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("secondadiagnosi");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        return ris;
    }

public Vector getAllIceseconda() throws SQLException
   {
        String SQL ="SELECT icesecondadiagnosi FROM ricoveri";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("icesecondadiagnosi");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        return ris;
    }

public Vector getAllTerza() throws SQLException
   {
        String SQL ="SELECT terzadiagnosi FROM ricoveri";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("terzadiagnosi");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        return ris;
    }

public Vector getAllIceterza() throws SQLException
   {
        String SQL ="SELECT iceterzadiagnosi FROM ricoveri";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("iceterzadiagnosi");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        return ris;
    }

public Vector getAllQuarta() throws SQLException
   {
        String SQL ="SELECT quartadiagnosi FROM ricoveri";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("quartadiagnosi");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        return ris;
    }

public Vector getAllIcequarta() throws SQLException
   {
        String SQL ="SELECT icequartadiagnosi FROM ricoveri";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("icequartadiagnosi");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        return ris;
    }

public Vector getAllNPC() throws SQLException
   {
        String SQL ="SELECT nuovaposizionecontabile FROM ricoveri";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("nuovaposizionecontabile");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        return ris;
    }

public Vector getAllColldate() throws SQLException
   {
        String SQL ="SELECT colldate FROM ricoveri";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("colldate");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        return ris;
    }

public Vector getAllCreat() throws SQLException
   {
        String SQL ="SELECT creat FROM ricoveri";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("creat");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        return ris;
    }

public Vector getAllCRC() throws SQLException
   {
        String SQL ="SELECT CRC FROM ricoveri";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("CRC");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        return ris;
    }


 public Vector getPazCode() throws SQLException
   {
        String SQL ="SELECT codicefiscale FROM pazienti";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("codicefiscale");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
         return ris;
    }

  public Vector getPazName() throws SQLException
   {
        String SQL ="SELECT nome FROM pazienti";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("nome");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
         return ris;
    }


   public Vector getPazSecondName() throws SQLException
   {
        String SQL ="SELECT cognome FROM pazienti";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("cognome");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
         return ris;
    }

    public Vector getPazDate() throws SQLException
   {
        String SQL ="SELECT datanascita FROM pazienti";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("datanascita");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
         return ris;
    }

    public int RitornaID() throws SQLException
   {
       String errore=avvia();
       String sql  ="SELECT MAX(idricovero) AS max FROM ricoveri";
       int id = 0;

       if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           System.out.println(rs.first());
           if(rs.first()){
                id = rs.getInt(1) + 1;
           }

           System.out.println(id);



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
    return id;
 }

    public Vector getOneID(String code) throws SQLException
   {
        String SQL ="(SELECT idricovero FROM ricoveri WHERE codice = '"+ code + "')";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("idricovero");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

    public Vector getOneDataRic(String code) throws SQLException
   {
        String SQL ="(SELECT dataRic FROM ricoveri WHERE codice = '"+ code + "')";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("dataRic");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

    public Vector getOneDataDim(String code) throws SQLException
   {
        String SQL ="(SELECT dataDim FROM ricoveri WHERE codice = '"+ code + "')";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("dataDim");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

    public Vector getOneDRG(String code) throws SQLException
   {
        String SQL ="(SELECT DRG FROM ricoveri WHERE codice = '"+ code + "')";
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(SQL);
           while (rs.next()) {
                     app = rs.getString("DRG");
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }


    public Vector getTabCode() throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("codicefiscale");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

     public Vector getTabCognome() throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("cognome");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

     public Vector getTabNome() throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("nome");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
     public Vector getTabData() throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("datanascita");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
     public Vector getTabEta() throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("età");
                     
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
     public Vector getTabSesso() throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("sesso");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

     public Vector getTabDatar() throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("dataRic");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

          public Vector getTabDatad() throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("dataDim");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

     public Vector getTabDurata() throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("durata");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
 public Vector getTabDRG() throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("DRG");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
  public Vector getTabPrima() throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("prima");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
   public Vector getTabIcePrima() throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("iceprima");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
    public Vector getTabSeconda() throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("seconda");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
     public Vector getTabIceSeconda() throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("iceseconda");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

      public Vector getTabTerza() throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("terza");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
       public Vector getTabIceTerza() throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("iceterza");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
        public Vector getTabQuarta() throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("quarta");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
         public Vector getTabIceQuarta() throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("icequarta");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
          public Vector getTabNPC() throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("NPC");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
           public Vector getTabCollDate() throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("colldate");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
            public Vector getTabCreat() throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("creat");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
             public Vector getTabCRC() throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("CRC");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
              public Vector getTab5classi() throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("5classi");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
             public Vector getTab2classi() throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("2classi");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
              public Vector getTabDiabete() throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("diabete");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

              public Vector getTabIpertensione() throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("ipertensione");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

    public Vector getTabMDC() throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("MDC");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

    public Vector getTabTipo() throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("tipo");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

    public Vector getTabDescrizione() throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("descrizione");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

    public Vector getTabPeso() throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("peso");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

    public Vector getTabSoglia() throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("soglia");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
    
    public Vector getTabCodeCF(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE pazienti.codicefiscale ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("codicefiscale");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

     public Vector getTabCognomeCF(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE pazienti.codicefiscale ='"+ cerca + "'"  ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("cognome");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

     public Vector getTabNomeCF(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE pazienti.codicefiscale ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("nome");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
     public Vector getTabDataCF(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE pazienti.codicefiscale ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("datanascita");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
     public Vector getTabEtaCF(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE pazienti.codicefiscale ='"+ cerca + "'" ; 
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("età");
                     
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
     public Vector getTabSessoCF(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE pazienti.codicefiscale ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("sesso");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

     public Vector getTabDatarCF(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE pazienti.codicefiscale ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("dataRic");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

          public Vector getTabDatadCF(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE pazienti.codicefiscale ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("dataDim");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

     public Vector getTabDurataCF(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE pazienti.codicefiscale ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("durata");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
 public Vector getTabDRGCF(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE pazienti.codicefiscale ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("DRG");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
  public Vector getTabPrimaCF(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE pazienti.codicefiscale ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("prima");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
   public Vector getTabIcePrimaCF(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE pazienti.codicefiscale ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("iceprima");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
    public Vector getTabSecondaCF(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE pazienti.codicefiscale ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("seconda");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
     public Vector getTabIceSecondaCF(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE pazienti.codicefiscale ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("iceseconda");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

      public Vector getTabTerzaCF(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE pazienti.codicefiscale ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("terza");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
       public Vector getTabIceTerzaCF(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE pazienti.codicefiscale ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("iceterza");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
        public Vector getTabQuartaCF(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE pazienti.codicefiscale ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("quarta");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
         public Vector getTabIceQuartaCF(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE pazienti.codicefiscale ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("icequarta");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
          public Vector getTabNPCCF(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE pazienti.codicefiscale ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("NPC");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
           public Vector getTabCollDateCF(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE pazienti.codicefiscale ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("colldate");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
            public Vector getTabCreatCF(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE pazienti.codicefiscale ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("creat");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
             public Vector getTabCRCCF(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE pazienti.codicefiscale ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("CRC");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
              public Vector getTab5classiCF(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE pazienti.codicefiscale ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("5classi");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
             public Vector getTab2classiCF(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE pazienti.codicefiscale ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("2classi");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
              public Vector getTabDiabeteCF(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE pazienti.codicefiscale ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("diabete");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

              public Vector getTabIpertensioneCF(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE pazienti.codicefiscale ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("ipertensione");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

    public Vector getTabMDCCF(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE pazienti.codicefiscale ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("MDC");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

    public Vector getTabTipoCF(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE pazienti.codicefiscale ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("tipo");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

    public Vector getTabDescrizioneCF(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE pazienti.codicefiscale ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("descrizione");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

    public Vector getTabPesoCF(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE pazienti.codicefiscale ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("peso");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

    public Vector getTabSogliaCF(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE pazienti.codicefiscale ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("soglia");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
    public Vector getTabCodeMDC(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE drg.MDC ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("codicefiscale");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

     public Vector getTabCognomeMDC(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE drg.MDC  ='"+ cerca + "'"  ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("cognome");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

     public Vector getTabNomeMDC(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE drg.MDC ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("nome");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
     public Vector getTabDataMDC(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE drg.MDC ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("datanascita");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
     public Vector getTabEtaMDC(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE drg.MDC ='"+ cerca + "'" ; 
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("età");
                     
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
     public Vector getTabSessoMDC(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE drg.MDC ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("sesso");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

     public Vector getTabDatarMDC(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE drg.MDC ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("dataRic");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

          public Vector getTabDatadMDC(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE drg.MDC ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("dataDim");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

     public Vector getTabDurataMDC(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE drg.MDC ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("durata");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
 public Vector getTabDRGMDC(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE drg.MDC ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("DRG");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
  public Vector getTabPrimaMDC(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE drg.MDC ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("prima");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
   public Vector getTabIcePrimaMDC(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE drg.MDC ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("iceprima");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
    public Vector getTabSecondaMDC(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE drg.MDC ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("seconda");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
     public Vector getTabIceSecondaMDC(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE drg.MDC ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("iceseconda");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

      public Vector getTabTerzaMDC(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE drg.MDC ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("terza");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
       public Vector getTabIceTerzaMDC(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE drg.MDC ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("iceterza");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
        public Vector getTabQuartaMDC(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE drg.MDC ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("quarta");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
         public Vector getTabIceQuartaMDC(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE drg.MDC ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("icequarta");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
          public Vector getTabNPCMDC(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE drg.MDC ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("NPC");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
           public Vector getTabCollDateMDC(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE drg.MDC ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("colldate");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
            public Vector getTabCreatMDC(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE drg.MDC ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("creat");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
             public Vector getTabCRCMDC(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE drg.MDC ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("CRC");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
              public Vector getTab5classiMDC(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE drg.MDC ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("5classi");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
             public Vector getTab2classiMDC(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE drg.MDC ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("2classi");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
              public Vector getTabDiabeteMDC(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE drg.MDC ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("diabete");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

              public Vector getTabIpertensioneMDC(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE drg.MDC ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("ipertensione");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

    public Vector getTabMDCMDC(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE drg.MDC ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("MDC");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

    public Vector getTabTipoMDC(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE drg.MDC ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("tipo");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

    public Vector getTabDescrizioneMDC(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE drg.MDC ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("descrizione");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

    public Vector getTabPesoMDC(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE drg.MDC ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("peso");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

    public Vector getTabSogliaMDC(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE drg.MDC ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("soglia");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
    public Vector getTabCode2C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.2classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("codicefiscale");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

     public Vector getTabCognome2C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.2classi  ='"+ cerca + "'"  ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("cognome");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

     public Vector getTabNome2C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.2classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("nome");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
     public Vector getTabData2C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.2classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("datanascita");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
     public Vector getTabEta2C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.2classi='"+ cerca + "'" ; 
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("età");
                     
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
     public Vector getTabSesso2C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.2classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("sesso");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

     public Vector getTabDatar2C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.2classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("dataRic");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

          public Vector getTabDatad2C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.2classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("dataDim");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

     public Vector getTabDurata2C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.2classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("durata");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
 public Vector getTabDRG2C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.2classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("DRG");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
  public Vector getTabPrima2C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.2classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("prima");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
   public Vector getTabIcePrima2C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.2classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("iceprima");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
    public Vector getTabSeconda2C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.2classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("seconda");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
     public Vector getTabIceSeconda2C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.2classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("iceseconda");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

      public Vector getTabTerza2C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.2classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("terza");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
       public Vector getTabIceTerza2C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.2classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("iceterza");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
        public Vector getTabQuarta2C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.2classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("quarta");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
         public Vector getTabIceQuarta2C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.2classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("icequarta");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
          public Vector getTabNPC2C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.2classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("NPC");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
           public Vector getTabCollDate2C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.2classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("colldate");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
            public Vector getTabCreat2C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.2classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("creat");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
             public Vector getTabCRC2C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.2classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("CRC");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
              public Vector getTab5classi2C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.2classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("5classi");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
             public Vector getTab2classi2C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.2classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("2classi");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
              public Vector getTabDiabete2C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.2classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("diabete");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

              public Vector getTabIpertensione2C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.2classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("ipertensione");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

    public Vector getTabMDC2C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.2classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("MDC");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

    public Vector getTabTipo2C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.2classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("tipo");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

    public Vector getTabDescrizione2C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.2classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("descrizione");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

    public Vector getTabPeso2C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.2classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("peso");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

    public Vector getTabSoglia2C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.2classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("soglia");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
    public Vector getTabCode5C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.5classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("codicefiscale");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

     public Vector getTabCognome5C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.5classi  ='"+ cerca + "'"  ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("cognome");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

     public Vector getTabNome5C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.5classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("nome");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
     public Vector getTabData5C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.5classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("datanascita");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
     public Vector getTabEta5C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.5classi='"+ cerca + "'" ; 
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("età");
                     
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
     public Vector getTabSesso5C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.5classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("sesso");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

     public Vector getTabDatar5C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.5classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("dataRic");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

          public Vector getTabDatad5C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.5classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("dataDim");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

     public Vector getTabDurata5C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.5classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("durata");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
 public Vector getTabDRG5C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.5classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("DRG");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
  public Vector getTabPrima5C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.5classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("prima");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
   public Vector getTabIcePrima5C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.5classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("iceprima");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
    public Vector getTabSeconda5C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.5classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("seconda");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
     public Vector getTabIceSeconda5C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.5classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("iceseconda");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

      public Vector getTabTerza5C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.5classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("terza");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
       public Vector getTabIceTerza5C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.5classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("iceterza");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
        public Vector getTabQuarta5C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.5classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("quarta");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
         public Vector getTabIceQuarta5C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.5classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("icequarta");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
          public Vector getTabNPC5C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.5classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("NPC");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
           public Vector getTabCollDate5C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.5classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("colldate");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
            public Vector getTabCreat5C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.5classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("creat");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
             public Vector getTabCRC5C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.5classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("CRC");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
              public Vector getTab5classi5C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.5classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("5classi");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
             public Vector getTab2classi5C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.5classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("2classi");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
              public Vector getTabDiabete5C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.5classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("diabete");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

              public Vector getTabIpertensione5C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.5classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("ipertensione");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

    public Vector getTabMDC5C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.5classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("MDC");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

    public Vector getTabTipo5C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.5classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("tipo");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

    public Vector getTabDescrizione5C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.5classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("descrizione");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

    public Vector getTabPeso5C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.5classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("peso");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }

    public Vector getTabSoglia5C(String cerca) throws SQLException
   {
        String sql = "SELECT * FROM pazienti INNER JOIN ricoveri ON pazienti.codicefiscale = ricoveri.codice  INNER JOIN drg ON ricoveri.DRG = drg.idDRG WHERE ricoveri.5classi ='"+ cerca + "'" ;
        Vector ris = new Vector();
        String app = "";
        String errore=avvia();
        if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
                     app = rs.getString("soglia");
                     System.out.println(app);
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
                System.out.println("L'errore Ã¨"+ec.getMessage());
            }
      }
        System.out.println("tutto ok !!!!!");
        return ris;
    }
    public float getPesoMax() throws SQLException
   {
       String errore=avvia();
       String sql  ="SELECT MAX(peso) AS max FROM drg " ;
       String max;
       float mass = 0;

       if (errore.equals("")){
        try{
           Statement st = getConnessione().createStatement();
           ResultSet rs = st.executeQuery(sql);
           System.out.println(rs.first());
           if(rs.first()){
                max = rs.getString(1);
                String s2 = max.replaceAll (",", ".");
                mass = Float.valueOf(s2).floatValue();
           }

           System.out.println(mass);



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
    return mass;
 }
}
