package com.napier.sem;
import java.sql.*;

public class App
{
    public static void main(String[] args) {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        // Connection to the database
        Connection con = null;
        int retries = 100;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/World", "root", "BkQR7Aczt");
                System.out.println("Successfully connected");
                // Wait a bit
                Thread.sleep(10000);
                Queries.Statements();//calling another class before the break statement.
                //class is named Queries and its main method is named statements
                // I will be using this method to first wait for the connection with the database to be established then,
                 // I will send the connection string to another class to allow me to manipulate said database.
                // Exit for loop
                break;

            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }

        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }
}