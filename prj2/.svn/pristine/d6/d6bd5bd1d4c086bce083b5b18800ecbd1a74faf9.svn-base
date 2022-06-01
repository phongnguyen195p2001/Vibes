/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor.Data.Style;

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
public class StyleDaoImpl implements StyleDao{
    public DbType database = DbType.SQLSERVER;
    
    @Override
    public ObservableList<Style> selectAll() {
        ObservableList<Style> styles = FXCollections.observableArrayList();
        
        try (
                Connection conn = DbFactory.getConnection(database);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM style");) {
            while (rs.next()) {
                Style b = new Style();
                b.setId(rs.getInt("styleId"));
                b.setStyle(rs.getString("style"));

                styles.add(b);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return styles;
    }
    
    @Override
    public Style insert(Style newStyle) {
        String sql = "INSERT into style (style) "
                + "VALUES (?)";
        ResultSet key = null;
        try (

                Connection conn = DbFactory.getConnection(database);
                PreparedStatement stmt
                = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            stmt.setString(1, newStyle.getStyle());

            int rowInserted = stmt.executeUpdate();

            if (rowInserted == 1) {
                key = stmt.getGeneratedKeys();
                key.next();
                int newKey = key.getInt(1);
                newStyle.setId(newKey);
                return newStyle;
            } else {
                System.err.println("No style inserted");
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
    public boolean delete(Style deleteStyle) {
        String sql = "DELETE FROM style WHERE id = ?";
        try (

                Connection conn = DbFactory.getConnection(database);
                PreparedStatement stmt = conn.prepareStatement(sql);) {

            stmt.setInt(1, deleteStyle.getId());

            int rowDeleted = stmt.executeUpdate();

            if (rowDeleted == 1) {
                return true;
            } else {
                System.err.println("No style deleted");
                return false;
            }

        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }
    
    @Override
    public boolean update(Style updateStyle) {
        String sql = "UPDATE style SET "
                + "style = ? "
                + "WHERE styleId = ?";
        try (
//                Connection conn = DbService.getConnection();
                Connection conn = DbFactory.getConnection(database);
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, updateStyle.getStyle());
            stmt.setInt(2, updateStyle.getId());

            int rowUpdated = stmt.executeUpdate();

            if (rowUpdated == 1) {
                return true;
            } else {
                System.err.println("No style updated");
                return false;
            }

        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }
}
