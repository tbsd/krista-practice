package org.example;

public class PhoneNumber {
    public String phone;

    public PhoneNumber() {}

    PhoneNumber(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof PhoneNumber))
            return false;

        PhoneNumber obj = (PhoneNumber) other;
        return this.phone.equals(obj.phone);
    }
}
