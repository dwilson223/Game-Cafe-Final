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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author kayaya
 */
public class MembersManagementController implements Initializable {
    
    @FXML
    private OpenView ov = new OpenView(); 
    
    @FXML
    private TableView<Member> table;  
    @FXML
    private TableColumn<Member, String> mId;
    @FXML
    private TableColumn<Member, String> mFirstName;
    @FXML
    private TableColumn<Member, String> mLastName;
    @FXML
    private TableColumn<Member, String> mNickname;
    @FXML
    private TableColumn<Member, String> mAge;
    @FXML
    private TableColumn<Member, String> mDob;
    @FXML
    private TableColumn<Member, String> mType;
    @FXML
    private TableColumn<Member, String> mAddress1;
    @FXML
    private TableColumn<Member, String> mAddress2;
    @FXML
    private TableColumn<Member, String> mCity;
    @FXML
    private TableColumn<Member, String> mCountry;
    @FXML
    private TableColumn<Member, String> mPostcode;
    @FXML
    private Button btnAddMember;
    @FXML
    private Button btnBack;

    private ObservableList<Member> memberData;
    private dbConnection dbc;
    Statement stmt;
    ResultSet rs;
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        dbc=new dbConnection();
        loadData();
        
    }    

    @FXML
    private void loadData() {
        try {
            Connection conn= dbc.Connect();
            memberData = FXCollections.observableArrayList();
        
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM TEAM.MEMBER");
            
            while (rs.next()) {
            
                memberData.add(new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12)));
        
            }
        } catch (SQLException ex) {
            //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error:" + ex);
        }
        
        
                
        mId.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        //mFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        mLastName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        mNickname.setCellValueFactory(new PropertyValueFactory<>("nickname"));
        mAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        mDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        mType.setCellValueFactory(new PropertyValueFactory<>("type"));
        mAddress1.setCellValueFactory(new PropertyValueFactory<>("fullAddress"));
        //mAddress2.setCellValueFactory(new PropertyValueFactory<>("address2"));
        //mCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        //mCountry.setCellValueFactory(new PropertyValueFactory<>("country"));
        //mPostcode.setCellValueFactory(new PropertyValueFactory<>("postcode"));
         
        
        table.setItems(null);
        table.setItems(memberData);
    
    }

    @FXML
    private void changeSceneAction(ActionEvent event) {
    }
    
/* ----------------------- View Management ------------------------------ */
    @FXML
    private void goToGamesManagement(ActionEvent event) throws IOException {
       ov.open(event, "GamesManagement.fxml"); 
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
    @FXML
    private void goToAddMemberPage(ActionEvent event) throws IOException {
       ov.open(event, "AddMemberPage.fxml"); 
    }
    /* _______________________________________________________________________ */
    
    
    
}
