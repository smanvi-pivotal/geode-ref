import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.CacheFactory;
import com.sm.geode.ref.DataLoader;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by smanvi on 7/12/16.
 */
public class Server {

    public static void main(String args[]) {

        Properties props = new Properties();
        props.setProperty("locators", "localhost[10334]");
        props.setProperty("name", "S1");
        props.setProperty("mcast-port", "0");
        props.setProperty("log-level", "config");
        props.setProperty("cache-xml-file","server-cache.xml");

        Cache cache = new CacheFactory(props).create();

        DataLoader dataLoader = new DataLoader();
        dataLoader.loadManyCustomers(cache);
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
