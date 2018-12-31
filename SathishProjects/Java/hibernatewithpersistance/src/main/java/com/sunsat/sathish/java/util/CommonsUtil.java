package com.sunsat.sathish.java.util;

import java.util.Properties;

public class CommonsUtil {
    public static void printSystemEnvs() {
        Properties prop = System.getProperties();
        for(Object st : prop.keySet()) {
            System.out.println(st + " : " + prop.getProperty((String)st));
        }
    }
}
