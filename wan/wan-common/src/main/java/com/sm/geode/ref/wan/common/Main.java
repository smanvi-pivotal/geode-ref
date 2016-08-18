package com.sm.geode.ref.wan.common;

import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.sm.geode.ref.DataLoader;

/**
 * Created by smanvi on 8/2/16.
 */
public class Main {

    DataLoader dataLoader;

    public static void main(String args[]) {
        Main main = new Main();
        main.init();
    }

    private void init() {
        ClientCache clientCache = new ClientCacheFactory().set("cache-xml-file", "client-cache.xml").create();
        dataLoader = new DataLoader(clientCache);
        dataLoader.loadBigData();
    }

}
