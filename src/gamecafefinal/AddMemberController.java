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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author Dave
 */
public class AddMemberController implements Initializable{
    
    @FXML
    private OpenView ov = new OpenView(); 
    
    @FXML
    private TextField textFirstName;
    @FXML
    private TextField textLastName;
    @FXML
    private TextField textNickname;
    @FXML
    private TextField textAge;
    @FXML
    private TextField textDob;
    @FXML
    private TextField textType;
    @FXML
    private TextArea textAddress1;
    @FXML
    private TextArea textAddress2;
    @FXML
    private TextField textCity;
    @FXML
    private TextField textCountry;
    @FXML
    private TextField textPostcode;
    
    @FXML
    private Button btnBack;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnClear;
    
    private dbConnection dbc;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          dbc=new dbConnection();
       
             
    }
     @FXML
    private void btnSave(ActionEvent event) throws SQLException, IOException {  
        
        
            
        
        String colFirstName = textFirstName.getText();
        String colLastName = textLastName.getText();
        String colNickname = textNickname.getText();
        String colAge = textAge.getText();
        String colDob = textDob.getText();
        String colType = textType.getText();
        String colAddress1 = textAddress1.getText();
        String colAddress2 = textAddress2.getText();
        String colCity = textCity.getText();
        String colCountry = textCountry.getText();
        String colPostcode = textPostcode.getText();
        int newAge = Integer.parseInt(colAge);
      
        try{
            
            Connection conn= dbc.Connect();
            ResultSet rs = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery("SELECT * FROM TEAM.MEMBER");
            
            rs.moveToInsertRow( );
            
            
            rs.updateString("FIRSTNAME", colFirstName);
            rs.updateString("LASTNAME", colLastName);
            rs.updateString("NICKNAME", colNickname);
            rs.updateInt("AGE", newAge);
            rs.updateString("DOB", colDob);
            rs.updateString("TYPE", colType);
            rs.updateString("ADDRESSLINE1", colAddress1);
            rs.updateString("ADDRESSLINE2", colAddress2);
            rs.updateString("CITY", colCity);
            rs.updateString("COUNTRY", colCountry);
            rs.updateString("POSTCODE", colPostcode);
      
      
            
            rs.insertRow( );
            
            
            rs.close( );
            
            goToMembersManagement(event);
      
        }
        catch (SQLException err) {
            System.out.println(err.getMessage());
        }  
        
        
        
        
        
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
