package com.napier.sem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * this class belongs to com.napier.sem and its functionality is to run the SQL Queries after ensuring that the connection works.
 * I will implement this by using the try resources method, catch and a switch case to run each of the following requested queries.
 * first up would be testing if this idea actually works by running a query that lists out the tables in the database then the columns under said names.
 * and then adding the switch case statement each case will correspond to its own number and query,
 * the cases will first give the user the prompt connecting to database, successfully  connected, thn tables in the (Database Name) along-side listing each table name.
 * Notes/Helpful Resources:
 * Udemy Course.Learn how to connect to a MySQL database with Java JDBC
 * https://docs.oracle.com/javase/tutorial/jdbc/overview/index.html
 *https://www.javatpoint.com/steps-to-connect-to-the-database-in-java
  **/

public class Queries {

    public static void  Statements() throws SQLException {

//set up the try statement with resources
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "BkQR7Aczt")
          ){
// stmt is the statement object which is a short form of writing statement and its responsible for sending the queries to the database and executing them.
            Statement stmt = con.createStatement();
            String Query = "SELECT table_name FROM information_schema.tables WHERE table_schema = 'world'";
            //rs shorter from of ResultSet which is an instance of stmt execute
            ResultSet rs = stmt.executeQuery(Query);
            //System.out.println(rs); instead of printing rs which will result in us printing the query we have made or specified above.
            System.out.println("Tables in the World database:");
            //while rs.next is used to iterate the next line until all lines are there
            while (rs.next()) {
              // gets the current name from the column
                String tableName = rs.getString("table_name");
              //this finally prints the table names.
                System.out.println(tableName);
            }}
        //catch statement is used to specifically notify us of any SQL errors such as a missed line or miss matched sentence.
catch(SQLException e) {
    System.out.println("Error!! take a break!: " + e.getMessage());
    // reminder not using a finally block since try resources is in use.
}}

}
//Start of Erin's work (Its an attempt, we don't need to talk about why its not worki8ntg just yet, note that the //* are the acc lines of code)
        //The top N populated cities in a region where N is provided by the user
        //*public static void Statement16() throws SQLException {
        //connect to database
        //*try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "BkQR7Aczt")) {
            //*Statement stmt = con.createStatement();
            //*Scanner scanner = new Scanner(System.in);
            //get region from user
            //*System.out.print("Enter Region: ");
            //*String choosenRegion = scanner.nextLine();
            //implement SQL query
            //*String Query = "SELECT Name, Population, Region, City FROM world ORDER BY Population DESC";
            //*ResultSet rs = stmt.executeQuery(Query);
            // loop all the cities in a region
            //*while (rs.next()) {
                //*String city = rs.getString("Name");
                //*int population = rs.getInt("Population");
                //*String region = rs.getString("Region");
                //if the region is the region choosen then display population
                //*if(region.equals(choosenRegion)) {
                    //*System.out.println(city + ": " + population);
                //*}
            //*}
            //error message
        //*} catch(SQLException e) {
            //*System.out.println("Error: " + e.getMessage());
        //*}
    //*} //End of populated cities in region 

        //The top N populated cities in the world where N is provided by the user
        //*public static void Statement16() throws SQLException {
        //connect to database
        //*try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "BkQR7Aczt")) {
            //*Statement stmt = con.createStatement();
            //*Scanner scanner = new Scanner(System.in);
            //implement SQL query
            //*String Query = "SELECT Name, Population, City FROM world ORDER BY Population DESC";
            //*ResultSet rs = stmt.executeQuery(Query);
                //*System.out.println(city + ": " + population);
            //*}
            //error message
        //*} catch(SQLException e) {
            //*System.out.println("Error: " + e.getMessage());
        //*}
    //*} //End of populated cities in world 

//The top N populated cities in a district where N is provided by the user
        //*public static void Statement16() throws SQLException {
        //connect to database
        //*try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "BkQR7Aczt")) {
            //*Statement stmt = con.createStatement();
            //*Scanner scanner = new Scanner(System.in);
            //get district from user
            //*System.out.print("Enter District: ");
            //*String choosenDistrict = scanner.nextLine();
            //implement SQL query
            //*String Query = "SELECT Name, Population, District, City FROM world ORDER BY Population DESC";
            //*ResultSet rs = stmt.executeQuery(Query);
            // loop all the cities in a district
            //*while (rs.next()) {
                //*String city = rs.getString("Name");
                //*int population = rs.getInt("Population");
                //*String district = rs.getString("District");
                //if the district is the district choosen then display population
                //*if(district.equals(choosenDistrict)) {
                    //*System.out.println(city + ": " + population);
                //*}
            //*}
            //error message
        //*} catch(SQLException e) {
            //*System.out.println("Error: " + e.getMessage());
        //*}
    //*} //End of populated cities in district 

 //The top N populated cities in a country where N is provided by the user
        //*public static void Statement16() throws SQLException {
        //connect to database
        //*try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "BkQR7Aczt")) {
            //*Statement stmt = con.createStatement();
            //*Scanner scanner = new Scanner(System.in);
            //get country from user
            //*System.out.print("Enter Country: ");
            //*String choosenCountry = scanner.nextLine();
            //implement SQL query
            //*String Query = "SELECT Name, Population, Region, City FROM world ORDER BY Population DESC";
            //*ResultSet rs = stmt.executeQuery(Query);
            // loop all the cities in a country
            //*while (rs.next()) {
                //*String city = rs.getString("Name");
                //*int population = rs.getInt("Population");
                //*String country = rs.getString("Country");
                //if the country is the country choosen then display population
                //*if(country.equals(choosenCountry)) {
                    //*System.out.println(city + ": " + population);
                //*}
            //*}
            //error message
        //*} catch(SQLException e) {
            //*System.out.println("Error: " + e.getMessage());
        //*}
    //*} //End of populated cities in country 

 //The top N populated cities in a continent where N is provided by the user
        //*public static void Statement16() throws SQLException {
        //connect to database
        //*try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "BkQR7Aczt")) {
            //*Statement stmt = con.createStatement();
            //*Scanner scanner = new Scanner(System.in);
            //get continent from user
            //*System.out.print("Enter Continent: ");
            //*String choosenContinent = scanner.nextLine();
            //implement SQL query
            //*String Query = "SELECT Name, Population, Continent, City FROM world ORDER BY Population DESC";
            //*ResultSet rs = stmt.executeQuery(Query);
            // loop all the cities in a continent
            //*while (rs.next()) {
                //*String city = rs.getString("Name");
                //*int population = rs.getInt("Population");
                //*String continent = rs.getString("Continent");
                //if the continent is the continent choosen then display population
                //*if(continent.equals(choosenContinent)) {
                    //*System.out.println(city + ": " + population);
                //*}
            //*}
            //error message
        //*} catch(SQLException e) {
            //*System.out.println("Error: " + e.getMessage());
        //*}
    //*} //End of populated cities in continent 
 
