/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clientETOM;
import java.sql.*;
import java.util.*;
/**
 *
 * @author Buri
 */
public class Main {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) { new Main(); }

    public Main()
    {
        /* setta tutte le variabili globali */
        /* avvia il login */
        Carica carica = new Carica();
        carica.setVisible(true);
    }


}
