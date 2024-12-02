package com.napier.sem;
import java.sql.*;
import java.util.Scanner;

public class AdditionalQueries {
    public static void main(String[] args) {
        DisplayAdditionalQueries();
    }


    public static void DisplayAdditionalQueries(){
        System.out.println("Additional Queries available to user");
        System.out.println("1. Search based on city name");
        System.out.println("1. Search based on country name");

        CreateCityQueries();
    }
    private static void CreateCityQueries() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter City Name : ");
        String Name = sc.nextLine();
        String query = " SELECT city.Name AS CityName, country.Name AS Country, city.District, city.Population FROM city LEFT JOIN country ON city.CountryCode = country.Code WHERE city.Name LIKE ?;";
        // Database connection and execution
        try (Connection Con = DriverManager.getConnection(DatabaseConfig.jdbcurl(), DatabaseConfig.username(), DatabaseConfig.password());
             PreparedStatement pstmt = Con.prepareStatement(query)) {
            pstmt.setString(1, "%" + Name + "%");
            // Execute query
            ResultSet rs = pstmt.executeQuery();
            // Process results
            while (rs.next()) {
                System.out.println("Name: " + rs.getString("CityName"));
                System.out.println("Country: " + rs.getString("Country"));
                System.out.println("District: " + rs.getString("District"));
                System.out.println("Population: " + rs.getInt("Population"));
                System.out.println("/ :)----------------------------------------------------:/");
                // added a nice looking spacer.
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}