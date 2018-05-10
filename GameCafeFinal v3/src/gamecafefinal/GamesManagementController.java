/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamecafefinal;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author kayaya
 */
public class GamesManagementController implements Initializable {
    @FXML
    private OpenView ov = new OpenView(); 

    @FXML
    private TableView<?> gTable;
    @FXML
    private TableColumn<?, ?> gId;
    @FXML
    private TableColumn<?, ?> gTitle;
    @FXML
    private TableColumn<?, ?> gRating;
    @FXML
    private TableColumn<?, ?> gPlatform;
    @FXML
    private TableColumn<?, ?> gType;
    @FXML
    private TableColumn<?, ?> gMultiplayer;
    @FXML
    private Button btnLoadGames;
    @FXML
    private Button btnNewGame;
    @FXML
    private Button btnBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadGameData(ActionEvent event) {
    }

    @FXML
    private void changeSceneAction(ActionEvent event) {
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
