package org.example;

public class Address {
    public String streetAddress;
    public String city;
    public int postalCode;

    public Address() {}

    Address(String streetAddress, String city, int postalCode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.postalCode = postalCode;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Address))
            return false;

        Address obj = (Address) other;
        return this.streetAddress.equals(obj.streetAddress) && this.city.equals(obj.city) &&
                this.postalCode == obj.postalCode;
    }
}
