package com.napier.sem;
import java.sql.*;
import java.util.Scanner;
import java.util.InputMismatchException;


/**
 * this class will be used to create an array of some sorts (will figure that out later...) to store Predetermined Queries and a switch statement to display a dew options to the user.
 * one of the options would be to display the pre-made queries and the other option would be used to exit the app.
 * if the user chooses option one it presents them with the queries and, they can choose which one to run.
 * might try to implement parameterised queries...
 * after starting this project I have realised that c#  is much more flexible than java and that i at least don't have to define everything over and over or add any dependencies but in all honesty java seems more interesting feels like it has no limits
 * I will use 2 formats of commenting the // to make comments which i don't want to stand out as much and the ///for green comments that I want to see.
 * the third format is just this which should be on-top of every method or class.
 */
public class Queries {

    private static final String[] PREDEFINED_QUERIES = {
            ///this is where the queries would go
            "SHOW COLUMNS FROM city",///added these queries because it would help with generating the others because SQL is case-sensitive.
            "SHOW COLUMNS FROM country",
            "SHOW COLUMNS FROM countrylanguage",
            ///first one done displays all cities and orders it by population from smallest to largest using the desc function.
            "SELECT *  FROM city order by population DESC ",


    };

    public static void choice() {
        Scanner sc = new Scanner(System.in);
        ///created an instance of the scanner object which would be used to detect the user's input and named it sc.
        int query = 0;
        do {
            System.out.println("Welcome to Napier Sem Course Application");
            System.out.println("Enter Number For Desired Query");
            System.out.println("1.Display Available Queries");
            System.out.println("2.Create Your Own City Queries");
            System.out.println("3.Create Your Own Country Queries");
            System.out.println("4.Exit APP");
// number 1 which is display available queries is basically a dynamic switch case within a static one allowing me to modify its length at any time without having to go and change the numbers over and over like a static one would.
            //it mostly relies on the for loop as long as the input is bigger than i but smaller than the predefined list it will increment I and execute the query in the list
            //then there is the if statement saying if the index which == predefined queries is smaller than 0 which = I then the choice isn't valid which is an error detection and handling method.
            // it also invalidates the users choice if it turns out to be bigger than the specified index
            try {
                query = sc.nextInt();

                switch (query) {
                    case 1:
                        displayQueries();
                        int querychoice = sc.nextInt();
                        executeQuery(querychoice - 1);
                        break;
                    case 2:
                        System.out.println("Create your own City query");// allows the user the option to choose a city name and, it will list out the city's details I plan to build up on this by using the sql join method to display the language and other similar details however the current time frame doesn't allow for that.
                        CreateCityQueries();
                        break;
                    case 3:
                        System.out.println("Create your own query");
                        CreateQueries();
                        break;
                    case 4:
                        System.out.println("exiting the application");
                        break;

                    default:
                        System.out.println("Invalid Choice try again later");
                }
            } catch (InputMismatchException e) {
                System.out.println("we dont accept anything but numbers");
                sc.next();
///added some error management feature using the catch statement.
/// could add another statement later to allow the user to add their own inputs to customise their own query for example the ones where the user enters the number of population or language itself...
            }
        } while (query != 4);///ensures that the app doesn't close unless user asks it to do so.
        sc.close();


    }

    private static void displayQueries() {
        System.out.println("Available Queries");
        for (int i = 0; i < PREDEFINED_QUERIES.length; i++) {
            System.out.println((i + 1) + " . " + PREDEFINED_QUERIES[i]);
        }
        System.out.println("Select a query to run (1-" + PREDEFINED_QUERIES.length + "):");

    }

    private static void executeQuery(int index) {
        if (index < 0 || index >= PREDEFINED_QUERIES.length) {
            System.out.println("Invalid Query");
            return;
        }

        String jdbcurl = "jdbc:mysql://localhost:3306/world";
        String username = "root";
        String password = "BkQR7Aczt";

        try (Connection Con = DriverManager.getConnection(jdbcurl, username, password);
             Statement stmt = Con.createStatement()) {
            ResultSet rs = stmt.executeQuery(PREDEFINED_QUERIES[index]);
            while (rs.next()) {
                System.out.println(rs.getString(1) + ", " + rs.getString(2));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);


        }

    }

    private static void CreateCityQueries() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter City Name");
        String Name = sc.nextLine();
        String query = "SELECT ID, Name, CountryCode, District, Population FROM city WHERE Name LIKE ?";// the ? is used as a place-holder to mark where the scanners input will be placed
//database information
        String jdbcurl = "jdbc:mysql://localhost:3306/world";
        String username = "root";
        String password = "BkQR7Aczt";
        //try method used to link database information with the driver manager.
        try (Connection Con = DriverManager.getConnection(jdbcurl, username, password);
             PreparedStatement pstmt = Con.prepareStatement(query)) {
            // this is saying the prepared statement is equal to the query plus the users input which relies on the scanner object
            pstmt.setString(1, "%" + Name + "%");// the % is used for pattern matching the pattern used here is name as long as the letters match it shouldn't be concerned if the name is in upper or lower case.
//the parameter index is one meaning this is the one and only input we will accept from the user at the moment we can tinker about with that later to add more features when the join elements are implemented.
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1) + " ID" + ", " + rs.getString(2) + " Name" + ", " + rs.getString(3) + " CountryCode" + ", " + rs.getString(4) + " District" + ", " + rs.getString(5) + " Population");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
///the one am working on right now... it should basically allow the user to create all the other missing queries...
    private static void CreateQueries() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter District Name");
        String DistrictName = sc.nextLine();
        String query = "SELECT country.Name AS CountryName, country.Code AS CountryCode, country.Continent, country.Region, country.SurfaceArea, country.IndepYear, country.Population AS CountryPopulation, city.Name AS CityName, city.District, city.Population AS CityPopulation, countrylanguage.Language, countrylanguage.Isofficial, countrylanguage.Percentage FROM country INNER JOIN city ON country.Code = city.CountryCode INNER JOIN countrylanguage ON country.Code = countrylanguage.CountryCode WHERE city.Name LIKE ?";
        /// used inner join to combine the three tables and look up countries based on the district name
        String jdbcurl = "jdbc:mysql://localhost:3306/world";
        String username = "root";
        String password = "BkQR7Aczt";
        try (Connection Con = DriverManager.getConnection(jdbcurl, username, password);
             PreparedStatement pstmt = Con.prepareStatement(query)) {
             pstmt.setString(1, "%" + DistrictName + "%");
             ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rsmd.getColumnName(i) + ": " + rs.getString(i) + (i < columnCount  ? ", " : ""));
                }
                System.out.println();

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}