/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groupc.health.database;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author sabin
 */
public class DatabaseConnection {
    public Connection connection;
    Statement statement;
    ResultSet resultSet;
    
    public DatabaseConnection(){
        try {
            String username = "root";
            String password = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            String databaseUrl = "jdbc:mysql://localhost:3306/database_name";
            connection = DriverManager.getConnection(databaseUrl,username,password);
            if (connection != null){
                System.out.println("connected to database");
            }else{
                System.out.println("connection failed");
            }
            statement = connection.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void manipulate(String query){
        try {
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ResultSet retreive(String query){
        try {
            resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
