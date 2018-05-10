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
public class GamesManagementController implements Initializable {
    @FXML
    private OpenView ov = new OpenView(); 

    @FXML
    private TableView<Game> gTable;
    @FXML
    private TableColumn<Game, String> gId;
    @FXML
    private TableColumn<Game, String> gTitle;
    @FXML
    private TableColumn<Game, String> gRating;
    @FXML
    private TableColumn<Game, String> gPlatform;
    @FXML
    private TableColumn<Game, String> gType;
    @FXML
    private TableColumn<Game, String> gMultiplayer;
 
    
    @FXML
    private Button btnNewGame;
    @FXML
    private Button btnBack;

    private ObservableList<Game> gameData;
    private dbConnection dbc; 
    Statement stmt;
    ResultSet rs;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dbc=new dbConnection();
        loadGameData();
    }    

    @FXML
    private void loadGameData() 
    {
        try {
            Connection conn= dbc.Connect();
            gameData = FXCollections.observableArrayList();
        
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM TEAM.GAME");
            while (rs.next()) {
            
            gameData.add(new Game(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
        
            }
        } catch (SQLException ex) {
            //Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error:" + ex);
        }
        
        gId.setCellValueFactory(new PropertyValueFactory<>("gameId"));
        gTitle.setCellValueFactory(new PropertyValueFactory<>("name"));
        gRating.setCellValueFactory(new PropertyValueFactory<>("rating"));
        gPlatform.setCellValueFactory(new PropertyValueFactory<>("platform"));
        gType.setCellValueFactory(new PropertyValueFactory<>("type"));
        gMultiplayer.setCellValueFactory(new PropertyValueFactory<>("multiplayer"));
        
        
        gTable.setItems(null);
        gTable.setItems(gameData);
        
     
    }
    
/* ----------------------- View Management ------------------------------ */
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
    
}
