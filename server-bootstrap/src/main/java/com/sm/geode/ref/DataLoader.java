package com.sm.geode.ref;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.sm.geode.ref.domain.Customer;

/**
 * Created by smanvi on 4/24/16.
 */
public class DataLoader{

    ClientCache clientCache;

    public static void main(String args[]) {
        DataLoader dl = new DataLoader();
        dl.connect();
        dl.loadData();
    }

    private void loadData() {
        Region<Integer, Customer> customerRegion = clientCache.getRegion("Customer");
        Customer c1 = new Customer("John",1,"123 Street, Cary NC");
        Customer c2 = new Customer("Jane",2,"456 Street, Raleigh NC");
        Customer c3 = new Customer("Jake",3,"1200 Street, Cary NC");

        customerRegion.put(1,c1);
        customerRegion.put(2,c2);
        customerRegion.put(3,c3);

    }

    private void connect() {
        clientCache = new ClientCacheFactory().set("cache-xml-file","client-cache.xml").create();
    }
}
