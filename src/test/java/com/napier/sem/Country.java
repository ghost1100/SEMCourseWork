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
    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Continent getRegion() {
        return continent;
    }
    public void setRegion(String asia) {
        this.continent = Continent.valueOf(region);
    }

        public void setPopulation(int population) {
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }
    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;

    }
    public double getSurfaceArea() {
        return surfaceArea;
    }
    public void setIndepYear(int indepYear) {
        this.indepYear = indepYear;
    }
    public int getIndepYear() {
        return indepYear;
    }
    public void setGnp(String gnp) {
        this.gnp = gnp;
    }
    public String getGnp() {
        return gnp;
    }
    public void setLocalName(String localName) {
        this.localName = localName;
    }
    public String getLocalName() {
        return localName;
    }
    public void setGovernmentForm(String governmentForm) {
        this.governmentForm = governmentForm;
    }
    public String getGovernmentForm() {
        return governmentForm;
    }
    public void setHeadOfState(String headOfState) {
        this.headOfState = headOfState;
    }
    public String getHeadOfState() {
        return headOfState;
    }
    public void setCapital(String capital) {
        this.capital = capital;
    }
    public String getCapital() {
        return capital;
    }
    public void setCode2(String code2) {
        this.code2 = code2;
    }
    public String getCode2() {
        return code2;
    }
}
