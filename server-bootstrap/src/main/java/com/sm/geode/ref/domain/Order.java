package com.sm.geode.ref.domain;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * Created by smanvi on 4/24/16.
 */
public class Order implements Serializable {
    Customer customer;
    int orderQuantity;
    int price;

    List cards = Collections.EMPTY_LIST;

    public Order() {
    }

    public Order(Customer customer, int orderQuantity, int price) {
        this.customer = customer;
        this.orderQuantity = orderQuantity;
        this.price = price;
    }
}
