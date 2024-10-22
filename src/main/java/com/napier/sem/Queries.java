package com.napier.sem;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.util.Scanner;
import java.util.InputMismatchException;


/**
 * this class will be used to create an array of some sorts (will figure that out later...) to store Predetermined Queries and a switch statement to display a dew options to the user.
 * one of the options would be to display the pre-made queries and the other option would be used to exit the app.
 * if the user chooses option one it presents them with the queries and they can choose which one to run.
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
            System.out.println("2.exit");

            try {
                query = sc.nextInt();

                switch (query) {
                    case 1:
                        displayQueries();
                        int querychoice = sc.nextInt();
                        executeQuery(querychoice - 1);
                        break;
                    case 2:
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
        } while (query != 2);
        sc.close();


    }

private static void displayQueries() {
    System.out.println("Available Queries");
    for (int i = 0; i < PREDEFINED_QUERIES.length; i++) {
        System.out.println((i + 1) + " . " + PREDEFINED_QUERIES[i]);
    }
    System.out.println("Select a query to run (1-" + PREDEFINED_QUERIES.length + "):");

}
        private static void executeQuery(int index){
            if (index < 0 || index >= PREDEFINED_QUERIES.length){
                System.out.println("Invalid Query");
                return;
            }

            String jdbcurl = "jdbc:mysql://localhost:3306/world";
            String username = "root";
            String password = "BkQR7Aczt";

            try(Connection Con = DriverManager.getConnection(jdbcurl, username,password);
            Statement stmt = Con.createStatement()){
                ResultSet rs = stmt.executeQuery(PREDEFINED_QUERIES[index]);
                while (rs.next()) {
                    System.out.println(rs.getString(1) + ", " + rs.getString(2));

                }

            }catch (SQLException e) {
                throw new RuntimeException(e);

        }
    }
}
