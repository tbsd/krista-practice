package org.acme.rest.json;

public class Address {
    public String street;
    public String suite;
    public String city;
    public int zipcode;
    public Geo geo;

    public Address() {}

    Address(String streetAddress, String city, int postalCode) {
        this.street = streetAddress;
        this.city = city;
        this.zipcode = postalCode;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Address))
            return false;

        Address obj = (Address) other;
        return this.street.equals(obj.street) && this.city.equals(obj.city) &&
                this.zipcode == obj.zipcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }
}
