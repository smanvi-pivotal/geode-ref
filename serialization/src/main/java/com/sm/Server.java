package com.sm;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.CacheFactory;
import com.gemstone.gemfire.cache.Region;
import com.sm.geode.ref.domain.PdxCustomer;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by smanvi on 6/30/16.
 */
public class Server {

    public static void main(String args[]) throws IOException {

        Properties props = new Properties();
        props.setProperty("cache-xml-file", "server/cache-config.xml");
        props.setProperty("locators", "localhost[10334]");
        props.setProperty("name", "S1");
        props.setProperty("mcast-port", "0");


        Cache cache = new CacheFactory(props).create();
        Region<Object, PdxCustomer> customerRegion = cache.getRegion("Customers");
        customerRegion.put(3,new PdxCustomer("John","Doe","NewYork",111111));
        System.out.println("Hit Enter to exit");
        System.in.read();
    }
}
