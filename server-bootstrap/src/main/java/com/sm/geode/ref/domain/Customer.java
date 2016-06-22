package com.sm.geode.ref.domain;

import java.util.Collections;
import java.util.List;

/**
 * Created by smanvi on 4/24/16.
 */
public class Customer {

    String name;
    int id;
    String address;

    public List<String> cards;

    public Customer() {
    }

    public Customer(String name, int id, String address) {
        this.name = name;
        this.id = id;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}

