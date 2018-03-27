package com.sunsat.sathish.j2ee.health.base;

import java.io.File;

/**
 * Created by sathishkumar_su on 2/26/2018.
 */
public class BaseConstants {
    public static String seperator = File.separator;
    public static String basePath = seperator + "WEB-INF" + seperator;
    public static String propertiesPath = basePath + seperator + "properties" + seperator;
    public static String daoPropPath = propertiesPath + "jdbc.properties";

}
