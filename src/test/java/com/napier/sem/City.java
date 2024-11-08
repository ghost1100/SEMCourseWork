package com.napier.sem;

import jakarta.persistence.*;

@Entity
@Table(name = "city")
public class City {
    @Id
    @Column(name = "Code")
    private String code;
    @Column(name = "Name")
    private String name;
    @Column(name = "Continent")
    @Enumerated(EnumType.STRING)
    private Continent continent;
    @Column(name = "Region")
    private String region;
    @Column(name = "SurfaceArea")
    private double surfaceArea;
    @Column(name = "IndepYear")
    private int indepYear;
    @Column(name = "Population")
    private int population;
    @Column(name = "LifeExpectancy")
    private double lifeExpectancy;
    @Column(name = "GNP")
    private String gnp;
    @Column(name = "LocalName")
    private String localName;
    @Column(name = "GovernmentForm")
    private String governmentForm;
    @Column(name = "HeadOfState")
    private String headOfState;
    @Column(name = "Capital")
    private String capital;
    @Column(name = "Code2")
    private String code2;

    public static void setContinent(Continent continent) {
    }

    public static void setRegion(String kabul) {
    }

    public static void setCode(String kab) {
    }

    public static void setName(String kabul) {
    }

    public static void setPopulation(int i) {

    }

    //getters and setters will be placed below
    public String getName() {
// set to return the name of the city later on inside the testing class.
        return "";
    }




}
