package com.sm.geode.ref.serialization.pdxserializer;

import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.pdx.PdxReader;
import com.gemstone.gemfire.pdx.PdxSerializer;
import com.gemstone.gemfire.pdx.PdxWriter;
import com.sm.geode.ref.domain.PdxSerializerCustomer;

import java.util.Properties;

/**
 * Created by smanvi on 7/11/16.
 */
public class CustomSerializer implements PdxSerializer, Declarable{
    public void init(Properties properties) {

    }

    public boolean toData(Object o, PdxWriter pdxWriter) {
        if(o instanceof PdxSerializerCustomer){
            PdxSerializerCustomer customer = (PdxSerializerCustomer) o;
            pdxWriter.writeInt("ssn", customer.getSsn()).markIdentityField("ssn");
            pdxWriter.writeString("firstName", customer.getFirstName());
            pdxWriter.writeString("lastName", customer.getLastName());
            pdxWriter.writeString("address", customer.getAddress());
            return true;
        }
        return false;
    }

    public Object fromData(Class<?> aClass, PdxReader pdxReader) {
        if(!aClass.equals(PdxSerializerCustomer.class)){
            return null;
        }
        PdxSerializerCustomer customer = new PdxSerializerCustomer();
        customer.setSsn(pdxReader.readInt("ssn"));
        customer.setFirstName(pdxReader.readString("firstName"));
        customer.setLastName(pdxReader.readString("lastName"));
        customer.setAddress(pdxReader.readString("address"));
        return customer;
    }
}
