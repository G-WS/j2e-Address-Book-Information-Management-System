package com.amaker.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "addresslists?serverTimezone=UTC", "root", "Zhy06150412252814732");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void closeConnection(Connection conn) {
        if (conn != null) {

            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    /*public static void main(String[] args) {
        DButil util = new DButil();
        Connection conn = util.getConnection();
        //System.out.println(conn);
    }*/
}
