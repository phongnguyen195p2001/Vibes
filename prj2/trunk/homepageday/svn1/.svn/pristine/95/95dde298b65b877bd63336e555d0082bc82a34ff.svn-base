/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor;

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
public class MotorDaoImpl {
    public DbType database = DbType.SQLSERVER;
    
    
    public static ObservableList<Motor> selectAll() {
        ObservableList<Motor> motors = FXCollections.observableArrayList();
        
        try (
                Connection conn = DBConnect.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM motor");) {
            while (rs.next()) {
                Motor b = new Motor();
                b.setMotorId(rs.getInt("motorId"));
                b.setMotorName(rs.getString("motorName"));
                b.setImage(rs.getString("image"));
                b.setPrice(rs.getFloat("price"));
                b.setEngine(rs.getInt("engine"));
                b.setIntroduce(rs.getString("introduce"));
                b.setBrandMotor(rs.getInt("brandMotor"));
                b.setStyleMotor(rs.getInt("styleMotor"));

                motors.add(b);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return motors;
    }

    public Motor insert(Motor newMotor) {
        String sql = "INSERT into brand (motorName, image, descriptionImg, price, engine, introduce, brandMotor, styleMotor ) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ? )";
        ResultSet key = null;
        try (

                Connection conn = DbFactory.getConnection(database);
                PreparedStatement stmt
                = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            stmt.setString(1, newMotor.getMotorName());
            stmt.setString(2, newMotor.getImage());
            stmt.setString(3, newMotor.getDescriptionImg());
            stmt.setFloat(4, newMotor.getPrice());
            stmt.setInt(5, newMotor.getEngine());
            stmt.setString(6, newMotor.getIntroduce());
            stmt.setInt(7, newMotor.getBrandMotor());
            stmt.setInt(8, newMotor.getStyleMotor());

            int rowInserted = stmt.executeUpdate();

            if (rowInserted == 1) {
                key = stmt.getGeneratedKeys();
                key.next();
                int newKey = key.getInt(1);
                newMotor.setMotorId(newKey);
                return newMotor;
            } else {
                System.err.println("No motor inserted");
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

    public boolean update(Motor updateMotor) {
        String sql = "UPDATE motor SET "
                + "motorName = ?, "
                + "image = ?, "
                + "descriptionImg = ?, "
                + "price = ?, "
                + "engine = ?, "
                + "introduce = ?, "
                + "brandMotor = ?, "
                + "styleMotor = ? "
                + "WHERE motorId = ?";
        try (
                Connection conn = DbFactory.getConnection(database);
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, updateMotor.getMotorName());
            stmt.setString(2, updateMotor.getImage());
            stmt.setString(3, updateMotor.getDescriptionImg());
            stmt.setFloat(4, updateMotor.getPrice());
            stmt.setInt(5, updateMotor.getEngine());
            stmt.setString(6, updateMotor.getIntroduce());
            stmt.setInt(7, updateMotor.getBrandMotor());
            stmt.setInt(8, updateMotor.getStyleMotor());

            int rowUpdated = stmt.executeUpdate();

            if (rowUpdated == 1) {
                return true;
            } else {
                System.err.println("No motor updated");
                return false;
            }

        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    public boolean delete(Motor deleteMotor) {
        String sql = "DELETE FROM motor WHERE id = ?";
        try (

                Connection conn = DbFactory.getConnection(database);
                PreparedStatement stmt = conn.prepareStatement(sql);) {

            stmt.setInt(1, deleteMotor.getId());

            int rowDeleted = stmt.executeUpdate();

            if (rowDeleted == 1) {
                return true;
            } else {
                System.err.println("No motor deleted");
                return false;
            }

        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }
    
}
