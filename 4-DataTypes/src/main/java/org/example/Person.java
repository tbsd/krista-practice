package org.example;

import java.util.ArrayList;

public class Person {
    private String firstName;
    private String lastName;
    private Address address;
    private ArrayList<PhoneNumber> phoneNumbers;

    Person(String firstName, String lastName, Address address, ArrayList<PhoneNumber> phoneNumbers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Person))
            return false;
        Person obj = (Person) other;
        return this.firstName.equals(obj.firstName) && this.lastName.equals(obj.lastName) &&
                this.address.equals(obj.address) && this.phoneNumbers.equals(obj.phoneNumbers);
    }
}
