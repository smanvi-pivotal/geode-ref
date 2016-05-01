import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;

import java.util.Properties;

/**
 * Created by smanvi on 4/29/16.
 */
public class ClientLauncher {


    public static void main(String args[]) {
        ClientLauncher clientLauncher = new ClientLauncher();
        clientLauncher.start();
    }

    private void start() {
        Properties props = new Properties();
        props.setProperty("security-client-auth-init",
                "CustomAuthInit.create");
        props.setProperty("cache-xml-file", "client-cache.xml");
        props.setProperty("security-username", "Srikath-user");
//        props.setProperty(SampleAuthInit.PASSWORD, "xxx");

        ClientCache clientCache = new ClientCacheFactory(props).create();
//                .set("cache-xml-file", "client-cache.xml").create();
        Region<Object, Object> customer = clientCache.getRegion("Customer");
        customer.put(1,"Abc");

        System.out.println("Done Adding to region");

    }
}
