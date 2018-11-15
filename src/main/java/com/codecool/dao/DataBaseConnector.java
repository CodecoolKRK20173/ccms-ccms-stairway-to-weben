package com.codecool.dao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnector {

    private Connection conn;

    private void connect() {
        try{Class.forName("org.sqlite.JDBC");}catch(Exception e){e.printStackTrace();}
        // SQLite connection string
        String url = "jdbc:sqlite:/src/main/java/com/codecool/resources/TheSQL.sql";
        try {
            this.conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet query(String sql){

        try {
            this.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
//            this.conn.close();

            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
