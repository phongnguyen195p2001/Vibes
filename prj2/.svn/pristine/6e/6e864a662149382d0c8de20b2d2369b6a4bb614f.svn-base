/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor.Data;

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
 * @author Brand
 */
public class BrandDaoImpl implements BrandDao{
    public DbType database = DbType.SQLSERVER;
    
    @Override
    public ObservableList<Brand> selectAll() {
        ObservableList<Brand> brands = FXCollections.observableArrayList();
        
        try (
                Connection conn = DbFactory.getConnection(database);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM brand");) {
            while (rs.next()) {
                Brand b = new Brand();
                b.setId(rs.getInt("brandId"));
                b.setBrand(rs.getString("brand"));
                b.setLogo(rs.getString("logo"));

                brands.add(b);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return brands;
    }
    
    @Override
    public Brand insert(Brand newBrand) {
        String sql = "INSERT into brand (brand, logo) "
                + "VALUES (?, ? )";
        ResultSet key = null;
        try (

                Connection conn = DbFactory.getConnection(database);
                PreparedStatement stmt
                = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            stmt.setString(1, newBrand.getBrand());
            stmt.setString(2, newBrand.getLogo());

            int rowInserted = stmt.executeUpdate();

            if (rowInserted == 1) {
                key = stmt.getGeneratedKeys();
                key.next();
                int newKey = key.getInt(1);
                newBrand.setId(newKey);
                return newBrand;
            } else {
                System.err.println("No brand inserted");
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
    public boolean delete(Brand deleteBrand) {
        String sql = "DELETE FROM brand WHERE id = ?";
        try (

                Connection conn = DbFactory.getConnection(database);
                PreparedStatement stmt = conn.prepareStatement(sql);) {

            stmt.setInt(1, deleteBrand.getId());

            int rowDeleted = stmt.executeUpdate();

            if (rowDeleted == 1) {
                return true;
            } else {
                System.err.println("No brand deleted");
                return false;
            }

        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }
    
    @Override
    public boolean update(Brand updateBrand) {
        String sql = "UPDATE brand SET "
                + "brand = ?, "
                + "logo = ? "
                + "WHERE brandId = ?";
        try (
//                Connection conn = DbService.getConnection();
                Connection conn = DbFactory.getConnection(database);
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, updateBrand.getBrand());
            stmt.setString(2, updateBrand.getLogo());
            stmt.setInt(3, updateBrand.getId());

            int rowUpdated = stmt.executeUpdate();

            if (rowUpdated == 1) {
                return true;
            } else {
                System.err.println("No brand updated");
                return false;
            }

        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }
}
