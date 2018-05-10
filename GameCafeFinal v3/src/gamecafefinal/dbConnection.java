/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamecafefinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dave
 */
public class dbConnection {
    
    public Connection Connect() {
        try{
            //Database Url
            String host = "jdbc:derby://localhost:1527/GameCafe";
            //Database Username
            String username = "team";
            //Database password
            String password ="team";
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conn = DriverManager.getConnection( host, username, password);
            return conn;

        }   catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return null;
    }   
}