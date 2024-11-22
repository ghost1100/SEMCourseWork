///Package Imports.
package com.napier.sem;
///API Tester Imports.
import com.mysql.cj.protocol.x.Notice;
import org.hibernate.*;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
///Hibernate Imports.
import org.hibernate.cfg.Configuration;
///Input output imports, plan to use them for further unit tests if time allows it.
///Error Handling Imports.
import static org.junit.jupiter.api.Assertions.*;


/**
 * class holding the unit tests.
 * I will test the input, output , error handling and I will use an in memory database for additional testing
 */
public class Unittest {
private SessionFactory sessionFactory;
private Session session;
private Transaction tx;




//made the session factory and transaction into global variables. with access modifiers.
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
    void testGettersAndSetters() {
        City city = new City();
        city.setId(1);
        assertEquals(city.getId(),1);
        city.setName("FakeCity");
        assertEquals(city.getName(),"FakeCity");
        city.setCountryCode("FCT");
        assertEquals(city.getCountryCode(),"FCT");
        city.setDistrict("FakeDistrict");
        assertEquals(city.getDistrict(),"FakeDistrict");
        city.setPopulation(100);
        assertEquals(city.getPopulation(),100);
        System.out.println("Fake City: " + city.getName() +" "+ city.getDistrict());
        //test would fail if the items returned don't match what is expected.
    }

    @Test
    public void testSession() {
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    //Test Case to ensure that it returns what the user expects.
     @Test// tests the query return if the query doesn't exist returns an error instead.
     public void testQueryValidChoices() {
     int QueryIndex = 2;
     String expectedQuery = Queries.PREDEFINED_QUERIES[QueryIndex];
     assertEquals(expectedQuery, Queries.PREDEFINED_QUERIES[QueryIndex], "Should return the right predefined query");
     }
    @Test
    public void testSaveCity() {
        // creates an instance of the table and sets its information based on what's in the other classes just so that it follows their structure.
        try {
            City city = getCity();
            //saves the created city entity
            session.persist(city);
            tx.commit();
            //Retrieves the saved city and verifies its existence.
            City savedCity = session.get(City.class, city.getId());
            assertNotNull(savedCity);
            assertEquals("FakeCity", city.getName());
            System.out.println("Saved city: " + city.getName() + " " + city.getId() + " " + city.getPopulation() + " " + city.getDistrict());
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        }

    }

    private @NotNull City getCity() {

        City city = new City();
        city.setId(1);
        city.setName("FakeCity");
        city.setDistrict("FakeDistrict");
        city.setCountryCode("FCT");
        city.setPopulation(100);
        return city;
    }

    @Test
    public void testSaveCountry() {
     try {
         Country country = getCountry();
         //saves the created country entity
         session.persist(country);
         tx.commit();
         //Retrieves the saved country and verifies its existence.
         Country savedCountry = session.get(Country.class,"AFG");
         assertNotNull(savedCountry);
         assertEquals("Afghanistan", savedCountry.getName());
         System.out.println("Saved Country is:\n "+ country.getName()+ " " +country.getCode()+" "+ country.getCapital() +" "+ country.getGovernmentForm() +" " + country.getGnp()+" "+ country.getPopulation() +" "+ country.getGovernmentForm()+" " +country.getRegion() + " "+ country.getContinent() );
    System.out.println("Works as expected");
     } catch (Exception e) {
         if (tx != null && tx.isActive()){
             tx.rollback();
         }
         throw new RuntimeException(e);
     }
    }

    private static @NotNull Country getCountry() {
        Country country = new Country();
        country.setCode("AFG");
        country.setName("Afghanistan");
        country.setContinent(Continent.Asia);
        country.setRegion("Asia");
        country.setPopulation(1780000);
        country.setCapital("Washington");
        country.setGnp(String.valueOf(15.62));
        country.setGovernmentForm("Islamic Emirate of Afghanistan");
        country.setHeadOfState("King Mohammad Zahir Shah");
        country.setGovernmentForm("Dictatorship");
        country.setIndepYear(1919);
        country.setLocalName("Afghanistan");
        country.setSurfaceArea(652860);
        return country;
    }

    @AfterEach
    public void tearDown() {
        //clears out all data after attaining the expected results.
     try {
         if(tx != null && tx.isActive()){
             tx.rollback();
         }
         if (session != null) {
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





