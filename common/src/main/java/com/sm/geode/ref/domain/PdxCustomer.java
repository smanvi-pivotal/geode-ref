package com.sm.geode.ref.domain;

/**
 * Created by smanvi on 7/7/16.
 */
public class PdxCustomer {


    String firstName;
    String lastName;
    String address;
    Long ssn;
    Long zip;

    public PdxCustomer(String firstName, String lastName, String address, Long ssn, Long zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.ssn = ssn;
        this.zip = zip;
    }

    //Needed for serialization
    public PdxCustomer(){}

    public PdxCustomer(String firstName, String lastName, String address, Long ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.ssn=ssn;
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


    @Override
    public String toString() {
        return "PdxCustomer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", ssn=" + ssn +
                ", zip=" + zip +
                '}';
    }

    public Long getSsn() {
        return ssn;
    }

    public void setSsn(Long ssn) {
        this.ssn = ssn;
    }

    public Long getZip() {
        return zip;
    }

    public void setZip(Long zip) {
        this.zip = zip;
    }
}
