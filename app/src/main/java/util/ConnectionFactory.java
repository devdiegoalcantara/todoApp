/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author gpmrks
 */
public class ConnectionFactory {
    
    public static final String DRIVER = "org.postgresql.Driver";
    public static final String URL = "jdbc:postgresql://localhost:5432/todo_app";
    public static final String USER = "postgres";
    public static final String PASS = "postgres";
    
    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception ex) {
            throw new RuntimeException("Erro na conexão com o banco de dados", ex);            
        }
    }

    public static void closeConnection(Connection connection){
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados." ,e);
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement statement){
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados." ,e);
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet){
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados." ,e);
        }
    }
    
}
