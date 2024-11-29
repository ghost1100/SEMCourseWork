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
 * I will use 2 formats of commenting the // to make comments which I don't want to stand out as much and the ///for green comments that I want to see.
 * the third format is just this which should be on-top of every method or class.
 */
public class Queries {

    public static final String[] PREDEFINED_QUERIES = {
            ///this is where the queries would go.
            //Ahmed.
            // selects every city based on most populated first, Issue Number 9...
            "SELECT *  FROM city order by population DESC ",
            //selects the most popular cities in a continent this time its Asia, Issue Number 10...
            " SELECT city.Name, city.CountryCode, city.District, city.Population  FROM city INNER JOIN country ON city.CountryCode = country.Code Where country.Continent = 'Asia' ORDER BY population DESC ",
            // selects the most popular Cities in a District, Issue Number 13...
            " SELECT city.Name, city.CountryCode, city.Population  FROM city INNER JOIN country ON city.CountryCode = country.Code Where city.District = 'Scotland' ORDER BY population DESC ",
            //all the cities in a country from the largest population to smallest in this case its france, Issue Number 12...
            "SELECT city.Name, city.CountryCode, city.Population  FROM city INNER JOIN country ON city.CountryCode = country.Code Where country.Name = 'France' ORDER BY population DESC",
            // All the cities in a region organised by largest population to the smallest, Issue Number 11...last query to add.
    };

