package com.example.gabriel_jayme.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection initializeDatabase() throws SQLException, ClassNotFoundException
    {
        //Conexão e acesso ao banco pw3:
        String dbDriver = "com.mysql.cj.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost:3306/pw3";
        String dbUsername = "root";
        String dbPassword = "root";

        //busca o driver e realiza a conexão
        Class.forName(dbDriver);
        Connection con = DriverManager.getConnection(dbURL,dbUsername,dbPassword);

        return con;

    }
}

