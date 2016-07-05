package com.sm;

import com.gemstone.gemfire.cache.Region;
import com.sm.geode.ref.domain.Customer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by smanvi on 6/30/16.
 */
public class Client {

    public static void main(String args[]) throws IOException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("client/cache-config.xml");
        Region<Object, Customer> customerRegion = (Region<Object, Customer>) ctx.getBean("Customers");

        Object c = customerRegion.get(1);
        System.out.println(" RETRIVED :"+c);
    }
}
