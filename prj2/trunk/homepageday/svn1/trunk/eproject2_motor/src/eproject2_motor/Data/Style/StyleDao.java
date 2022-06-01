/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor.Data.Style;

import java.sql.SQLException;
import javafx.collections.ObservableList;

public interface StyleDao {
    
    public ObservableList<Style> selectStyleAll();

    public Style insertStyle(Style newStyle) throws SQLException;

    public boolean updateStyle(Style updateStyle);

    public boolean deleteStyle(Style deleteStyle);

}