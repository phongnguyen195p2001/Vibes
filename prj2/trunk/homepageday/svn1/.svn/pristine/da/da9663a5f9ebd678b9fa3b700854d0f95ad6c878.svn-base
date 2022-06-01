/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor.Data.User;

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
public class UserDaoImpl implements UserDao{
    public DbType database = DbType.SQLSERVER;
    
    @Override
    public ObservableList<User> selectAll() {
        ObservableList<User> SignUps = FXCollections.observableArrayList();
        
        try (
                Connection conn = DbFactory.getConnection(database);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM user");) {
            while (rs.next()) {
                User b = new User();
                b.setId(rs.getInt("userId")); 
                b.setUserName(rs.getString("name"));
                b.setUserName(rs.getString("userName"));
                b.setPassword(rs.getString("password"));
                b.setPhone(rs.getString("phone"));
                b.setEmail(rs.getString("email")); 

                SignUps.add(b);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return SignUps;
    }
    
    @Override
    public User insert(User newSignUp) {
        String sql = "INSERT into user (name, userName, password, phone, email) "
                + "VALUES (?, ?, sha1(?), ?, ? )";
        ResultSet key = null;
        try (

                Connection conn = DbFactory.getConnection(database);
                PreparedStatement stmt
                = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            stmt.setString(1, newSignUp.getName());
            stmt.setString(2, newSignUp.getUserName());
            stmt.setString(3, newSignUp.getPassword());
            stmt.setString(4, newSignUp.getPhone());
            stmt.setString(5, newSignUp.getEmail());

            int rowInserted = stmt.executeUpdate();

            if (rowInserted == 1) {
                key = stmt.getGeneratedKeys();
                key.next();
                int newKey = key.getInt(1);
                newSignUp.setId(newKey);
                return newSignUp;
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
    public boolean delete(User deleteSignUp) {
        String sql = "DELETE FROM user WHERE id = ?";
        try (

                Connection conn = DbFactory.getConnection(database);
                PreparedStatement stmt = conn.prepareStatement(sql);) {

            stmt.setInt(1, deleteSignUp.getId());

            int rowDeleted = stmt.executeUpdate();

            if (rowDeleted == 1) {
                return true;
            } else {
                System.err.println("No user deleted");
                return false;
            }

        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }
    
    @Override
    public boolean update(User updateSignUp) {
        String sql = "UPDATE user SET "
                + "name = ?, "
                + "userName = ?, "
                + "password = ?, "
                + "phone = ?, "
                + "email = ? "
                + "WHERE userId = ?";
        try (
//                Connection conn = DbService.getConnection();
                Connection conn = DbFactory.getConnection(database);
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, updateSignUp.getName());
            stmt.setString(2, updateSignUp.getUserName());
            stmt.setString(3, updateSignUp.getPassword());
            stmt.setString(5, updateSignUp.getPhone());
            stmt.setString(6, updateSignUp.getEmail());
            stmt.setInt(7, updateSignUp.getId());

            int rowUpdated = stmt.executeUpdate();

            if (rowUpdated == 1) {
                return true;
            } else {
                System.err.println("No user updated");
                return false;
            }

        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

  
}
