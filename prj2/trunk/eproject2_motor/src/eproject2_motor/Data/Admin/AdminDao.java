/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor.Data.Admin;


import javafx.collections.ObservableList;

/**
 *
 * @author Admin
 */
public interface AdminDao {
    public ObservableList<Admin> selectAll();
    public Admin insert(Admin newAdmin);
    public boolean update(Admin updateAdmin);
    public boolean delete(Admin deleteAdmin);
}
