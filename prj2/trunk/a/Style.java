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
public class Style {

    private ObjectProperty<Integer> styleId;
    private StringProperty style;

    public Style() {
        styleId = new SimpleObjectProperty<>(null);
        style = new SimpleStringProperty();
    }

    public Integer getId() {
        return styleId.get();
    }

    public String getStyle() {
        return style.get();
    }

    public void setId(int id) {
        this.styleId.set(id);
    }

    public void setStyle(String style) {
        this.style.set(style);
    }

    public ObjectProperty<Integer> getIdProperty() {
        return this.styleId;
    }

    public StringProperty getStyleProperty() {
        return this.style;
    }

    public static ObservableList<Style> selectAll() {
        ObservableList<Style> teachers = FXCollections.observableArrayList();

        try (Connection conn = DbCon.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM style");) {
            while (rs.next()) {
                Style t = new Style();
                t.setId(rs.getInt("styleId"));
                t.setStyle(rs.getString("styleName"));

                teachers.add(t);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return teachers;
    }

    public static Style insert(Style newStyle) throws SQLException {
        String sql = "INSERT into style (styleName) " + "VALUE (?)";
        ResultSet key = null;
        try (Connection conn = DbCon.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            stmt.setString(1, newStyle.getStyle());
            int rowInserted = stmt.executeUpdate();

            if (rowInserted == 1) {
                key = stmt.getGeneratedKeys();
                key.next();
                int newKey = key.getInt(1);
                newStyle.setId(newKey);
                return newStyle;
            } else {
                System.out.println("No style inserted!!!");
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

    public static boolean update(Style updateStyle) {
        String sql = "UPDATE style SET "
                + "styleName = ? "
                + "WHERE styleId = ?";
        try (Connection conn = DbCon.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, updateStyle.getStyle());
            stmt.setInt(2, updateStyle.getId());

            int rowUpdate = stmt.executeUpdate();
            if (rowUpdate == 1) {
                return true;
            } else {
                System.err.println("No teacher update");
                return false;
            }
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    public static boolean delete(Style deleteStyle) {
        String sql = "DELETE FROM style WHERE styleId = ?";
        try (Connection conn = DbCon.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, deleteStyle.getId());
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
