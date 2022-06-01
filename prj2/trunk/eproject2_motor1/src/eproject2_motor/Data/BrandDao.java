/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor.Data;

import javafx.collections.ObservableList;

/**
 *
 * @author Admin
 */
public interface BrandDao {
    public ObservableList<Brand> selectAll();
    public Brand insert(Brand newBrand);
    public boolean update(Brand updateBrand);
    public boolean delete(Brand deleteBrand);
}
