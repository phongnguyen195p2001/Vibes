/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor.Data.Style;

import eproject2_motor.Data.Brand.Brand;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Admin
 */
public class Style extends Brand{
    private ObjectProperty<Integer> styleId;
    private StringProperty styleName;


    public Style() {
        styleId = new SimpleObjectProperty<>(null);
        styleName = new SimpleStringProperty();
    }

    public Integer getStyleId() {
        return styleId.get();
    }

    public String getStyleName() {
        return styleName.get();
    }

    public void setStyleId(int styleId) {
        this.styleId.set(styleId);
    }

    public void setStyleName(String styleName) {
        this.styleName.set(styleName);
    }

    public ObjectProperty<Integer> getStyleIdProperty() {
        return this.styleId;
    }

    public StringProperty getStyleNameProperty() {
        return this.styleName;
    }

}