    public static void choice() {
        Scanner sc = new Scanner(System.in);
        ///created an instance of the scanner object which would be used to detect the user's input and named it sc.
        int query = 0;
        do {
            System.out.println("Welcome to Napier Sem Course Application");
            System.out.println("Enter Number For Desired Query");
            System.out.println("1.Display Available Queries Issues Number 9,10,13,12,(11 not yet added)");
            System.out.println("2.Create Your Own City Queries");
            System.out.println("3.Create Your Own Country Queries");
            System.out.println("4.Rachel's Queries");
            System.out.println("5.Robbie's Queries");
            System.out.println("6.Erin's Queries Soon to Be Issue Num 20-35");
            System.out.println("7.Exit APP");
// number 1 which is display available queries is basically a dynamic switch case within a static one allowing me to modify its length at any time without having to go and change the numbers over and over like a static one would.
            //it mostly relies on the for loop as long as the input is bigger than i but smaller than the predefined list it will increment I and execute the query in the list
            //then there is the if statement saying is the index which == predefined queries is smaller than 0 which = I then the choice isn't valid which is an error detection and handling method.
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
                        System.out.println("please choose which query you'd like to run");
                        System.out.println("1. All the countries in the world organised by largest population to smallest report #19");
                        System.out.println("2. All the countries in a continent organised by largest population to smallest report #20");
                        System.out.println("3.All the countries in a region organised by largest population to smallest report #21");
                        System.out.println("4.The top N populated countries in a continent where N is provided by the user #23");
                        System.out.println("5.The top N populated countries in the world where N is provided by the user #22 ");

                        int Num = sc.nextInt();
                        if (Num == 5) {
                            Statement5();
                            choice();
                        }
                        if (Num == 4) {
                            Statement4();
                            choice();
                        }
                        if (Num == 3) {
                            Statement3();
                            choice();
                        }
                        if (Num == 2) {
                            Statement2();
                            choice();
                        }
                        if (Num == 1) {
                            Statement1();
                            choice();
                        }
                        else {
                            System.out.println("Please enter a valid number");
                            choice();
                        }
                        break;
                    case 5: ///I choose the easiest way to include all the code by just having if statements inside the switch case so its static instead of dynamic
                        // Robbie, please edit the "" Statements later to display what the number of the issue is alongside what it does.
                        // like this: the N of City in the Country Where user provides \N, Issue #15
                        System.out.println("please choose which query you'd like to run");
                        //Please change these to what the query does then add the issue number at the end.
                        System.out.println("All the capital cities in the world organised by largest population to smallest #19");
                        System.out.println("All the capital cities in a region organised by largest to smallest report #21");
                        System.out.println("The top N populated capital cities in the world where N is provided by the user # 22");
                        System.out.println("All the capital cities in a continent organised by largest population to smallest #20");
                        System.out.println("The top N populated capital cities in a continent where N is provided by the user # 23");

                        int Num2 = sc.nextInt();
                        if (Num2 == 5) {
                            Statement10();//Works as expected!
                            choice();
                        }
                        if (Num2 == 4) {
                            Statement9();// works as expected!
                            choice();
                        }
                        if (Num2 == 3) {
                            Statement8();//Works as expected!
                            choice();
                        }
                        if (Num2 == 2) {
                            Statement7();//Works as expected!
                            choice();
                        }
                        if (Num2 == 1) {
                            Statement6();//Works as expected!
                            choice();
                        }
                        else {
                            System.out.println("Please enter a valid number");
                            choice();
                        }

                    case 6:
                        System.out.println("please choose which query you'd like to run");
                        System.out.println("1. The top N populated cities in a region where N is provided by the user.    ///*What's Missing here is the Issue Number!!");
                        System.out.println("2. The top N populated cities in the world where N is provided by the user.   (!Issue Number)");
                        System.out.println("3. The top N populated cities in a district where N is provided by the user.  (!Issue Number)");
                        System.out.println("4. The top N populated cities in a country where N is provided by the user.   (!Issue Number)");
                        System.out.println("5. The top N populated cities in a continent where N is provided by the user. (!Issue Number)");
                        int Num3 = sc.nextInt();
                        if (Num3 == 1) {
                            Statement16();//Works As Expected!
                            choice();
                        }
                        if (Num3 == 2) {
                            Statement17(); // Works As Expected!
                            choice();
                        }
                        if (Num3 == 3) {
                            Statement18(); // Works As Expected!
                            choice();
                        }
                        if (Num3 == 4) {
                            Statement19(); // Works As Expected!
                            choice();
                        }
                        if (Num3 == 5) {
                            Statement20(); // Works As Expected!
                            choice();
                        }
                        else {
                            System.out.println("Please enter a valid number");
                            choice();
                        }


                        break;
                    case 7:
                        System.out.println("exiting the application");
                        break;

                    default:
                        System.out.println("Invalid Choice try again later");
                }
            } catch (InputMismatchException | SQLException e) {
                System.out.println("we dont accept anything but numbers");
                choice();
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
        try (Connection Con = DriverManager.getConnection(DatabaseConfig.jdbcurl(),DatabaseConfig.username(), DatabaseConfig.password());
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
      
        //try the method used to link database information with the driver manager.
        try (Connection Con = DriverManager.getConnection(DatabaseConfig.jdbcurl(),DatabaseConfig.username(), DatabaseConfig.password());
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
      
        try (Connection Con = DriverManager.getConnection(DatabaseConfig.jdbcurl(),DatabaseConfig.username(), DatabaseConfig.password());
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

    /**(//The top N populated capital cities in a region where N is provided by the user
    public static void Statement21() throws SQLException {
        //open database
        try(Connection con = DriverManager.getConnection(DatabaseConfig.jdbcurl(),DatabaseConfig.username(), DatabaseConfig.password())) {
            Statement stmt = con.createStatement();
            Scanner scanner = new Scanner(System.in);
            //get N from user
            System.out.print("Enter N: ");
            int n = Integer.parseInt(scanner.nextLine());
            //implement SQL query
            String Query = "SELECT Capital, Population FROM country GROUP BY Region ORDER BY Population DESC";
            ResultSet rs = stmt.executeQuery(Query);
            //initialise count
            int count = 0;
            //loop top N populated countries
            while (rs.next()) {
                String Capital = rs.getString("Capital");
                int population = rs.getInt("Population");
                String Region = rs.getString("Region");
                System.out.println("Region: "+ Region +", " + "Capital: " + Capital + ", " + "Population: " + population);
                count++;
                //if count is greater than n then the loop ends
                if (count >= n) {
                    break;
                }
            }
            //error message
        } catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
     */

    

    //The top N populated countries in the world where N is provided by the user #22
    public static void Statement5() throws SQLException {
        //open database
        try(Connection con = DriverManager.getConnection(DatabaseConfig.jdbcurl(),DatabaseConfig.username(), DatabaseConfig.password())) {
            Statement stmt = con.createStatement();
            Scanner scanner = new Scanner(System.in);
            //get N from user
            System.out.print("Enter N: ");
            int n = Integer.parseInt(scanner.nextLine());
            //implement SQL query
            String Query = "SELECT Name, Population FROM country ORDER BY Population DESC";
            ResultSet rs = stmt.executeQuery(Query);
            //initialise count
            int count = 0;
            //loop top N populated countries
            while (rs.next()) {
                String country = rs.getString("Name");
                int population = rs.getInt("Population");
                System.out.println(country + ": " + population);
                count++;
                //if count is greater than n then the loop ends
                if (count >= n) {
                    break;
                }
            }
            //error message
        } catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //The top N populated countries in a continent where N is provided by the user #23
    public static void Statement4() throws SQLException {
        //open database
        try(Connection con = DriverManager.getConnection(DatabaseConfig.jdbcurl(),DatabaseConfig.username(), DatabaseConfig.password())) {
            Statement stmt = con.createStatement();
            Scanner scanner = new Scanner(System.in);
            //get the continent from the user
            System.out.print("Enter Continent: ");
            String chosenContinent = scanner.nextLine();
            //get n from the user
            System.out.print("Enter N: ");
            int n = Integer.parseInt(scanner.nextLine());
            //implement SQL query
            String Query = "SELECT Name, Population, Continent FROM country ORDER BY Population DESC";
            ResultSet rs = stmt.executeQuery(Query);
            //initialise count
            int count = 0;
            //loop top N populated countries in a continent
            while (rs.next()) {
                String country = rs.getString("Name");
                int population = rs.getInt("Population");
                String continent = rs.getString("Continent");
                //if the continent is the continent chosen from the user then display info
                if (continent.equals(chosenContinent)) {
                    System.out.println(country + ": " + population);
                    count++;
                }
                //if count is greater than n then the loop ends
                if (count >= n) {
                    break;
                }
            }
            //error message
        } catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //All the countries in a region organised by largest population to the smallest report #21
    public static void Statement3() throws SQLException {
        //connect to database
        try(Connection con = DriverManager.getConnection(DatabaseConfig.jdbcurl(),DatabaseConfig.username(), DatabaseConfig.password())) {
            Statement stmt = con.createStatement();
            Scanner scanner = new Scanner(System.in);
            //get region from user
            System.out.print("Enter Region: ");
            String chosenRegion = scanner.nextLine();
            //implement SQL query
            String Query = "SELECT Name, Population, Region FROM country ORDER BY Population DESC";
            ResultSet rs = stmt.executeQuery(Query);
            // loop all the countries in a region
            while (rs.next()) {
                String country = rs.getString("Name");
                int population = rs.getInt("Population");
                String region = rs.getString("Region");
                //if the region is the region chosen then display population
                if(region.equals(chosenRegion)) {
                    System.out.println(country + ": " + population);
                }
            }
            //error message
        } catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //All the countries in a continent organised by largest population to the smallest report #20
    public static void Statement2() throws SQLException {
        //open database
        try(Connection con = DriverManager.getConnection(DatabaseConfig.jdbcurl(),DatabaseConfig.username(), DatabaseConfig.password())) {
            Statement stmt = con.createStatement();
            Scanner scanner = new Scanner(System.in);
            //get continent from user
            System.out.print("Enter Continent: ");
            String chosencontinent = scanner.nextLine();
            //implement SQL query
            String Query = "SELECT Name, Population, Continent FROM country ORDER BY Population DESC";
            ResultSet rs = stmt.executeQuery(Query);
            //loop all the countries in a continent
            while (rs.next()) {
                String country = rs.getString("Name");
                int population = rs.getInt("Population");
                String continent = rs.getString("Continent");
                //if the continent matches the chosen continent display info
                if(continent.equals(chosencontinent)) {
                    // Print the city name, population, and continent
                    System.out.println(country + ": " + population);
                }
            }
            //error message
        } catch(SQLException e) {
            System.out.println("Error!! take a break!: " + e.getMessage());
        }
    }

    //All the countries in the world organised by largest population to the smallest report #19
    public static void Statement1() throws SQLException {
        //open database
        try(Connection con = DriverManager.getConnection(DatabaseConfig.jdbcurl(),DatabaseConfig.username(), DatabaseConfig.password())) {
            Statement stmt = con.createStatement();

            //implement SQL query
            String Query = "SELECT Name, Population FROM country ORDER BY Population DESC";
            ResultSet rs = stmt.executeQuery(Query);
            //loop all the countries in the world
            while (rs.next()) {
                String country = rs.getString("Name");
                int population = rs.getInt("Population");
                System.out.println(country + ": " + population);
            }
            //error message
        } catch(SQLException e) {
            System.out.println("Error!! take a break!: " + e.getMessage());
        }// instead of using an array or switch case within a switch case again I took the lazy route by just adding if statements and a catch at the end.
    }
    public static void Statement6() throws SQLException {
        try(Connection con = DriverManager.getConnection(DatabaseConfig.jdbcurl(),DatabaseConfig.username(), DatabaseConfig.password())) {
            Statement stmt = con.createStatement();
            String Query = "SELECT city.Name, city.Population FROM country " +
                    "JOIN city ON country.Capital = city.ID " +
                    "ORDER BY city.Population DESC";
            ResultSet rs = stmt.executeQuery(Query);
            while (rs.next()) {
                String city = rs.getString("Name"); // will get the name from the column name
                int population = rs.getInt("Population");// this will get the population from the column population
                // Print
                System.out.println(city + ": " + population);
            }
        } catch(SQLException e) {
            System.out.println("Error!! take a break!: " + e.getMessage());
        }
    }

    public static void Statement7() throws SQLException {

        //Query to get the capital cities in a chosen region defined by user.
        String query ="""
            SELECT city.Name, city.Population
            FROM country
            JOIN city ON country.Capital = city.ID
            WHERE country.Region = ?
            ORDER BY city.Population DESC
            """;

        try(Connection con = DriverManager.getConnection(DatabaseConfig.jdbcurl(),DatabaseConfig.username(), DatabaseConfig.password())) {
            PreparedStatement pstmt = con.prepareStatement(query);
            Scanner scanner = new Scanner(System.in);

            //getting user input for the region
            System.out.print("Enter Region: ");
            String chosenRegion = scanner.nextLine();

            //Setting up the parameter for the prepared statement.
            pstmt.setString(1, chosenRegion);

            //Executing the Query.
            ResultSet rs = pstmt.executeQuery();

            //Displaying results.
            System.out.println("Capital cities in region: " + chosenRegion);
            while (rs.next()) {
                String city = rs.getString("Name");
                int population = rs.getInt("Population");
                // Print
                System.out.println(city + ": " + population);
            }
        } catch(SQLException e) {
            System.out.println("Error!! take a break!: " + e.getMessage());
        }
    }
    public static void Statement8() throws SQLException {
        //query
        String query ="""
                SELECT city.Name, city.Population
                FROM country
                JOIN city ON country.Capital = city.ID
                ORDER BY city.Population DESC
                LIMIT ?
                """;
        try(Connection con = DriverManager.getConnection(DatabaseConfig.jdbcurl(),DatabaseConfig.username(), DatabaseConfig.password())) {
            PreparedStatement pstmt = con.prepareStatement(query);
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the number of top capital cities you'd like to retrieve: ");
            int N = scanner.nextInt();

            if (N <= 0) {
                System.out.println("Please Enter a positive number");
                return;
            }
            pstmt.setInt(1, N);

            //Displaying the results/Executing the query.
            ResultSet rs = pstmt.executeQuery();
            System.out.println("Top " + N + " capital cities by Population:  ");
            while (rs.next()) {
                String city = rs.getString("Name");
                int population = rs.getInt("Population");
                System.out.println(city + ": " + population);
            }
        }
        catch(SQLException e) {
            System.out.println("Error!! take a break!: " + e.getMessage());
        }

    }
    public static void Statement9() throws SQLException {
        try(Connection con = DriverManager.getConnection(DatabaseConfig.jdbcurl(),DatabaseConfig.username(), DatabaseConfig.password())) {
            Statement stmt = con.createStatement();
            Scanner scanner = new Scanner(System.in);
            System.out.print(" enter continent: ");
            String chosenContinent = scanner.nextLine();
            String Query = "SELECT city.Name, city.Population FROM country " +
                    "JOIN city ON country.Capital = city.ID = true AND Continent = '" + chosenContinent + "' ORDER BY Population DESC";
            ResultSet rs = stmt.executeQuery(Query);
            while (rs.next()) {
                String city = rs.getString("Name"); // this will get the string name from the column name
                int population = rs.getInt("Population");// this will get the string population from the column
                // Print
                System.out.println(city + ": " + population);
            }
        } catch(SQLException e) {
            System.out.println("Error!! take a break!: " + e.getMessage());
        }
    }
    public static void Statement10() throws SQLException {

      
        try(Connection con = DriverManager.getConnection(DatabaseConfig.jdbcurl(),DatabaseConfig.username(), DatabaseConfig.password())) {
            Scanner scanner = new Scanner(System.in);{
                System.out.print("Enter the number of top capital cities you want to retrieve: ");
                int N = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter the continent: ");
                String chosenContinent = scanner.nextLine();

                String query = "SELECT Name, Population FROM country WHERE Continent = ? AND Capital IS NOT NULL ORDER BY Population DESC LIMIT ?";
                try(PreparedStatement pstmt = con.prepareStatement(query)) {
                    pstmt.setString(1, chosenContinent);
                    pstmt.setInt(2, N);
                    ResultSet rs = pstmt.executeQuery();

                    System.out.println("Top " + N + " capital cities by Population:  ");
                    while (rs.next()) {
                        String city = rs.getString("Name");
                        int population = rs.getInt("Population");
                        System.out.println(city + ": " + population);

                    }
                }catch(SQLException e) {
                    System.out.println("Error!! take a break!: " + e.getMessage());
                }
            }
        }
       }
    ///Start of Erin's work (It's an attempt, we don't need to talk about why it's not working just yet, note that the //* are the acc lines of code) I noticed and Honestly, great Idea.
    //The top N populated cities in a region where N is provided by the user ///*What's Missing here is the Issue Number!!
    public static void Statement16() throws SQLException {
        //connect to database
        try(Connection con = DriverManager.getConnection(DatabaseConfig.jdbcurl(),DatabaseConfig.username(), DatabaseConfig.password())) {
            Scanner scanner = new Scanner(System.in);
            //get region from user
            System.out.print("Enter Region: ");
            String chosenRegion = scanner.nextLine();
            //implement SQL query
            String query = "SELECT city.Name AS City, city.Population AS Population " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.Code " +
                    "WHERE country.Region = ? " +
                    "ORDER BY city.Population DESC";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, chosenRegion);
            ResultSet rs = pstmt.executeQuery();
            System.out.println("Cities in region: " + chosenRegion + ":");
            while (rs.next()) {
                String city = rs.getString("City");
                int population = rs.getInt("Population");
                System.out.println(city + ": " + population);
            }
        }
        catch(SQLException e) {
            System.out.println("Error!! take a break!: " + e.getMessage());
        }
    }
    ///End of populated cities in region

    //The top N populated cities in the world where N is provided by the user
    //it's similar to the last one but this time instead of asking for region its either continent or you can hard-wire continent
    //be careful you've named all of them statement 16 which will cause issues later.
    public static void Statement17() throws SQLException {
        //connect to database
        try(Connection con = DriverManager.getConnection(DatabaseConfig.jdbcurl(),DatabaseConfig.username(), DatabaseConfig.password())) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the number of top populated cities to display: ");
            int N = scanner.nextInt();
            ///int ..... -> scanner.nextLine(); this would be used under the definition of another variable to give it value.

            //implement SQL query
            String query = "SELECT Name, Population FROM city ORDER BY Population DESC LIMIT ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, N);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                String city = rs.getString("Name");
                int population = rs.getInt("Population");
                System.out.println(city + ": " + population);

            }
        }
        /* error message */
        catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    //End of populated cities in world

    //The top N populated cities in a district where N is provided by the user
    public static void Statement18() throws SQLException {
        //connect to database
        try(Connection con = DriverManager.getConnection(DatabaseConfig.jdbcurl(),DatabaseConfig.username(), DatabaseConfig.password())) {
            Scanner scanner = new Scanner(System.in);
            // Gets district from user
            System.out.println("Enter District: ");
            String chosenDistrict = scanner.nextLine();

            //Get the number of populated cities (N) from the user.
            System.out.println("Enter the number of top Populated cities to Display: ");
            int N = scanner.nextInt();

            //preparing the SQL Query.
            String query = "SELECT Name, Population " +
                    "FROM city " +
                    "WHERE District = ? " +
                    "ORDER BY Population DESC " +
                    "LIMIT ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, chosenDistrict);// Setting the district.
            pstmt.setInt(2, N);// setting the Limit.

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String city = rs.getString("Name");
                int population = rs.getInt("Population");
                System.out.println(city + ": " + population);
            }
        }
        catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());}
    }
    //End of populated cities in district

    //The top N populated cities in a country where N is provided by the user
    public static void Statement19() throws SQLException {
        //connect to database
        try(Connection con = DriverManager.getConnection(DatabaseConfig.jdbcurl(),DatabaseConfig.username(), DatabaseConfig.password())) {
            Statement stmt = con.createStatement();
            Scanner scanner = new Scanner(System.in);
            //get country from user
            System.out.print("Enter Country: ");
            String chosenCountry = scanner.nextLine();
            System.out.print("Enter Number of populated cities to display: ");
            int N = scanner.nextInt();


            //implement SQL query
            String query = "SELECT city.Name AS City, city.Population AS Population " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.Code " +
                    "WHERE country.Name = ? " +
                    "ORDER BY city.Population DESC " +
                    "LIMIT ?";

            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, chosenCountry);
            pstmt.setInt(2, N);
            ResultSet rs = pstmt.executeQuery();

            //Displaying thr results
            System.out.println("Top" + N + " populated cities in country:" + chosenCountry + ":");
            while (rs.next()) {
                String city = rs.getString("City");

                int population = rs.getInt("Population");
                System.out.println(city + ": " + population);}
        }catch (SQLException e) {
            System.out.println("Take a Break!! Error: " + e.getMessage());
        }
    }
    //End of populated cities in country

    //The top N populated cities in a continent where N is provided by the user
    public static void Statement20() throws SQLException {
        //connect to database
        try(Connection con = DriverManager.getConnection(DatabaseConfig.jdbcurl(),DatabaseConfig.username(), DatabaseConfig.password())) {
            Statement stmt = con.createStatement();
            Scanner scanner = new Scanner(System.in);


            //get continent from user
            System.out.print("Enter Continent: ");
            String chosenContinent = scanner.nextLine();

            //get the number of, top populated cities (N) from the user.
            System.out.print("Enter Number of populated cities to display: ");
            int N = scanner.nextInt();
            String query = "SELECT city.Name AS city, city.Population AS Population " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.Code " +
                    "ORDER BY city.Population DESC " +
                    "LIMIT ?";

            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, N);
            //executing  the Query
            ResultSet rs = pstmt.executeQuery();

            //Displaying the results.
            System.out.println("TOP" + N + " populated cities in country:" + chosenContinent + ":");
            while (rs.next()) {
                String city = rs.getString("City");
                int population = rs.getInt("Population");
                System.out.println(city + ": " + population);
            }
        } catch (SQLException e) {
            System.out.println(" !!!Take Another Break!!! Error: " + e.getMessage());
        }



    }
    //End of populated cities in continent
}