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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author kayaya
 */
    
    

public class EventsManagementController implements Initializable {
    
    @FXML
    private OpenView ov = new OpenView(); 
    
    @FXML
    private TableView<Event> etable;  
    @FXML
    private TableColumn<Event, String> eId;
    @FXML
    private TableColumn<Event, String> eType;
    @FXML
    private TableColumn<Event, String> eDescription;
    @FXML
    private TableColumn<Event, String> eDate;
    @FXML
    private TableColumn<Event, String> eTime;
    @FXML
    private TableColumn<Event, String> eAvailability;
    
    
    private ObservableList<Event> eventData;
    private dbConnection dbc;
    Statement stmt;
    ResultSet rs;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         dbc=new dbConnection();
         loadEventData();
    }  
    @FXML
    private void loadEventData() {
        try {
            Connection conn= dbc.Connect();
            eventData = FXCollections.observableArrayList();
        
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM TEAM.EVENT");
            
            while (rs.next()) {
            
                eventData.add(new Event(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
        
            }
        } catch (SQLException ex) {
            //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error:" + ex);
        }
        
       
        eId.setCellValueFactory(new PropertyValueFactory<>("eventid"));
        eType.setCellValueFactory(new PropertyValueFactory<>("type"));
        eDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        eDate.setCellValueFactory(new PropertyValueFactory<>("time"));
        eTime.setCellValueFactory(new PropertyValueFactory<>("avablilty"));
        eAvailability.setCellValueFactory(new PropertyValueFactory<>("date"));
        
         
        
        etable.setItems(null);
        etable.setItems(eventData);
    
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
