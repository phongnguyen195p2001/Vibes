/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject.a;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Khanh NH
 */
public class User {
    private ObjectProperty<Integer> userId;
    private StringProperty userName;
    private StringProperty password;
    private StringProperty name;
    private StringProperty phone;
    private StringProperty email;

    public User() {
        userId = new SimpleObjectProperty<>(null);
        userName = new SimpleStringProperty();
        password = new SimpleStringProperty();
        name = new SimpleStringProperty();
        phone = new SimpleStringProperty();
        email = new SimpleStringProperty();
    }

    public Integer getId() {
        return userId.get();
    }

    public String getUserName() {
        return userName.get();
    }

    public String getPassword() {
        return password.get();
    }
    
    public String getFullName() {
        return name.get();
    }

    public String getPhone() {
        return phone.get();
    }

    public String getEmail() {
        return email.get();
    }

    public void setId(int id) {
        this.userId.set(id);
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }

    public void setPassword(String password) {
        this.password.set(password);
    }
    
    public void setFullName(String fullName) {
        this.name.set(fullName);
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public ObjectProperty<Integer> getIdProperty() {
        return this.userId;
    }

    public StringProperty getUserNameProperty() {
        return this.userName;
    }

    public StringProperty getPasswordProperty() {
        return this.password;
    }
    
    public StringProperty getFullNameProperty() {
        return this.name;
    }

    public StringProperty getPhoneProperty() {
        return this.phone;
    }

    public StringProperty getEmailProperty() {
        return this.email;
    }

    public static ObservableList<User> selectAll() {
        ObservableList<User> teachers = FXCollections.observableArrayList();

        try (Connection conn = DbCon.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM user");) {
            while (rs.next()) {
                User t = new User();
                t.setId(rs.getInt("userId"));
                t.setFullName(rs.getString("name"));
                t.setUserName(rs.getString("userName"));
                t.setPassword(rs.getString("password"));
                t.setPhone(rs.getString("phone"));
                t.setEmail(rs.getString("email"));

                teachers.add(t);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return teachers;
    }

    public static User insert(User newUser) throws SQLException {
        String sql = "INSERT into user (name, userName, password, phone, email) " + "VALUE (?, ?, ?, ?, ?)";
        ResultSet key = null;
        try (Connection conn = DbCon.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            stmt.setString(1, newUser.getFullName());
            stmt.setString(2, newUser.getUserName());
            stmt.setString(3, newUser.getPassword());
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
                System.out.println("No admin inserted!!!");
                return null;
            }
        } catch (Exception e) {
            System.err.println(e);
            return null;
        } finally {
            if (key != null) {
                key.close();
            }
        }
    }

    public static boolean update(User updateUser) {
        String sql = "UPDATE user SET "
                + "name = ?, "
                + "userName = ?, "
                + "password = ?, "
                + "phone = ?, "
                + "email = ? "
                + "WHERE userId = ?";
        try (Connection conn = DbCon.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, updateUser.getFullName());
            stmt.setString(2, updateUser.getUserName());
            stmt.setString(3, updateUser.getPassword());
            stmt.setString(4, updateUser.getPhone());
            stmt.setString(5, updateUser.getEmail());
            stmt.setInt(6, updateUser.getId());

            int rowUpdate = stmt.executeUpdate();
            if (rowUpdate == 1) {
                return true;
            } else {
                System.err.println("No user update");
                return false;
            }
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    public static boolean delete(User deleteUser) {
        String sql = "DELETE FROM user WHERE userId = ?";
        try (Connection conn = DbCon.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, deleteUser.getId());
            int rowDelete = stmt.executeUpdate();

            if (rowDelete == 1) {
                return true;
            } else {
                System.err.println("No user delete");
                return false;
            }
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }
}
