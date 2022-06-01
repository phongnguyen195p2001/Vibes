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
public class Brand {
    
    private ObjectProperty<Integer> brandId;
    private StringProperty brand;
    private StringProperty logo;
    
    public Brand() {
        brandId = new SimpleObjectProperty<>(null);
        brand = new SimpleStringProperty();
        logo = new SimpleStringProperty();
    }
    
    public Integer getId() {
        return brandId.get();
    }
    
    public String getBrand() {
        return brand.get();
    }
    
    public String getLogo() {
        return logo.get();
    }

    public void setId(int id) {
        this.brandId.set(id);
    }
    
    public void setBrand(String brand) {
        this.brand.set(brand);
    }
    
    public void setLogo(String logo) {
        this.logo.set(logo);
    }
    
    public ObjectProperty<Integer> getIdProperty() {
        return this.brandId;
    }
    
    public StringProperty getBrandProperty() {
        return this.brand;
    }
    
    public StringProperty getLogoProperty() {
        return this.logo;
    }

    public static ObservableList<Brand> selectAll() {
        ObservableList<Brand> teachers = FXCollections.observableArrayList();
        
        try (Connection conn = DbCon.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM brand");) {
            while(rs.next()) {
                Brand t = new Brand();
                t.setId(rs.getInt("brandId"));
                t.setBrand(rs.getString("brand"));
                t.setLogo(rs.getString("logo"));
                
                teachers.add(t);
            }
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return teachers;
    }
    
    public static Brand insert(Brand newBrand) throws SQLException {
        String sql = "INSERT into brand (brand, logo) " + "VALUE (?, ?)";
        ResultSet key = null;
        try (Connection conn = DbCon.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            stmt.setString(1, newBrand.getBrand());
            stmt.setString(2, newBrand.getLogo());
            int rowInserted = stmt.executeUpdate();
            
            if(rowInserted == 1) {
                key = stmt.getGeneratedKeys();
                key.next();
                int newKey = key.getInt(1);
                newBrand.setId(newKey);
                return newBrand;
            }
            else {
                System.out.println("No brand inserted!!!");
                return null;
            }
        } catch (Exception e) {
            System.err.println(e); 
            return null;
        } finally {
            if(key != null) {
                key.close();
            }
        }           
    }
    
    public static boolean update(Brand updataBrand) {
        String sql = "UPDATE brand SET " +
                "brand = ?, " +
                "logo = ? " +
                "WHERE brandId = ?";        try (Connection conn = DbCon.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
                ) {
            stmt.setString(1, updataBrand.getBrand());
            stmt.setString(2, updataBrand.getLogo());
            stmt.setInt(3, updataBrand.getId());
            
            int rowUpdate = stmt.executeUpdate();
            if(rowUpdate == 1) {
                return true;
            }
            else {
                System.err.println("No teacher update");
                return false;
            }
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }
    
    public static boolean delete(Brand deleteBrand) {
        String sql = "DELETE FROM brand WHERE brandId = ?";
        try (Connection conn = DbCon.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, deleteBrand.getId());
            int rowDelete = stmt.executeUpdate();
            
            if(rowDelete == 1) {
                 return true;
            }
            else {
                System.err.println("No teacher delete");
                return false;
            }
        } catch(Exception e) {
            System.err.println(e);
            return false;
        }
    }
}
