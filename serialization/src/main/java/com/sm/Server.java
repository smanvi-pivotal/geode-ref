package com.sm;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.CacheFactory;
import com.gemstone.gemfire.cache.Region;
import com.sm.geode.ref.domain.Customer;

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

        Cache cache = new CacheFactory(props).create();
        Region<Object, Customer> customerRegion = cache.getRegion("Customers");
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("server/cache-config.xml");
//        Region<Object, Customer> customerRegion = (Region<Object, Customer>) context.getBean("Customers");
////        Region<Object, Customer> customerRegion = cache.getRegion("Customers");
        customerRegion.put(1,new Customer("John","Doe","NewYork"));
        System.out.println("Hit Enter to exit");
        System.in.read();
    }
}
