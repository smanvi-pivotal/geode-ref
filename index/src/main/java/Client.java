import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.query.QueryService;
import com.gemstone.gemfire.internal.cache.PartitionedRegion;
import com.sm.geode.ref.domain.PdxCustomer;

/**
 * Created by smanvi on 7/12/16.
 */
public class Client {

    public static void main(String args[]) {


        ClientCache clientCache = new ClientCacheFactory().set("cache-xml-file","client/cache-config.xml").create();
        QueryService queryService = clientCache.getDefaultPool().getQueryService();
//        for (int i = 2000; i < ; i++) {

//        }
//        queryService.newQuery("")

        Region<Object, PdxCustomer> customerRegion = clientCache.getRegion("Customers");

        PdxCustomer c = customerRegion.get(3);
        PartitionedRegion p = (PartitionedRegion) customerRegion;
        
        System.out.println(" RETRIVED :"+c);
    }
}
//    <trace>select count (*) from /Customer where zip=3000
