/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor.Data.Brand;

import java.sql.SQLException;
import javafx.collections.ObservableList;

/**
 *
 * @author Admin
 */
public interface BrandDao {
    
    public ObservableList<Brand> selectBrandAll();

    public Brand insertBrand(Brand newBrand) throws SQLException;

    public boolean updateBrand(Brand updateBrand);

    public boolean deleteBrand(Brand deleteBrand);
}
