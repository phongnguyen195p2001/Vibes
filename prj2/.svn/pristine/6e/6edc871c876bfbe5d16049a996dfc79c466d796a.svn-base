/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor.Data.Admin;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Admin
 */
public class Admin {
    private ObjectProperty<Integer> adminId;
    private StringProperty userName;
    private StringProperty password;
    private StringProperty fullName;
    private StringProperty phone;
    private StringProperty email;
    
    public Admin(){
        adminId = new SimpleObjectProperty<>(null);
        fullName = new SimpleStringProperty();
        userName = new SimpleStringProperty();
        password = new SimpleStringProperty();
        phone = new SimpleStringProperty();
        email = new SimpleStringProperty();
    }
    
    public Integer getId() {
        return adminId.get();
    }
    
    public String getUserName() {
        return userName.get();
    }
    
    public String getPassword() {
        return password.get();
    }
    
    public String getFullName() {
        return fullName.get();
    }
    
    public String getPhone() {
        return phone.get();
    }
    
    public String getEmail() {
        return email.get();
    }
    
    public void setId(int adminId) {
        this.adminId.set(adminId);
    }
    
    public void setFullName(String fullName) {
        this.fullName.set(fullName);
    }
    
    public void setUserName(String userName) {
        this.userName.set(userName);
    }
    
    public void setPassword(String password) {
        this.password.set(password);
    }
    
    public void setPhone(String phone) {
        this.phone.set(phone);
    }
    
    public void setEmail(String email) {
        this.email.set(email);
    }
    

    public ObjectProperty<Integer> getAdminIdProperty() {
        return adminId;
    }
    
    public StringProperty getFullNameProperty() {
        return fullName;
    }

    public StringProperty getUserNameProperty() {
        return userName;
    }

    public StringProperty getPasswordProperty() {
        return password;
    }

    public StringProperty getPhoneProperty() {
        return phone;
    }

    public StringProperty getEmailProperty() {
        return email;
    }
}
