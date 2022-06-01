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
public class Admin {

    private ObjectProperty<Integer> adminId;
    private StringProperty userName;
    private StringProperty password;
    private StringProperty fullName;
    private StringProperty phone;
    private StringProperty email;

    public Admin() {
        adminId = new SimpleObjectProperty<>(null);
        userName = new SimpleStringProperty();
        password = new SimpleStringProperty();
        fullName = new SimpleStringProperty();
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

    public void setId(int id) {
        this.adminId.set(id);
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }

    public void setPassword(String password) {
        this.password.set(password);
    }
    
    public void setFullName(String fullName) {
        this.fullName.set(fullName);
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public ObjectProperty<Integer> getIdProperty() {
        return this.adminId;
    }

    public StringProperty getUserNameProperty() {
        return this.userName;
    }

    public StringProperty getPasswordProperty() {
        return this.password;
    }
    
    public StringProperty getFullNameProperty() {
        return this.fullName;
    }

    public StringProperty getPhoneProperty() {
        return this.phone;
    }

    public StringProperty getEmailProperty() {
        return this.email;
    }

    public static ObservableList<Admin> selectAll() {
        ObservableList<Admin> teachers = FXCollections.observableArrayList();

        try (Connection conn = DbCon.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM admin");) {
            while (rs.next()) {
                Admin t = new Admin();
                t.setId(rs.getInt("adminId"));
                t.setUserName(rs.getString("userName"));
                t.setPassword(rs.getString("password"));
                t.setFullName(rs.getString("fullName"));
                t.setPhone(rs.getString("phone"));
                t.setEmail(rs.getString("email"));

                teachers.add(t);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return teachers;
    }

    public static Admin insert(Admin newAdmin) throws SQLException {
        String sql = "INSERT into admin (userName, password, fullName, phone, email) " + "VALUE (?, ?, ?, ?, ?)";
        ResultSet key = null;
        try (Connection conn = DbCon.getConnection();
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
                newAdmin.setId(newKey);
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
                key.close();
            }
        }
    }

    public static boolean update(Admin updateAdmin) {
        String sql = "UPDATE admin SET "
                + "userName = ?, "
                + "password = ?, "
                + "fullName = ?, "
                + "phone = ?, "
                + "email = ? "
                + "WHERE adminId = ?";
        try (Connection conn = DbCon.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, updateAdmin.getUserName());
            stmt.setString(2, updateAdmin.getPassword());
            stmt.setString(3, updateAdmin.getFullName());
            stmt.setString(4, updateAdmin.getPhone());
            stmt.setString(5, updateAdmin.getEmail());
            stmt.setInt(6, updateAdmin.getId());

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

    public static boolean delete(Admin deleteAdmin) {
        String sql = "DELETE FROM admin WHERE adminId = ?";
        try (Connection conn = DbCon.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, deleteAdmin.getId());
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
