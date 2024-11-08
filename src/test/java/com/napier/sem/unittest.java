///Package Imports.
package com.napier.sem;
///API Tester Imports.
import org.hibernate.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
///Hibernate Imports.
import org.hibernate.cfg.Configuration;
///Input output imports, plan to use them for further unit tests if time allows it.
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


    /**  //Test Case to ensure that it returns what the user expects.
    @Test// tests the query return if the query doesn't exist returns an error instead.
    public void testQueryValidChoices() {

        int QueryIndex = 2;
        String expectedQuery = Queries.PREDEFINED_QUERIES[QueryIndex];
        assertEquals(expectedQuery, Queries.PREDEFINED_QUERIES[QueryIndex], "Should return the right predefined query");
    }*/



    private SessionFactory sessionFactory;
    private Session session;
    Transaction tx = null;
    @BeforeEach
    public void setUp() {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(City.class)
                    .addAnnotatedClass(Country.class)
                    .addAnnotatedClass(CountryLanguage.class)
                    .addAnnotatedClass(Continent.class)
                    .buildSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }

    }
    @Test
    public void testSaveCity() {
        // creates an instance of the table and sets its information based on what's in the other classes just so that it follows their structure.
       try {
           City city = new City();
           city.setCode("KAB");
           city.setName("Kabul");
           city.setContinent(Continent.Asia);
           city.setRegion("Kabul");
           city.setPopulation(17800000);
           //saves the created city entity
           session.persist(city);
           session.getTransaction();
           tx.commit();
           //Retries the saved city and verifies its existence.
           City savedCity = session.get(City.class,"KAB");
           assertNotNull(savedCity);
           assertEquals("Kabul",savedCity.getName());
       } catch (Exception e) {
           throw new RuntimeException(e);
       }


    }
    @Test
    public void testSaveCountry() {
     try {
         Country country = new Country();
         country.setCode("AFG");
         country.setName("Afghanistan");
         country.setContinent(Continent.Asia);
         country.setRegion("Kabul");
         country.setPopulation(17800000);
         session.persist(country);
         session.getTransaction().commit();
         Country savedCountry = session.get(Country.class,"AFG");
         assertNotNull(savedCountry);
         assertEquals("Afghanistan", savedCountry.getName());
     } catch (Exception e) {
         throw new RuntimeException(e);
     }


    }

    @AfterEach
    public void tearDown() {
        //clears out all data after attaining the expected results.
     try {
         if (session != null) {
             session.flush();
             session.close();
         }
         if (sessionFactory != null) {
             sessionFactory.close();
         }
     } catch (Exception e) {
         throw new RuntimeException(e);
     }

    }
}




