package com.napier.sem;

import jakarta.persistence.*;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "Name", nullable = false, length = 50)
    private String name;
    @Column(name = "CountryCode", nullable = false, length = 3)
    private String countryCode;
    @Column(name = "District",nullable = false, length = 50)
    private String district;
    @Column(name = "Population", nullable = false)
    private int population;

    //getters and setters will be placed below
  public City(){
      super();
  }
  public int getId() {
      return id;
  }
  public void setId(int id) {
      this.id = id;
  }
  public String getName() {
      return name;
  }
  public void setName(String name) {
      this.name = name;
  }
  public String getCountryCode() {
      return countryCode;
  }
  public void setCountryCode(String countryCode) {
      this.countryCode = countryCode;
  }
  public String getDistrict() {
      return district;
  }
  public void setDistrict(String district) {
      this.district = district;
  }
  public int getPopulation() {
      return population;
  }
  public void setPopulation(int population) {
      this.population = population;
  }

}
