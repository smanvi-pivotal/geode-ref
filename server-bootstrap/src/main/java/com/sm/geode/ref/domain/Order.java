package com.sm.geode.ref.domain;

import java.io.Serializable;

/**
 * Created by smanvi on 4/24/16.
 */
public class Order implements Serializable {
    Customer customer;
    int orderQuantity;
    int price;

    public Order(Customer customer, int orderQuantity, int price) {
        this.customer = customer;
        this.orderQuantity = orderQuantity;
        this.price = price;
    }
}
