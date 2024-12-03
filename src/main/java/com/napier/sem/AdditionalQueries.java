package com.napier.sem;
import java.sql.*;
import java.util.Scanner;
/**
 * This is a new class designated for additional queries, the way it works is there is a total of three main functions.
 * 1. The main function which is the access point.
 * 2. The display query function which displays options available to the user.
 * 3. The run query function which holds a switch case,
 * allowing the user to choose which item or query they'd like to run.
 * Lastly,
 * there are the query functions
 * that are responsible for taking input and sending output based on what the user provides.
 * */
public class AdditionalQueries {
    public static void main(String[] args) {
        DisplayAdditionalQueries();
    }


    public static void DisplayAdditionalQueries(){
        System.out.println("Welcome to SEM 2.0 Additional Queries");
        System.out.println("Additional Queries available to user");
        System.out.println("1.(City Report) Search based on city name");
        System.out.println("2.(Country Report) Search based on country name");
        Run_query();
    }

    public static void Run_query(){
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.nextLine();
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
                        break;
        }


    }

    // Country query responsible for generating a report with the Country name, Continent,
    // Region, population and the Capital of the country that will be provided by the user.
public static void CountryQueries(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Country Name: ");
    String name = sc.nextLine();

    String query = " SELECT country.Name AS CountryName, country.Continent, country.Region, country.Population, city.Name AS Capital FROM country LEFT JOIN city ON  country.Capital = city.ID WHERE country.Name Like ?;";
    // Database connection and execution
    try (Connection Con = DriverManager.getConnection(DatabaseConfig.jdbcurl(), DatabaseConfig.username(), DatabaseConfig.password());
         PreparedStatement pstmt = Con.prepareStatement(query)) {
        pstmt.setString(1, "%" + name + "%");
        // Execute query
        ResultSet rs = pstmt.executeQuery();
        // Process results
        while (rs.next()) {
            System.out.println("Name: " + rs.getString("CountryName"));
            System.out.println("Continent: " + rs.getString("Continent"));
            System.out.println("Region : " + rs.getString("Region"));
            System.out.println("Population: " + rs.getInt("Population"));
            System.out.println("Capital: " + rs.getString("Capital"));
            System.out.println("/ :)----------------------------------------------------:/");
            // added a nice looking spacer.
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}

// City query responsible for generating a report with the city name, country,
// District and population of the city name that will be provided by the user
    private static void CityQueries() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter City Name: ");
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

/// note to future developers the main class sends the user automatically
/// to display queries which you must modify
///to add a new print statement to allow the end user to see what's available to them.
/// then it's the run query function which displays the switch case automatically taking in the user's input without prompting them again, each case has a different function in it, and the functions are what's responsible for running the query taking in any additional input and sending output, another function which is inside the switch case is display additional queries which turns this application into a loop.
/// then there is the last case that would be to exist the application.

