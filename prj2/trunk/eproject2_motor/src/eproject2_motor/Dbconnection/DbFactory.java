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
public class DbFactory {
    private static final String MYSQL_USERNAME = "root";
    private static final String MYSQL_PASSWORD = "";
    private static final String MYSQL_CONN_STRING
            = "jdbc:mysql://localhost/eproject2?serverTimezone=UTC";

//    private static final String SQLSERVER_USERNAME = "sa";
//    private static final String SQLSERVER_PASSWORD = "12345678";
//    private static final String SQLSERVER_CONN_STRING
//            = "jdbc:sqlserver://AJJUUV1D45X8K1H\\SQLEXPRESS2012;databaseName=1808g";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                MYSQL_CONN_STRING,
                MYSQL_USERNAME,
                MYSQL_PASSWORD
        );
    }
    
    public static Connection getConnection(DbType dbt) throws SQLException {
        
        switch (dbt) {
            case SQLSERVER:
//                return DriverManager.getConnection(
//                        SQLSERVER_CONN_STRING,
//                        SQLSERVER_USERNAME,
//                        SQLSERVER_PASSWORD
//                );
            case MYSQL:
            default:
                return DriverManager.getConnection(
                        MYSQL_CONN_STRING,
                        MYSQL_USERNAME,
                        MYSQL_PASSWORD
                );
            
        }
        
        
    }
}
