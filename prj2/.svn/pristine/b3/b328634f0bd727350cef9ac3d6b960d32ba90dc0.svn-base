/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor.Data.Motor;

import eproject2_motor.DBConnect;
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
public class MotorDaoImpl implements MotorDao{

    public DbType database = DbType.SQLSERVER;
    
    @Override
    public ObservableList<Motor> selectAll() {
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

    @Override
    public Motor insert(Motor insertMotor) {
        String sql = "INSERT into brand (motorName, image, descriptionImg, price, engine, introduce, brandMotor, styleMotor ) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ? )";
        ResultSet key = null;
        try (

                Connection conn = DbFactory.getConnection(database);
                PreparedStatement stmt
                = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            stmt.setString(1, insertMotor.getMotorName());
            stmt.setString(2, insertMotor.getImage());
            stmt.setString(3, insertMotor.getDescriptionImg());
            stmt.setFloat(4, insertMotor.getPrice());
            stmt.setInt(5, insertMotor.getEngine());
            stmt.setString(6, insertMotor.getIntroduce());
            stmt.setInt(7, insertMotor.getBrandMotor());
            stmt.setInt(8, insertMotor.getStyleMotor());

            int rowInserted = stmt.executeUpdate();

            if (rowInserted == 1) {
                key = stmt.getGeneratedKeys();
                key.next();
                int newKey = key.getInt(1);
                insertMotor.setMotorId(newKey);
                return insertMotor;
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

    @Override
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

    @Override
    public boolean delete(Motor deleteMotor) {
        String sql = "DELETE FROM motor WHERE motorId = ?";
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

