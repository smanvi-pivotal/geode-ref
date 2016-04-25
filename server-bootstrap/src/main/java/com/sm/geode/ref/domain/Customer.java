package com.sm.geode.ref.domain;

import java.io.Serializable;

/**
 * Created by smanvi on 4/24/16.
 */
public class Customer implements Serializable {

    String name;
    int id;
    String address;

    public Customer(String name, int id, String address) {
        this.name = name;
        this.id = id;
        this.address = address;
    }
}

