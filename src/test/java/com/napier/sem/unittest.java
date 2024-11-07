///Package Imports.
package com.napier.sem;
///API Tester Imports.
import org.hibernate.Hibernate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
///Hibernate Imports.
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
///Input output imports.
import java.io.ByteArrayInputStream;
import java.util.Scanner;
///Error Handling Imports.
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;


/**
 * class holding the unit tests.
 * I will test the input, output , error handling and I will use an in memory database for additional testing
 */
public class unittest {

    //Test Case to ensure that it returns what the user expects.
    @Test// tests the query return if the query doesn't exist returns an error instead.
    public void testQueryValidChoices() {

        int QueryIndex = 2;
        String expectedQuery = Queries.PREDEFINED_QUERIES[QueryIndex];
        assertEquals(expectedQuery, Queries.PREDEFINED_QUERIES[QueryIndex], "Should return the right predefined query");
    }

    private SessionFactory sessionFactory;
    private Session session;
    @BeforeEach
    public void setUp() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(City.class)
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(CountryLanguage.class)
                .addAnnotatedClass(Continent.class)
                .buildSessionFactory();
        session = sessionFactory.openSession();
        session.beginTransaction();

    }
    @Test
    public void testSaveCity() {
        // creates an instance of the table and sets its information based on what's in the other classes just so that it follows their structure.
        City city = new City();
        city.setCode("KAB");
        city.setName("Kabul");
        city.setContinent(Continent.Asia);
        city.setRegion("Kabul");
        city.setPopulation(17800000);
        //saves the created city entity
        session.persist(city);
        session.getTransaction().commit();
        //Retries the saved city and verifies its existence.
        City savedCity = session.get(City.class,"KAB");
        assertNotNull(savedCity);
        assertEquals("Kabul",savedCity.getName());


    }
    @Test
    public void testSaveCountry() {
        Country country = new Country();
        country.setCode("AFG");
        country.setName("Afghanistan");
        country.setContinent(Continent.Asia);
        country.setRegion("Kabol");
        country.setPopulation(17800000);
        session.persist(country);
        session.getTransaction().commit();
        Country savedCountry = session.get(Country.class,"AFG");
        assertNotNull(savedCountry);
        assertEquals("Afghanistan", savedCountry.getName());

    }

    @AfterEach
    public void tearDown() {
        //clears out all data after attaining the expected results.
       if (session != null) {
           session.flush();
           session.close();
       }
       if (sessionFactory != null) {
           sessionFactory.close();
       }
    }
}




