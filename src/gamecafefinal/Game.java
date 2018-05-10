/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamecafefinal;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Dave
 */
public class Game {
    
    
    private final StringProperty gameId;
    private final StringProperty name;
    private final StringProperty rating;
    private final StringProperty platform;
    private final StringProperty multiplayer;
    private final StringProperty type;

    public Game(String gameId, String name, String multiplayer, String type, String rating, String platform) {
        this.gameId = new SimpleStringProperty(gameId);
        this.name = new SimpleStringProperty(name);
        this.rating = new SimpleStringProperty(rating);
        this.platform = new SimpleStringProperty(platform);
        this.multiplayer = new SimpleStringProperty(multiplayer);
        this.type = new SimpleStringProperty(type);
    }

    //GETTERS
    public String getGameId() {
        return gameId.get();
    }

    public String getName() {
        return name.get();
    }

    public String getRating() {
        return rating.get();
    }

    public String getPlatform() {
        return platform.get();
    }

    public String getMultiplayer() {
        return multiplayer.get();
    }

    public String getType() {
        return type.get();
    }

    //SETTERS
    public void setGameId(String value) {
        gameId.set(value);
    }

    public void setName(String value) {
        name.set(value);
    }

    public void setRating(String value) {
        rating.set(value);
    }

    public void setPlatform(String value) {
        platform.set(value);
    }

    public void setMultiplayer(String value) {
        multiplayer.set(value);
    }

    public void setType(String value) {
        type.set(value);
    }

    //Values
    public StringProperty gameIdProperty() {
        return gameId;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty ratingProperty() {
        return rating;
    }

    public StringProperty platformProperty() {
        return platform;
    }

    public StringProperty multiplayerProperty() {
        return multiplayer;
    }

    public StringProperty typeProperty() {
        return type;
    }
    
    //Checks
    
    public boolean checkGameId(int number){
        if(number > 0){
            return true;
        }
        return false;
    }

    
}
