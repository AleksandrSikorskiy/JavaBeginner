package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(String[] args) {
        // Create a variable for the connection string.
<<<<<<< HEAD
        String connectionUrl = "jdbc:sqlserver://v-hp-bpm-sql01:1433;databaseName=Camunda;user=cam-bpm-sql;password=pwd_cam-bpm-sql";
=======
        String connectionUrl = "jdbc:sqlserver://srv:1433;databaseName=db;user=usrname>;password=pwdusr";
>>>>>>> c4b7da79c9f5837883d5a47d6a74c577dbb470d7

        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
            String SQL = "SELECT * FROM [dbo].[ACT_ID_USER]";
            ResultSet rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                System.out.println(rs.getString("ID_") + " " + rs.getString("EMAIL_") + " " + rs.getString("FIRST_") + " " + rs.getString("LAST_"));
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
