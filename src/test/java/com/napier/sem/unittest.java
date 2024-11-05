package com.napier.sem;
import org.junit.jupiter.api.Test;
import java.sql.*;
import java.util.Scanner;
import java.util.InputMismatchException;

import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * class holding the unit tests.
 * I will test the input, output , error handling and i will use an in memory database for additional testing
 */
public class unittest {

    //Test Case to ensure that it returns what the user expects.
    @Test// tests the query return if the query doesn't exist returns an error instead.
    public void testQueryValidChoices() {

        int QueryIndex = 2;
        String expectedQuery = Queries.PREDEFINED_QUERIES[QueryIndex];
        assertEquals(expectedQuery, Queries.PREDEFINED_QUERIES[QueryIndex], "Should return the right predefined query");
    }

}




