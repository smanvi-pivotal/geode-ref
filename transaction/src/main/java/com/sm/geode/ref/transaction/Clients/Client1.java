package com.sm.geode.ref.transaction.Clients;

import com.gemstone.gemfire.cache.CacheTransactionManager;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;

import javax.transaction.TransactionManager;
import java.util.*;

/**
 * Created by smanvi on 5/2/16.
 */
public class Client1 {

    ClientCache clientCache;

    public static void main(String args[]) {
        Client1 client1 = new Client1();
        client1.init();
        client1.start();

    }


    private void start() {
//        CacheTransactionManager txn = clientCache.getCacheTransactionManager();
        Region<Object, Object> customer = clientCache.getRegion("Customer");
        Set<Map.Entry<Object, Object>> entries = customer.entrySet();

        Iterator<Map.Entry<Object, Object>> iterator = entries.iterator();
        System.out.println("Region Size : "+entries.size());
        while(iterator.hasNext()){
            Map.Entry<Object, Object> next = iterator.next();
            System.out.println(next.getKey()+ " - "+ next.getValue());
        }

//        txn.begin();
//        customer.put(1,"Abc");
//        customer.put(2,"CDE");
//        customer.put(3,"xxxx");
//        try {
//            System.out.println("Going To sleep");
//            Thread.sleep(800*1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        customer.put(4,"rerrr");
//        txn.commit();
//
//        System.out.println("Done With Commit");

    }

    private void init() {
        clientCache = new ClientCacheFactory()
                .set("cache-xml-file", "client-cache.xml").create();

    }
}
