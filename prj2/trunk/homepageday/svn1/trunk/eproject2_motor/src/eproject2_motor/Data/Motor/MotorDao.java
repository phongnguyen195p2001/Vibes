/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor.Data.Motor;

import java.sql.SQLException;
import javafx.collections.ObservableList;

/**
 *
 * @author Admin
 */
public interface MotorDao  {

    public ObservableList<Motor> selectMotorAll();

    public Motor insertMotor(Motor newMotor) throws SQLException;

    public boolean updateMotor(Motor updateMotor);

    public boolean deleteMotor(Motor deleteMotor);

}