package com.sm.geode.ref;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.sm.geode.ref.domain.Customer;
import com.sm.geode.ref.domain.PdxCustomer;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by smanvi on 4/24/16.
 */
public class DataLoader implements Serializable{

    ClientCache clientCache;

    public DataLoader(ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    int[] zip = {27519, 28560, 10100, 20200,30300,40400,50500,60600,70700,80800};

    public void loadManyCustomers(Cache cache){
        Region<Object, PdxCustomer> customerRegion = cache.getRegion("Customer");
        String fname = "John";
        String lastName="Doe";
        String address = "Downtown";
        Random random = new Random();
        int zipCount=0;

        Long zipTracker=2016416048000L;
        int ssnTracker=0;
        for(int i = 0; i<1000; i++){
             if(ssnTracker>=100){
                 zipTracker = zipTracker + 1000;
                 ssnTracker=0;
             }

            String ii = String.valueOf(i);
//            PdxCustomer customer = new PdxCustomer(fname+ii,lastName+ii,address+ii,i,zip[random.nextInt(9)]+zipCount);
            PdxCustomer customer = new PdxCustomer(fname+ii,lastName+ii,address+ii, zipTracker+ssnTracker, zipTracker);
            customerRegion.put(i,customer);

            ++ssnTracker;
        }

        System.out.println("DONE LOADING CUSTOMERS");
    }


    public DataLoader() {
    }

    public static void main(String args[]) {
        DataLoader dl = new DataLoader();
        dl.connect();
        dl.loadSampleData();

        dl.getData();

    }

    private void getData() {
        Region<Integer, Customer> customerRegion = clientCache.getRegion("Customer");
        Customer c = customerRegion.get(1);
        System.out.println(" OUTTTT : "+c);
    }

    private void loadSampleData() {
        Region<Integer, Customer> customerRegion = clientCache.getRegion("Customer");
        Customer c1 = new Customer("John","AAA","123 Street, Cary NC");
//        c1.cards = Collections.EMPTY_LIST;
        Customer c2 = new Customer("Jane","sdfdfs","456 Street, Raleigh NC");
//        c2.cards = Collections.EMPTY_LIST;
//
        Customer c3 = new Customer("Jake","sdfsdsf","1200 Street, Cary NC");
//        List<String> namesList = new ArrayList<String>();
//        Region<Integer, String> customerRegion = clientCache.getRegion("Customer");
//        try {
//            BufferedReader bf = new BufferedReader(new FileReader("/Users/smanvi/Downloads/names/sample_names.csv"));
//            String name;
//            while(true) {
//                name=bf.readLine();
//                if(name==null || name.length()==0) break;
//                namesList.add(bf.readLine());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        int i=0;
//        for(String name : namesList){
//            i++;
//            customerRegion.put(i,name);
//        }
        customerRegion.put(1,c1);
        customerRegion.put(2,c2);
        customerRegion.put(3,c3);

    }

    private void connect() {
        clientCache = new ClientCacheFactory().set("cache-xml-file","client-cache.xml").create();
    }
}
