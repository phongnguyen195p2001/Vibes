/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor.Data.Brand;

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
     public ObservableList<Brand> selectBrandAll() {
        ObservableList<Brand> brands = FXCollections.observableArrayList();

        try (
                Connection conn = DbFactory.getConnection(database);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM brand");) {
            while (rs.next()) {
                Brand b = new Brand();
                b.setBrandId(rs.getInt("brandId")); 
                b.setBrandName(rs.getString("brandName"));
                b.setLogoName(rs.getString("logo"));

                brands.add(b);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return brands;
    }

    @Override
    public Brand insertBrand(Brand newBrand) throws SQLException {
        String sql = "INSERT into brand (brandName, logo) "
                + "VALUES (?, ?)";
        ResultSet key = null;
        try (
                Connection conn = DbFactory.getConnection(database);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            stmt.setString(1, newBrand.getBrandName());
            stmt.setString(2, newBrand.getLogoName());
            int rowInserted = stmt.executeUpdate();

            if (rowInserted == 1) {
                key = stmt.getGeneratedKeys();
                key.next();
                int newKey = key.getInt(1);
                newBrand.setBrandId(newKey);
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
    public boolean deleteBrand(Brand deleteBrand) {
        String sql = "DELETE FROM brand WHERE brandId = ?";
        try (
                Connection conn = DbFactory.getConnection(database);
//                Connection conn = DbFactory.getConnection(database);
                PreparedStatement stmt = conn.prepareStatement(sql);) {

            stmt.setInt(1, deleteBrand.getBrandId());

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
    public boolean updateBrand(Brand updateBrand){
        String sql = "UPDATE brand SET "
                + "brandName = ?, "
                + "logo = ? "
                + "WHERE brandId = ?";
        try (
                Connection conn = DbFactory.getConnection(database);
                PreparedStatement stmt = conn.prepareStatement(sql);) {

            stmt.setString(1, updateBrand.getBrandName());
            stmt.setString(2, updateBrand.getLogoName());
            stmt.setInt(3, updateBrand.getBrandId());

            int rowUpdated = stmt.executeUpdate();

            if (rowUpdated == 1) {
                return true;
            } else {
                System.err.println("No Brand updated");
                return false;
            }

        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

}