/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamecafefinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Dave, Tiago, Dan and Jordan
 */
public class GameCafeFinal extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Dashboard-home.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("Dash Board");
        //stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
        try{
            
        
            String host = "jdbc:derby://localhost:1527/GameCafe";
            String uName = "team";
            String uPass = "team";
            Connection con = DriverManager.getConnection( host, uName, uPass );
            
            //Test Connection and print results
            
            Statement stmt = con.createStatement( );
            String SQL = "SELECT * FROM GAMES.MEMBER";
            ResultSet rs = stmt.executeQuery(SQL);
            
            rs.next( );
            int id_col = rs.getInt("ID");
            String name_col = rs.getString("NAME");
            String dob_col = rs.getString("DOB");
            String add_col = rs.getString("ADDRESS");
            int tel_col = rs.getInt("TELEPHONE");
            String type_col = rs.getString("TYPE");
            
            String p = id_col + " " + name_col + " " + dob_col + " " + add_col + " " + tel_col + " " + type_col + " ";
            System.out.println(p);
            
            
        }
        catch ( SQLException err ) {
            System.out.println( err.getMessage( ) );
        }
    }
    
}
