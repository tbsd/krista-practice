package org.example;

public class PhoneNumber {
    private String phone;

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
