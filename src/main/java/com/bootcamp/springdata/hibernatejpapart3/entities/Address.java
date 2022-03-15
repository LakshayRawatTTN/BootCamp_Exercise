package com.bootcamp.springdata.hibernatejpapart3.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private int streetnumber;
    private String location;
    private String street;

    public int getStreetNumber() {
        return streetnumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetnumber = streetNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
