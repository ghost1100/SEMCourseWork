package com.napier.sem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;
class QueriesTest {

    /** Quick note: docker Desktop app must be running in the back-ground for this to work.
     * A unit test designed to test if the database connects or not.
     * it defined the connection link, username and password and
     * used driver manager to send them over to then proceed to say that the connection string isn't null,
     and it also handles different types of errors by catching them at the bottom then informing the user.
     if the connection fails then its indicated by the fail method along-side a message informing the user as to why it failed
     below it will be another test case to ensure that we can extract information out of this database.
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
                System.out.println("Connection Successful");
assertNotNull(tableName,"Table Name Should Not Be Null");
TableCount++;
            }
            assertTrue(TableCount > 0);
            System.out.println("Connection and Data Extraction Was A Success. :)");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}

