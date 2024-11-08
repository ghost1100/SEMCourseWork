package com.napier.sem;

import jakarta.persistence.*;

@Entity
@Table(name = "city")
public class City {
    @Id
    @Column(name = "Name")
    private String name;
    @Column(name = "CountryCode")
    private String countryCode;
    @Column(name = "District")
    private String district;
    @Column(name = "Population")
    private int population;



    public static String setName(String kabul) {
        return"";
    }
  public String getName(String kabul) {
        this.name= "";
      return kabul;
  }

    public static int setPopulation(int i) {
        return i;
    }

    //getters and setters will be placed below
    public String getName() {
// set to return the name of the city later on inside the testing class.
        return "";
    }




}
