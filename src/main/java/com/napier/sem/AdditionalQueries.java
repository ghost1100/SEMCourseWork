package com.napier.sem;

import java.sql.*;
import java.util.Scanner;

public class AdditionalQueries {
public static void main(String[] args) {
    DisplayAdditionalQueries();
}


public static void DisplayAdditionalQueries(){
System.out.println("Additional Queries available to user");
    System.out.println("1. Search city query");
    System.out.println("1. Search country query");
}


    private static void CreateCityQueries() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter City Name");
        String Name = sc.nextLine();
        String query = "SELECT ID, Name, CountryCode, District, Population FROM city WHERE Name LIKE ?";// the ? is used as a place-holder to mark where the scanner input will be placed
//database information

        //try the method used to link database information with the driver manager.
        try (Connection Con = DriverManager.getConnection(DatabaseConfig.jdbcurl(),DatabaseConfig.username(), DatabaseConfig.password());
             PreparedStatement pstmt = Con.prepareStatement(query)) {
            // this is saying the prepared statement is equal to the query plus the user's input which relies on the scanner object
            pstmt.setString(1, "%" + Name + "%");// the % is used for a pattern matching the pattern used here is name as long as the letters match it shouldn't be concerned if the name is in upper or lower case.
//the parameter index is one meaning this is the one and only input we will accept from the user at the moment we can tinker about with that later to add more features when the join elements are implemented.
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1) + " ID" + ", " + rs.getString(2) + " Name" + ", " + rs.getString(3) + " CountryCode" + ", " + rs.getString(4) + " District" + ", " + rs.getString(5) + " Population");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }
}
