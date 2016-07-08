package com.sm;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.sm.geode.ref.domain.PdxCustomer;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by smanvi on 6/30/16.
 */
public class Client {

    public static void main(String args[]) throws IOException {

        ClientCache clientCache = new ClientCacheFactory().set("cache-xml-file","client/cache-config.xml").create();

        Region<Object, PdxCustomer> customerRegion = clientCache.getRegion("Customers");

        PdxCustomer c = customerRegion.get(3);
        System.out.println(" RETRIVED :"+c);
    }
}
