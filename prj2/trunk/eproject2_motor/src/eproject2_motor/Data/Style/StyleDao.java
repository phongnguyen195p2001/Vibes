/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor.Data.Style;

import javafx.collections.ObservableList;

/**
 *
 * @author Admin
 */
public interface StyleDao {
    public ObservableList<Style> selectAll();
    public Style insert(Style newStyle);
    public boolean update(Style updateStyle);
    public boolean delete(Style deleteStyle);
}
