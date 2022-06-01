/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor.Data.Motor;

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
public class MotorDaoImpl implements MotorDao {

    public DbType database = DbType.SQLSERVER;
    
    @Override
    public ObservableList<Motor> selectMotorAll() {
        ObservableList<Motor> motors = FXCollections.observableArrayList();

        try (
                Connection conn = DbFactory.getConnection(database);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM motor INNER JOIN brand ON brand.brandId=motor.brandMotor INNER JOIN style ON style.styleId=motor.styleMotor");) {
            while (rs.next()) {
                Motor a = new Motor();
                a.setMotorId(rs.getInt("motorId"));
                a.setMotorName(rs.getString("motorName"));
                a.setImage(rs.getString("image"));
                a.setDescriptionImg(rs.getString("descriptionImg"));
                a.setPrice(rs.getFloat("price"));
                a.setEngine(rs.getInt("engine"));
                a.setIntroduce(rs.getString("introduce"));
                a.setBrandName(rs.getString("brandName"));
                a.setStyleName(rs.getString("styleName"));
                motors.add(a);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return motors;
    }

    @Override
    public Motor insertMotor(Motor newMotor) throws SQLException {
        String sql = "INSERT into motor (motorName, image, descriptionImg, price, engine, introduce, brandMotor, styleMotor) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
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
            stmt.setInt(7, newMotor.getBrandId());
            stmt.setInt(8, newMotor.getStyleId());

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
            if (key != null) {
                key.close();
            }
        }
    }

    @Override
    public boolean deleteMotor(Motor deleteMotor) {
        String sql = "DELETE FROM motor WHERE motorId = ?";
        try (
                Connection conn = DbFactory.getConnection(database);
                PreparedStatement stmt = conn.prepareStatement(sql);) {

            stmt.setInt(1, deleteMotor.getMotorId());

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

    @Override
    public boolean updateMotor(Motor updateMotor) {
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
            stmt.setInt(7, updateMotor.getBrandId());
            stmt.setInt(8, updateMotor.getStyleId());
            stmt.setInt(9, updateMotor.getMotorId());

            int rowUpdated = stmt.executeUpdate();

            if (rowUpdated == 1) {
                return true;
            } else {
                System.err.println("No motor updated");
                return false;
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

}


