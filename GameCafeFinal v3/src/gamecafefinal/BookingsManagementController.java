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

/**
 * FXML Controller class
 *
 * @author kayaya
 */
public class BookingsManagementController implements Initializable {
    @FXML
    private OpenView ov = new OpenView(); 
    
        @FXML
    private void goToDashboard(ActionEvent event) throws IOException {
       ov.open(event, "Dashboard-home.fxml"); 
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
