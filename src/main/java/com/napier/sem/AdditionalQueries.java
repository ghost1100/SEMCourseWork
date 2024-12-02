package com.napier.sem;
import java.sql.*;
import java.util.Scanner;

public class AdditionalQueries {
    public static void main(String[] args) {
        DisplayAdditionalQueries();
    }


    public static void DisplayAdditionalQueries(){
        System.out.println("Additional Queries available to user");
        System.out.println("1.(City Report) Search based on city name");
        System.out.println("2.(Country Report) Search based on country name");
        Runquery();
    }

    public static void Runquery(){
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        input.nextLine();
        switch (choice){
            case 1:
                CityQueries();
                DisplayAdditionalQueries();
                break;
                case 2:
                    CountryQueries();
                    DisplayAdditionalQueries();
                    break;
                    default:
                        System.out.println("Please enter a valid choice");
        }


    }



public static void CountryQueries(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Country Name : ");
    String Name = sc.nextLine();

    String query = "";
    // Database connection and execution
    try (Connection Con = DriverManager.getConnection(DatabaseConfig.jdbcurl(), DatabaseConfig.username(), DatabaseConfig.password());
         PreparedStatement pstmt = Con.prepareStatement(query)) {
        pstmt.setString(1, "%" + Name + "%");
        // Execute query
        ResultSet rs = pstmt.executeQuery();
        // Process results
        while (rs.next()) {
            System.out.println("Name: " + rs.getString("CityName"));
            System.out.println("Continent: " + rs.getString("Continent"));
            System.out.println("Region : " + rs.getString("Region"));
            System.out.println("Population: " + rs.getInt("Population"));
            System.out.println("Capital: " + rs.getInt("Capital"));
            System.out.println("/ :)----------------------------------------------------:/");
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}








    private static void CityQueries() {
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
    }}


