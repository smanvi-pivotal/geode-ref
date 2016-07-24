package com.sm.geode_ref.sdg.serialization;

import org.springframework.data.gemfire.mapping.Region;

/**
 * Created by smanvi on 7/18/16.
 */
@Region
public class Person {

    int id;

    String fName;
    String lName;

}
