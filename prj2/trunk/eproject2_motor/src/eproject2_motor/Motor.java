/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Admin
 */
public class Motor {
    private ObjectProperty<Integer> motorId;
    private StringProperty motorName;
    private StringProperty image;
    private StringProperty descriptionImg;
    private ObjectProperty<Float> price;
    private ObjectProperty<Integer> engine;
    private StringProperty introduce;
    private ObjectProperty<Integer> brandMotor;
    private ObjectProperty<Integer> styleMotor;
    
    
    public Motor(){
        motorId = new SimpleObjectProperty<>(null);
        motorName = new SimpleStringProperty();
        image = new SimpleStringProperty();
        descriptionImg = new SimpleStringProperty();
        price = new SimpleObjectProperty<>(2.0f);
        engine = new SimpleObjectProperty<>(0);
        introduce = new SimpleStringProperty();
        brandMotor = new SimpleObjectProperty<>(0);
        styleMotor = new SimpleObjectProperty<>(0);
    }
    
    public Integer getId() {
        return motorId.get();
    }
    
    public String getMotorName() {
        return motorName.get();
    }
    
    public String getImage() {
        return image.get();
    }
    
    public String getDescriptionImg() {
        return descriptionImg.get();
    }
    
    public float getPrice() {
        return price.get();
    }
    
    public Integer getEngine() {
        return engine.get();
    }
    
    public String getIntroduce() {
        return introduce.get();
    }
    
    public Integer getBrandMotor() {
        return brandMotor.get();
    }
    
    public Integer getStyleMotor() {
        return styleMotor.get();
    }
    
    public void setMotorId(int motorId) {
        this.motorId.set(motorId);
    }

    public void setMotorName(String motorName) {
        this.motorName.set(motorName);
    }

    public void setImage(String image) {
        this.image.set(image);
    }

    public void setDescriptionImg(String descriptionImg) {
        this.descriptionImg.set(descriptionImg);
    }

    public void setPrice(Float price) {
        this.price.set(price);
    }

    public void setEngine(int engine) {
        this.engine.set(engine);
    }

    public void setIntroduce(String introduce) {
        this.introduce.set(introduce);
    }

    public void setBrandMotor(int brandMotor) {
       this.brandMotor.set(brandMotor);
    }

    public void setStyleMotor(int styleMotor) {
        this.styleMotor.set(styleMotor);
    }
    
    public ObjectProperty<Integer> getMotorIdProperty() {
        return motorId;
    }
    
    public StringProperty getMotorNameProperty() {
        return motorName;
    }
    
    public StringProperty getFullNameProperty() {
        return image;
    }
    
    public StringProperty getImageProperty() {
        return descriptionImg;
    }
    
    public ObjectProperty<Float> getPriceProperty() {
        return price;
    }
    
    public ObjectProperty<Integer> getEngineProperty() {
        return engine;
    }
    
    public StringProperty getIntroduceProperty() {
        return introduce;
    }
    
    public ObjectProperty<Integer> getBrandMotorProperty() {
        return brandMotor;
    }
    
    public ObjectProperty<Integer> getStyleMotorProperty() {
        return styleMotor;
    }
    
    
    
    
    
    
    
    
    
    
    
}
