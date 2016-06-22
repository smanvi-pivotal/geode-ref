import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.CacheFactory;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.snapshot.SnapshotOptions;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * This class creates sample data and exports the data to a file
 */
public class ExportImportExample {

    ClientCache clientCache;
    Region<Integer, String> customerRegion;


    @Before
    public void setup(){
        clientCache = new ClientCacheFactory().set("cache-xml-file","client-cache.xml").create();
        customerRegion = clientCache.getRegion("Customer");
    }

    @Test
    public void loadSampleData() {
        customerRegion.put(1, "Mike");
        customerRegion.put(2, "Isabella");
        customerRegion.put(3, "John");
        customerRegion.put(4, "Olivia");
        customerRegion.put(5, "Ava");
        customerRegion.put(6, "Elizabeth");
        customerRegion.put(7, "Adam");
        customerRegion.put(8, "Alex");
        customerRegion.put(9, "Jack");
        customerRegion.put(10, "Dan");
    }

    @Test
    public void exportRegion(){

        File snapShotDir = new File("snapshots");
        Cache cache = CacheFactory.getInstance(clientCache.getDistributedSystem());

        try {
            cache.getSnapshotService().save(snapShotDir, SnapshotOptions.SnapshotFormat.GEMFIRE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void clearRegion(){
        customerRegion.clear();
    }

    @Test
    /*
        Make sure your region is empty before running import. Run the clearRegion() test.
     */
    public void importRegion(){
        Cache cache = CacheFactory.getInstance(clientCache.getDistributedSystem());
        File mySnaphot = new File("/Users/smanvi/Workspace/geode-ref/import-export/snapshots/snapshot-Customer");
        try {
            cache.getSnapshotService().load(mySnaphot, SnapshotOptions.SnapshotFormat.GEMFIRE);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
