package com.sm.geode.ref.domain;

import com.gemstone.gemfire.DataSerializable;
import com.gemstone.gemfire.pdx.PdxReader;
import com.gemstone.gemfire.pdx.PdxSerializable;
import com.gemstone.gemfire.pdx.PdxWriter;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Created by smanvi on 7/24/16.
 */
public class CustomerDataSerializable implements DataSerializable {
    String firstName;
    String lastName;
    int ssn;

    public CustomerDataSerializable(String firstName, String lastName, int ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
    }

    public void toData(DataOutput dataOutput) throws IOException {

    }

    public void fromData(DataInput dataInput) throws IOException, ClassNotFoundException {

    }
}
