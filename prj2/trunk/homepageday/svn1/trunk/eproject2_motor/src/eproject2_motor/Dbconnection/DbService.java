/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor.Dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class DbService {

    private static final String USER_NAME = "root";
    private static final String PASSWORD = "";
    private static final String CONN_STRING = "jdbc:mysql://localhost/eproject2?serverTimezone=UTC";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONN_STRING, USER_NAME, PASSWORD);
    }
}
