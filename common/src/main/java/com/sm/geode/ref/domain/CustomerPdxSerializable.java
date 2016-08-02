package com.sm.geode.ref.domain;

import com.gemstone.gemfire.pdx.PdxReader;
import com.gemstone.gemfire.pdx.PdxSerializable;
import com.gemstone.gemfire.pdx.PdxWriter;

/**
 * Created by smanvi on 7/24/16.
 */
public class CustomerPdxSerializable implements PdxSerializable {
    String firstName;
    String lastName;
    int ssn;

    public CustomerPdxSerializable(String firstName, String lastName, int ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
    }

    public void toData(PdxWriter pdxWriter) {
        pdxWriter.writeString("fname", firstName);
        pdxWriter.writeString("lname", lastName);
        pdxWriter.writeInt("ssn",ssn);
    }

    public void fromData(PdxReader pdxReader) {
        pdxReader.readString("fname");
        pdxReader.readString("lname");
        pdxReader.readInt("ssn");
    }
}
