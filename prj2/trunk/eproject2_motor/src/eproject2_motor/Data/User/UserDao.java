/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor.Data.User;

import javafx.collections.ObservableList;

/**
 *
 * @author Admin
 */
public interface UserDao {
    public ObservableList<User> selectAll();
    public User insert(User newSignUp);
    public boolean update(User updateSignUp);
    public boolean delete(User deleteSignUp);
}
