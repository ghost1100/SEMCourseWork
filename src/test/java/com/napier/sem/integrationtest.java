package com.napier.sem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.*;

public class integrationtest {

    /**
     * Quick note: docker Desktop app must be running in the back-ground for this to work.
     * A unit test designed to test if the database connects or not.
     * it defined the connection link, username and password and
     * used driver manager to send them over to then proceed to say that the connection string isn't null,
     * and it also handles different types of errors by catching them at the bottom then informing the user.
     * if the connection fails then its indicated by the fail method along-side a message informing the user as to why it failed
     * below it will be another test case to ensure that we can extract information out of this database.
     */

    @Test
    public void TestDataConnection() {
        String jdbcurl = "jdbc:mysql://localhost:3306/world";
        String username = "root";
        String password = "BkQR7Aczt";
        try (Connection Con = DriverManager.getConnection(jdbcurl, username, password)) {
            assertNotNull(Con, "Database Connection Should Not Be Null");

            System.out.println("Connection Successful");

        } catch (SQLException e) {
            fail("Database connection Failed: " + e.getMessage());
        }

    }

    @Test
    public void TestDataExtraction() {
        String jdbcurl = "jdbc:mysql://localhost:3306/world";
        String username = "root";
        String password = "BkQR7Aczt";
        try (Connection Con = DriverManager.getConnection(jdbcurl, username, password)) {
            Statement stmt = Con.createStatement();
            assertNotNull(Con, "Database Connection Should Not Be Null");
            String Query = "SELECT table_name FROM information_schema.tables WHERE table_schema = 'world'";

            ResultSet rs = stmt.executeQuery(Query);

            System.out.println("Tables in the World database:");
            int TableCount = 0;


            while (rs.next()) {

                String tableName = rs.getString("table_name");

                System.out.println(tableName);
                assertNotNull(tableName, "Table Name Should Not Be Null");
                TableCount++;
            }
            assertTrue(TableCount > 0);
            System.out.println("Connection and Data Extraction Was A Success. :)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    @Test
    public void CityDatabaseTest() {

        String TestCityName = "London" ;

        String query = "SELECT ID, Name, CountryCode, District, Population FROM city WHERE Name LIKE ?";// the ? is used as a place-holder to mark where the scanners input will be placed
//database information
        String jdbcurl = "jdbc:mysql://localhost:3306/world";
        String username = "root";
        String password = "BkQR7Aczt";
        int Count = 0;
        //try the method used to link database information with the driver manager.
        try (Connection Con = DriverManager.getConnection(jdbcurl, username, password);
             PreparedStatement pstmt = Con.prepareStatement(query)) {
            // this is saying the prepared statement is equal to the query plus the users input which relies on the scanner object
            pstmt.setString(1, "%" + TestCityName + "%");// the % is used for pattern matching the pattern used here is name as long as the letters match it shouldn't be concerned if the name is in upper or lower case.
//the parameter index is one meaning this is the one and only input we will accept from the user at the moment we can tinker about with that later to add more features when the join elements are implemented.
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1) + " ID" + ", " + rs.getString(2) + " Name" + ", " + rs.getString(3) + " CountryCode" + ", " + rs.getString(4) + " District" + ", " + rs.getString(5) + " Population");
                Count++;
            }
            assertTrue(Count > 0);
            System.out.println("Connection and Data Extraction Was A Success. :)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }

}




