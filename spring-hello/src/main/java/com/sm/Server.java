package com.sm;

import com.gemstone.gemfire.cache.Region;
import com.sm.geode.ref.domain.Customer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by smanvi on 6/30/16.
 */
public class Server {

    public static void main(String args[]) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("server/cache-config.xml");
        Region<Object, Customer> customerRegion = (Region<Object, Customer>) context.getBean("Customers");
//        Region<Object, Customer> customerRegion = cache.getRegion("Customers");
        customerRegion.put(1,new Customer("John","Doe","NewYork"));
        System.out.println();
        System.out.println("Hit Enter to exit");
        System.in.read();
    }
}
