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
public class UserDaoImpl implements UserDao {

    public DbType database = DbType.SQLSERVER;

    @Override
    public ObservableList<User> selectAll() {
        ObservableList<User> user = FXCollections.observableArrayList();

        try (
                Connection conn = DbFactory.getConnection(database);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM user");) {
            while (rs.next()) {
                User b = new User();
                b.setUserName(rs.getString("userName"));                
                b.setPassword(rs.getString("password"));
                b.setFullName(rs.getString("fullName"));
                b.setPhone(rs.getString("phone"));
                b.setEmail(rs.getString("email"));

                user.add(b);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return user;
    }

    @Override
    public User insert(User newUser) {
        String sql = "INSERT into user (userName, password, fullName, phone, email) "
                + "VALUES (?, sha1(?), ?, ?, ? )";
        ResultSet key = null;
        try (
                Connection conn = DbFactory.getConnection(database);
                PreparedStatement stmt
                = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            stmt.setString(1, newUser.getUserName());
            stmt.setString(2, newUser.getPassword());
            stmt.setString(3, newUser.getFullName());
            stmt.setString(4, newUser.getPhone());
            stmt.setString(5, newUser.getEmail());

            int rowInserted = stmt.executeUpdate();

            if (rowInserted == 1) {
                key = stmt.getGeneratedKeys();
                key.next();
                int newKey = key.getInt(1);
                newUser.setId(newKey);
                return newUser;
            } else {
                System.err.println("No user inserted");
                return null;
            }

        } catch (Exception e) {
            System.err.println(e);
            return null;
        } finally {
            try {
                if (key != null) {
                    key.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }

    @Override
    public boolean delete(User deleteUser) {
        String sql = "DELETE FROM user WHERE userId = ?";
        try (
                Connection conn = DbFactory.getConnection(database);
                PreparedStatement stmt = conn.prepareStatement(sql);) {

            stmt.setInt(1, deleteUser.getId());

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
    public boolean update(User updateUser) {
        String sql = "UPDATE user SET "
                + "userName = ?, "
                + "password = ?, "
                + "fullName = ?, "
                + "phone = ?, "
                + "email = ? "
                + "WHERE userId = ?";
        try (
                //                Connection conn = DbService.getConnection();
                Connection conn = DbFactory.getConnection(database);
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, updateUser.getUserName());
            stmt.setString(2, updateUser.getPassword());
            stmt.setString(3, updateUser.getFullName());
            stmt.setString(4, updateUser.getPhone());
            stmt.setString(5, updateUser.getEmail());
            stmt.setInt(6, updateUser.getId());

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
