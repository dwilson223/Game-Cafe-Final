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
public class members {

    private final StringProperty id;
    private final StringProperty name;
    private final StringProperty dob;
    private final StringProperty address;
    private final StringProperty telephone;
    private final StringProperty type;

    public members(String id, String name, String dob, String address, String telephone, String type) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.dob = new SimpleStringProperty(dob);
        this.address = new SimpleStringProperty(address);
        this.telephone = new SimpleStringProperty(telephone);
        this.type = new SimpleStringProperty(type);
    }

    //GETTERS
    public String getId() {
        return id.get();
    }

    public String getName() {
        return name.get();
    }

    public String getDob() {
        return dob.get();
    }

    public String getAddress() {
        return address.get();
    }

    public String getTelephone() {
        return telephone.get();
    }

    public String getType() {
        return type.get();
    }

    //SETTERS
    public void setId(String value) {
        id.set(value);
    }

    public void setName(String value) {
        name.set(value);
    }

    public void setDob(String value) {
        dob.set(value);
    }

    public void setAddress(String value) {
        address.set(value);
    }

    public void setTelephone(String value) {
        telephone.set(value);
    }

    public void setType(String value) {
        type.set(value);
    }

    //Values
    public StringProperty idProperty() {
        return id;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty dobProperty() {
        return dob;
    }

    public StringProperty addressProperty() {
        return address;
    }

    public StringProperty telephoneProperty() {
        return telephone;
    }

    public StringProperty typeProperty() {
        return type;
    }

}
