package com.sm;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by smanvi on 6/28/16.
 */
public class Launcher {

    public static void main(String args[]) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
    }
}
