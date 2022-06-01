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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Admin
 */
public class AdminDaoImpl implements AdminDao{
    public DbType database = DbType.SQLSERVER;
    
    @Override
    public ObservableList<Admin> selectAll() {
        ObservableList<Admin> Admins = FXCollections.observableArrayList();
        
        try (
                Connection conn = DbFactory.getConnection(database);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM admin");) {
            while (rs.next()) {
                Admin b = new Admin();
                b.setId(rs.getInt("adminId"));
                b.setUserName(rs.getString("userName"));
                b.setPassword(rs.getString("password"));
                b.setFullName(rs.getString("fullname"));
                b.setPhone(rs.getString("phone"));
                b.setEmail(rs.getString("email")); 

                Admins.add(b);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return Admins;
    }
    
    @Override
    public Admin insert(Admin newAdmin) {
        String sql = "INSERT into user (userName, password,  fullname, phone, email) "
                + "VALUES (?, sha1(?), ?, ?, ? )";
        ResultSet key = null;
        try (

                Connection conn = DbFactory.getConnection(database);
                PreparedStatement stmt
                = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
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
                newAdmin.setId(newKey);
                return newAdmin;
            } else {
                System.err.println("No user inserted");
                return null;
            }

        } catch (Exception e) {
            System.err.println(e);
            return null;
        } finally {
            try {
                if (key != null) key.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }
    
    @Override
    public boolean delete(Admin deleteAdmin) {
        String sql = "DELETE FROM admin WHERE adminId = ?";
        try (

                Connection conn = DbFactory.getConnection(database);
                PreparedStatement stmt = conn.prepareStatement(sql);) {

            stmt.setInt(1, deleteAdmin.getId());

            int rowDeleted = stmt.executeUpdate();

            if (rowDeleted == 1) {
                return true;
            } else {
                System.err.println("No admin deleted");
                return false;
            }

        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }
    
    @Override
    public boolean update(Admin updateAdmin) {
        String sql = "UPDATE admin SET "
                + "userName = ?, "
                + "password = ?, "
                + "fullname = ?, "
                + "phone = ?, "
                + "email = ? "
                + "WHERE adminId = ?";
        try (
//                Connection conn = DbService.getConnection();
                Connection conn = DbFactory.getConnection(database);
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, updateAdmin.getUserName());
            stmt.setString(2, updateAdmin.getPassword());
            stmt.setString(3, updateAdmin.getFullName());
            stmt.setString(4, updateAdmin.getPhone());
            stmt.setString(5, updateAdmin.getEmail());
            stmt.setInt(6, updateAdmin.getId());

            int rowUpdated = stmt.executeUpdate();

            if (rowUpdated == 1) {
                return true;
            } else {
                System.err.println("No admin updated");
                return false;
            }

        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }
}
