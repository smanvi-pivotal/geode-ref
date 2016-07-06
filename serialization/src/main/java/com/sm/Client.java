package com.sm;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.CacheFactory;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.sm.geode.ref.domain.Customer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by smanvi on 6/30/16.
 */
public class Client {

    public static void main(String args[]) throws IOException {

        Properties props = new Properties();
        props.setProperty("cache-xml-file", "client/cache-config.xml");
//        props.setProperty("locators", "localhost[10334]");

        ClientCache clientCache = new ClientCacheFactory(props).create();

        Region<Object, Customer> customerRegion = clientCache.getRegion("Customers");
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("server/cache-config.xml");
//        Region<Object, Customer> customerRegion = (Region<Object, Customer>) context.getBean("Customers");
////        Region<Object, Customer> customerRegion = cache.getRegion("Customers");

        Customer c = customerRegion.get(1);
        System.out.println(" RETRIVED :"+c);
    }
}
