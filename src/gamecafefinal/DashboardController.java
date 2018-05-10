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
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;



/**
 *
 * @author Dave
 */
public class DashboardController implements Initializable {
   
    @FXML
    private OpenView ov = new OpenView();    
    
    //Homepage Objects
    @FXML
    private Button btnMember;
    @FXML
    private Button btnTest;
    
   
        
    //Add New Game Form Objects!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    
    @FXML
    private Button btnBack;
    @FXML
    private TextArea textAddress;
    @FXML
    private TextField textID;
    @FXML
    private TextField textNickname;
    @FXML
    private Button btnSave;
    @FXML
    private TextField textDob;
    @FXML
    private TextField textType;
    @FXML
    private Button btnClear;
    @FXML
    private TextField textPhone;
    
    //Add Member page Objects! Add Member page Objects! Add Member page Objects! Add Member page Objects! Add Member page Objects!
    
    @FXML
    private TextField textTitle;
    @FXML
    private TextField textGameID;
    @FXML
    private TextField textRating;
    @FXML
    private Button btnGameSave;
    @FXML
    private TextField textPlatform;
    @FXML
    private TextField textGameType;
    @FXML
    private Button btnGameClear;
    @FXML
    private TextField textMultiplayer;
    
    
    //End of objects declaration! End of objects declaration! End of objects declaration! End of objects declaration! 
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
    private void goToEventsManagement(ActionEvent event) throws IOException {
       ov.open(event, "EventsManagement.fxml"); 
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
    

    private ObservableList<members> memberData;
    private ObservableList<Game> gameData;
    //Connection variable
    private dbConnection dbc;
    
    Statement stmt;
    ResultSet rs;
    
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        dbc=new dbConnection();
        
    }
    
    
    @FXML
    private void btnSave(ActionEvent event) throws SQLException {                                              
            
        
        String colId = textID.getText();
        String colNickname = textNickname.getText();
        String colAddress = textAddress.getText();
        String colDob = textDob.getText();
        String colPhone = textPhone.getText();
        String colType = textType.getText();
        int newID = Integer.parseInt(colId);
        int telNumber = Integer.parseInt(colPhone);
        
        try{
            
            Connection conn= dbc.Connect();
            ResultSet rs = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery("SELECT * FROM GAMES.MEMBERS");
            
            rs.moveToInsertRow( );
            
            rs.updateInt("ID", newID);
            rs.updateInt("TELEPHONE", telNumber);
            rs.updateString("NAME", colNickname);
            rs.updateString("ADDRESS", colAddress);
            rs.updateString("TYPE", colType);
            rs.updateString("DOB", colDob);
            
            rs.insertRow( );
            
            
            rs.close( );
           
            String sql = "SELECT * FROM GAMES.MEMBERS";
           

            rs.next( );
            int id_col = rs.getInt("ID");
            String ID = Integer.toString(id_col);
            String NICK = rs.getString("NAME");

            textID.setText(ID);
            textNickname.setText(NICK);
               
        }
        catch (SQLException err) {
            System.out.println(err.getMessage());
        }  
    }       
   
    @FXML
    private void btnSaveGame(ActionEvent event) throws SQLException {                                              
            
        
        String colId = textGameID.getText();
        String colTitle = textTitle.getText();
        String colRating = textRating.getText();
        String colPlatform = textPlatform.getText();
        String colType = textGameType.getText();
        String colMultiplayer = textMultiplayer.getText();
        int newGameID = Integer.parseInt(colId);
        
        try{
            
            Connection conn= dbc.Connect();
            ResultSet rs = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery("SELECT * FROM GAMES.GAMES");
            
            rs.moveToInsertRow( );
            
            rs.updateInt("GAMEID", newGameID);
            rs.updateString("NAME", colTitle);
            rs.updateString("RATING", colRating);
            rs.updateString("PLATFORM", colPlatform);
            rs.updateString("TYPE", colType);
            rs.updateString("MULTIPLAYER", colMultiplayer);
            
            rs.insertRow( );
            
            
            rs.close( );
           
            String sql = "SELECT * FROM GAMES.GAMES";
           

            rs.next( );
            int id_col = rs.getInt("ID");
            String ID = Integer.toString(id_col);
            String NICK = rs.getString("NAME");

            textID.setText(ID);
            textNickname.setText(NICK);
               
        }
        catch (SQLException err) {
            System.out.println(err.getMessage());
        }  
    }
}
