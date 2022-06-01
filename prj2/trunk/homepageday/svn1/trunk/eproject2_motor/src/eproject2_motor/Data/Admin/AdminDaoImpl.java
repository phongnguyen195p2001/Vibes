/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor.Data.Admin;

import eproject2_motor.Dbconnection.DbFactory;
import eproject2_motor.Dbconnection.DbType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Admin
 */
public class AdminDaoImpl implements AdminDao{
    public DbType database = DbType.MYSQL
            ;
    
    public ObservableList<Admin> selectAll() {
        ObservableList<Admin> admin = FXCollections.observableArrayList();

        try (Connection conn = DbFactory.getConnection(database);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM admin");) {
            while (rs.next()) {
                Admin ad = new Admin();
                ad.setAdminId(rs.getInt("adminId"));
                ad.setUserName(rs.getString("userName"));
                ad.setPassword(rs.getString("password"));
                ad.setFullName(rs.getString("fullName"));
                ad.setPhone(rs.getString("phone"));
                ad.setEmail(rs.getString("email"));

                admin.add(ad);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return admin;
    }

    @Override
    public Admin insert(Admin newAdmin){
        String sql = "INSERT into admin (userName, password, fullName, phone, email) " + "VALUE (?, ?, ?, ?, ?)";
        ResultSet key = null;
        try (Connection conn = DbFactory.getConnection(database);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            stmt.setString(1, newAdmin.getUserName());
            stmt.setString(2, newAdmin.getPassword());
            stmt.setString(3, newAdmin.getFullName());
            stmt.setString(4, newAdmin.getPhone());
            stmt.setString(5, newAdmin.getEmail());
            int rowInserted = stmt.executeUpdate();

            if (rowInserted == 1) {
                key = stmt.getGeneratedKeys();
                key.next();
                int newKey = key.getInt(1);
                newAdmin.setAdminId(newKey);
                return newAdmin;
            } else {
                System.out.println("No admin inserted!!!");
                return null;
            }
        } catch (Exception e) {
            System.err.println(e);
            return null;
        } finally {
            if (key != null) {
                try {
                    key.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AdminDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public boolean update(Admin updateAdmin) {
        String sql = "UPDATE admin SET "
                + "userName = ?, "
                + "password = ?, "
                + "fullName = ?, "
                + "phone = ?, "
                + "email = ? "
                + "WHERE adminId = ?";
        try (Connection conn = DbFactory.getConnection(database);
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, updateAdmin.getUserName());
            stmt.setString(2, updateAdmin.getPassword());
            stmt.setString(3, updateAdmin.getFullName());
            stmt.setString(4, updateAdmin.getPhone());
            stmt.setString(5, updateAdmin.getEmail());
            stmt.setInt(6, updateAdmin.getAdminId());

            int rowUpdate = stmt.executeUpdate();
            if (rowUpdate == 1) {
                return true;
            } else {
                System.err.println("No admin update");
                return false;
            }
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    public boolean delete(Admin deleteAdmin) {
        String sql = "DELETE FROM admin WHERE adminId = ?";
        try (Connection conn = DbFactory.getConnection(database);
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, deleteAdmin.getAdminId());
            int rowDelete = stmt.executeUpdate();

            if (rowDelete == 1) {
                return true;
            } else {
                System.err.println("No teacher delete");
                return false;
            }
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }
}
