package com.sm;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.Region;
import com.sm.domain.Customer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by smanvi on 6/30/16.
 */
public class Server {

    public static void main(String args[]) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("server/cache-config.xml");
        Cache cache = context.getBean(Cache.class);
        Region<Object, Object> orderRegion = cache.getRegion("Order");
        orderRegion.put(1,new Customer("John","Doe","NewYork"));
        System.out.println();
        System.out.println("Hit Enter to exit");
        System.in.read();
    }
}
