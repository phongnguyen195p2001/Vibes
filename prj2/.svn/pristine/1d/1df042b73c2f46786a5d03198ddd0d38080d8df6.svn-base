/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor;

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
 * @author Admin
 */
public class Motor {
    private ObjectProperty<Integer> motorId;
    private StringProperty motorName;
    private StringProperty image;
    private StringProperty descriptionImg;
    private ObjectProperty<Float> price;
    private ObjectProperty<Integer> engine;
    private StringProperty introduce;
    private ObjectProperty<Integer> brandMotor;
    private ObjectProperty<Integer> styleMotor;
    
    
    public Motor(){
        motorId = new SimpleObjectProperty<>(null);
        motorName = new SimpleStringProperty();
        image = new SimpleStringProperty();
        descriptionImg = new SimpleStringProperty();
        price = new SimpleObjectProperty<>(2.0f);
        engine = new SimpleObjectProperty<>(0);
        introduce = new SimpleStringProperty();
        brandMotor = new SimpleObjectProperty<>(0);
        styleMotor = new SimpleObjectProperty<>(0);
    }
    
    public Integer getId() {
        return motorId.get();
    }
    
    public String getMotorName() {
        return motorName.get();
    }
    
    public String getImage() {
        return image.get();
    }
    
    public String getDescriptionImg() {
        return descriptionImg.get();
    }
    
    public float getPrice() {
        return price.get();
    }
    
    public Integer getEngine() {
        return engine.get();
    }
    
    public String getIntroduce() {
        return introduce.get();
    }
    
    public Integer getBrandMotor() {
        return brandMotor.get();
    }
    
    public Integer getStyleMotor() {
        return styleMotor.get();
    }
    
    public void setId(int motorId) {
        this.motorId.set(motorId);
    }

    public void setMotorName(String motorName) {
        this.motorName.set(motorName);
    }

    public void setImage(String image) {
        this.image.set(image);
    }

    public void setDescriptionImg(String descriptionImg) {
        this.descriptionImg.set(descriptionImg);
    }

    public void setPrice(Float price) {
        this.price.set(price);
    }

    public void setEngine(int engine) {
        this.engine.set(engine);
    }

    public void setIntroduce(String introduce) {
        this.introduce.set(introduce);
    }

    public void setBrandMotor(int brandMotor) {
       this.brandMotor.set(brandMotor);
    }

    public void setStyleMotor(int styleMotor) {
        this.styleMotor.set(styleMotor);
    }
    
    public ObjectProperty<Integer> getMotorIdProperty() {
        return motorId;
    }
    
    public StringProperty getMotorNameProperty() {
        return motorName;
    }
    
    public StringProperty getFullNameProperty() {
        return image;
    }
    
    public StringProperty getImageProperty() {
        return descriptionImg;
    }
    
    public ObjectProperty<Float> getPriceProperty() {
        return price;
    }
    
    public ObjectProperty<Integer> getEngineProperty() {
        return engine;
    }
    
    public StringProperty getIntroduceProperty() {
        return introduce;
    }
    
    public ObjectProperty<Integer> getBrandMotorProperty() {
        return brandMotor;
    }
    
    public ObjectProperty<Integer> getStyleMotorProperty() {
        return styleMotor;
    }
    
    public static ObservableList<Motor> selectAll() {
        ObservableList<Motor> teachers = FXCollections.observableArrayList();

        try (Connection conn = DBConnect.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM motor");) {
            while (rs.next()) {
                Motor t = new Motor();
                t.setId(rs.getInt("motorId"));
                t.setMotorName(rs.getString("motorName"));
                t.setImage(rs.getString("image"));
                t.setPrice(rs.getFloat("price"));
                t.setEngine(rs.getInt("engine"));
                t.setIntroduce(rs.getString("introduce"));
                t.setBrandMotor(rs.getInt("brandMotor"));
                t.setStyleMotor(rs.getInt("styleMotor"));

                teachers.add(t);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return teachers;
    }
    
    public static Motor insert(Motor newMotor) throws SQLException {
        String sql = "INSERT into motor (motorName, image, descriptionImg, price, engine, introduce, brandMotor, styleMotor) " + "VALUE (?, ?, ?, ?, ?, ?, ?, ?)";
        ResultSet key = null;
        try (Connection conn = DBConnect.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
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
                newMotor.setId(newKey);
                return newMotor;
            } else {
                System.out.println("No motor inserted!!!");
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
    
    
    public static boolean update(Motor updateMotor) {
        String sql = "UPDATE motor SET "
                + "motorName = ?, "
                + "image = ?, "
                + "descriptionImg = ?, "
                + "price = ?, "
                + "engine = ?, "
                + "introduce = ?, "
                + "brandMotor = ?, "
                + "styeMotor = ? "
                + "WHERE motorId = ?";
        try (Connection conn = DBConnect.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, updateMotor.getMotorName());
            stmt.setString(2, updateMotor.getImage());
            stmt.setString(3, updateMotor.getDescriptionImg());
            stmt.setFloat(4, updateMotor.getPrice());
            stmt.setInt(5, updateMotor.getEngine());
            stmt.setString(6, updateMotor.getIntroduce());
            stmt.setInt(7, updateMotor.getBrandMotor());
            stmt.setInt(8, updateMotor.getStyleMotor());
            stmt.setInt(9, updateMotor.getId());

            int rowUpdate = stmt.executeUpdate();
            if (rowUpdate == 1) {
                return true;
            } else {
                System.err.println("No motor update");
                return false;
            }
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }
    
   

    public static boolean delete(Motor deleteMotor) {
        String sql = "DELETE FROM motor WHERE motorId = ?";
        try (Connection conn = DBConnect.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, deleteMotor.getId());
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
