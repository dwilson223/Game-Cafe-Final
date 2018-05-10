/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamecafefinal;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author Dave
 */
public class AddGameController implements Initializable {
    
     @FXML
    private OpenView ov = new OpenView();
     
    @FXML
    private TextField textGameID;
    @FXML
    private TextField textTitle;
    @FXML
    private TextField textMultiplayer;
    @FXML
    private TextField textGameType;
    @FXML
    private TextField textRating;
    @FXML
    private TextField textPlatform;


    @FXML
    private Button btnGameSave;
    @FXML
    private Button btnClear;

     
    private dbConnection dbc;
    
    @FXML
    private void btnSaveGame(ActionEvent event) throws SQLException, IOException {                                              
            
        
        
        String colTitle = textTitle.getText();
        String colRating = textRating.getText();
        String colPlatform = textPlatform.getText();
        String colType = textGameType.getText();
        String colMultiplayer = textMultiplayer.getText();
       
        
        try{
            
            Connection conn= dbc.Connect();
            ResultSet rs = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery("SELECT * FROM TEAM.GAME");
            
            rs.moveToInsertRow( );
            
           
            rs.updateString("NAME", colTitle);
            rs.updateString("PEGI_AGE", colRating);
            rs.updateString("PLATFORM", colPlatform);
            rs.updateString("TYPE", colType);
            rs.updateString("PLAYERMODE", colMultiplayer);
            
            rs.insertRow( );
            
            
            rs.close( );
            goToGamesManagement(event);
           
            
               
        }
        catch (SQLException err) {
            System.out.println(err.getMessage());
        }  
    }
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          dbc=new dbConnection(); 
    }
    
    
    /* ----------------------- View Management ------------------------------ */
    @FXML
    private void goToGamesManagement(ActionEvent event) throws IOException {
       ov.open(event, "GamesManagement.fxml"); 
    }
     @FXML
    private void goToMembersManagement(ActionEvent event) throws IOException {
       ov.open(event, "MembersManagement.fxml"); 
    }
     @FXML
    private void goToBookingsManagement(ActionEvent event) throws IOException {
       ov.open(event, "BookingsManagement.fxml"); 
    }
    @FXML
    private void goToDashboard(ActionEvent event) throws IOException {
       ov.open(event, "Dashboard-home.fxml"); 
    }
    /* _______________________________________________________________________ */

}
