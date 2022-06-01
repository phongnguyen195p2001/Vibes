/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor.Data.Brand;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Admin
 */
public class Brand {
    private ObjectProperty<Integer> brandId;
    private StringProperty brandName;
    private StringProperty logoName;


    public Brand() {
        brandId = new SimpleObjectProperty<>(null);
        brandName = new SimpleStringProperty();
        logoName = new SimpleStringProperty();
    }

    public Integer getBrandId() {
        return brandId.get();
    }

    public String getBrandName() {
        return brandName.get();
    }
    
    public String getLogoName() {
        return logoName.get();
    }

    public void setBrandId(int brandId) {
        this.brandId.set(brandId);
    }

    public void setBrandName(String brandName) {
        this.brandName.set(brandName);
    }
    
    public void setLogoName(String logoName) {
        this.logoName.set(logoName);
    }

    public ObjectProperty<Integer> getBrandIdProperty() {
        return this.brandId;
    }

    public StringProperty getBrandNameProperty() {
        return this.brandName;
    }
    
    public StringProperty getLogoNameProperty() {
        return this.logoName;
    }

}