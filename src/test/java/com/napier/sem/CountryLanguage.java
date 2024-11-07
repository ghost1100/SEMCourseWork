package com.napier.sem;

import jakarta.persistence.*;

@Entity
@Table (name = "countryLanguage")
public class CountryLanguage {
    @Id
    @ManyToOne
    @JoinColumn(name = "CountryCode")
    private Country country;
    @Column(name = "IsOfficial")
    private boolean isOfficial;
    @Column(name = "Percentage")
    private double percentage;
    //getters and setters will be placed below
    public Country getCountry() {

        return null;
    }
    public void setCountry(Country country) {
        this.country = country;

    }
}
