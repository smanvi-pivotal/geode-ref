import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.sm.geode.ref.domain.PdxSerializerCustomer;

import java.io.IOException;

/**
 * Created by smanvi on 6/30/16.
 */
public class Client {

    public static void main(String args[]) throws IOException {

        ClientCache clientCache = new ClientCacheFactory().set("cache-xml-file","client-config.xml").create();

        Region<Object, PdxSerializerCustomer> customerRegion = clientCache.getRegion("Customers");

        PdxSerializerCustomer c = customerRegion.get(3);
        System.out.println(" RETRIVED :"+c);
    }
}
