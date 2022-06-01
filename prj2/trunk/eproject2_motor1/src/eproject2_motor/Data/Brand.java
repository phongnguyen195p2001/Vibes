/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor.Data;

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
    private StringProperty brand;
    private StringProperty logo;
    
     public Brand(){
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

    public ObjectProperty<Integer> getBrandIdProperty() {
        return brandId;
    }

    public void setId(int brandId) {
        this.brandId.set(brandId);
    }

    public StringProperty getBrandProperty() {
        return brand;
    }
    
    public void setBrand(String brand) {
        this.brand.set(brand);
    }

    public StringProperty getLogoProperty() {
        return logo;
    }
    
    public void setLogo(String logo) {
        this.logo.set(logo);
    }
}