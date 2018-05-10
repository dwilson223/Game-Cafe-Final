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
public class MembersManagementController implements Initializable {
    
    @FXML
    private OpenView ov = new OpenView(); 

    @FXML
    private TableView<?> table;
    @FXML
    private TableColumn<?, ?> mId;
    @FXML
    private TableColumn<?, ?> mName;
    @FXML
    private TableColumn<?, ?> mDob;
    @FXML
    private TableColumn<?, ?> mAddress;
    @FXML
    private TableColumn<?, ?> mTel;
    @FXML
    private TableColumn<?, ?> mType;
    @FXML
    private Button btnLoad;
    @FXML
    private Button btnAddMember;
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
    private void loadData(ActionEvent event) {
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
    /* _______________________________________________________________________ */
    
    
}
