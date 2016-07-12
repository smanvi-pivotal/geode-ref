package com.sm.geode.ref.domain;

/**
 * Created by smanvi on 7/11/16.
 */
public class PdxSerializerCustomer {

    String firstName;
    String lastName;
    String address;
    int ssn;

    public PdxSerializerCustomer(String firstName, String lastName, String address, int ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.ssn = ssn;
    }

    public PdxSerializerCustomer() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "PdxSerializerCustomer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", ssn=" + ssn +
                '}';
    }
}
