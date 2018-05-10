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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


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
    
    //Membership management objects! Membership management objects! Membership management objects! Membership management objects!
    @FXML
    private Button btnAddMember;
    @FXML
    private TableView<members> table;
    @FXML
    private TableColumn<members, String> mId;
    @FXML
    private TableColumn<members, String> mName;
    @FXML
    private TableColumn<members, String> mDob;
    @FXML
    private TableColumn<members, String> mAddress;
    @FXML
    private TableColumn<members, String> mTel;
    @FXML
    private TableColumn<members, String> mType;
    
    //Games Management objects! Game Management objects! Game Management objects!
    @FXML
    private Button btnLoadGames;
    @FXML
    private Button btnGameLib;
    @FXML
    private Button btnNewGame;
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
    
    
    // Method for changing between scenes
    @FXML
    private void changeSceneAction(ActionEvent event) throws IOException {
    Stage stage = null;
    Parent root = null;
    if(event.getSource()==btnMember){
        
        stage=(Stage) btnMember.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("FXMLMemberManagement.fxml"));
    }else if (event.getSource()==btnTest) {
                stage=(Stage) btnTest.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("FXMLTest.fxml"));
        
    }else if (event.getSource()==btnAddMember) {
                stage=(Stage) btnAddMember.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("AddMemberPage.fxml"));
                
    }else if (event.getSource()==btnGameLib) {
                stage=(Stage) btnGameLib.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("GamesManagement.fxml"));
                
    }else if (event.getSource()==btnNewGame) {
                stage=(Stage) btnNewGame.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("AddGamePage.fxml"));
    }else if (event.getSource()==btnNewGame) {
                stage=(Stage) btnNewGame.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("AddGamePage.fxml")); 
    }else{
        stage=(Stage) btnBack.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
    }
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
    }
    
    //Will hold data
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
    private void loadData(ActionEvent event) {
        try {
            Connection conn= dbc.Connect();
            memberData = FXCollections.observableArrayList();
        
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM GAMES.MEMBERS");
            while (rs.next()) {
            
            memberData.add(new members(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
        
            }
        } catch (SQLException ex) {
            //Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error:" + ex);
        }
        
        mId.setCellValueFactory(new PropertyValueFactory<>("id"));
        mName.setCellValueFactory(new PropertyValueFactory<>("name"));
        mDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        mAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        mTel.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        mType.setCellValueFactory(new PropertyValueFactory<>("type"));
        
        table.setItems(null);
        table.setItems(memberData);
        
        System.out.println("test two");
    }
    
    @FXML
    private void loadGameData(ActionEvent event) {
        try {
            Connection conn= dbc.Connect();
            gameData = FXCollections.observableArrayList();
        
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM GAMES.GAMES");
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
        
        System.out.println("test two");
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
