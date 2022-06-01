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
public class Style {
    private ObjectProperty<Integer> styleId;
    private StringProperty styleName;

    public Style() {
        styleId = new SimpleObjectProperty<>(null);
        styleName = new SimpleStringProperty();
    }
    
    public Integer getId() {
        return styleId.get();
    }   
    
    public String getStyle() {
        return styleName.get();
    }
    
    public void setId(int styleId) {
        this.styleId.set(styleId);
    }
    
    public void setStyle(String styleName) {
        this.styleName.set(styleName);
    }
    
    public ObjectProperty<Integer> getStyleIdProperty() {
        return styleId;
    }
    
    public StringProperty getStyleProperty() {
        return styleName;
    }
    
    
    
    
    
    
    
    
}