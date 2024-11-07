package com.napier.sem;

import jakarta.persistence.*;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @Column(name = "Code")
    private String code;
    @Column (name = "Name")
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
    //getters and setters will be placed below


    public Continent getContinent() {
        return continent;
    }
    public void setContinent(Continent continent) {}

    public String getName() {

        return "";
    }

    public void setPopulation(int i) {
    }

    public void setRegion(String kabul) {
    }

    public void setName(String afghanistan) {
    }

    public void setCode(String afg) {
    }
}
