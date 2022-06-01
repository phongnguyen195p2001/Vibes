/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor.Data.Motor;

import eproject2_motor.Data.Style.Style;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Admin
 */
public class Motor extends Style {

    private ObjectProperty<Integer> motoId;
    private StringProperty motorName;
    private StringProperty image;
    private StringProperty descriptionImg;
    private ObjectProperty<Float> price;
    private ObjectProperty<Integer> engine;
    private StringProperty introduce;

    public Motor() {
        motoId = new SimpleObjectProperty<>(null);
        motorName = new SimpleStringProperty();
        image = new SimpleStringProperty();
        descriptionImg = new SimpleStringProperty();
        price = new SimpleObjectProperty<>(3.0f);
        engine = new SimpleObjectProperty<>(0);
        introduce = new SimpleStringProperty();
    }

    public void setMotorId(int motorId) {
        this.motoId.set(motorId);
    }

    public void setPrice(float price) {
        this.price.set(price);
    }
    
    public void setEngine(int engine) {
        this.engine.set(engine);
    }

    public void setMotorName(String motorName) {
        this.motorName.set(motorName);
    }

    public void setImage(String img) {
        this.image.set(img);
    }
    
    public void setDescriptionImg(String img) {
        this.descriptionImg.set(img);
    }
    
    public void setIntroduce(String introduce) {
        this.introduce.set(introduce);
    }

    public Integer getMotorId() {
        return this.motoId.get();
    }

    public Float getPrice() {
        return this.price.get();
    }
    
    public int getEngine() {
        return this.engine.get();
    }

    public String getMotorName() {
        return this.motorName.get();
    }

    public String getIntroduce() {
        return this.introduce.get();
    }

    public String getImage() {
        return this.image.get();
    }
    
    public String getDescriptionImg() {
        return this.descriptionImg.get();
    }

    public ObjectProperty<Integer> getMotorIdProperty() {
        return this.motoId;
    }

    public StringProperty getMotorNameProperty() {
        return this.motorName;
    }

    public ObjectProperty<Float> getPriceProperty() {
        return this.price;
    }
    
    public ObjectProperty<Integer> getEngineProperty() {
        return this.engine;
    }

    public StringProperty getImageProperty() {
        return this.image;
    }
    
    public StringProperty getDescriptionImgProperty() {
        return this.descriptionImg;
    }

    public StringProperty getIntroduceProperty() {
        return this.introduce;
    }

}
