package com.vwr.em.migration.util;

import com.vwr.em.migration.MigrationProcess;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Properties;
import static com.vwr.em.migration.util.MigrationConstants.*;

/**
 * Created by sathishkumar_su on 7/13/2018.
 */
public class PropertyUtil {

    public static String filePath = DEFAULT_RESOURCE_PATH;
    private  static PropertyUtil proReader = null;
    private static Properties migProperty = null;

    private static Logger logger = Logger.getLogger(PropertyUtil.class);

    private static void init() {
        logger.debug("Entering Property Util Init. Reading data from proty file");
        try {
            InputStream inStream = PropertyUtil.class.getClassLoader().getResourceAsStream(filePath);
            InputStreamReader inReader = new InputStreamReader(inStream);
            migProperty = new Properties();
            migProperty.load(inReader);
            logger.debug("Data loaded successfully. All property names are : " + migProperty.propertyNames());
            inReader.close();
            inStream.close();
        } catch (FileNotFoundException e) {
            logger.error("Erroe while loading propery. File Not found." , e);
        } catch (IOException e) {
            logger.error("Erroe while loading propery. IOException " , e);
        }
        logger.debug("Existing Property Util Init. Reading data from proty file");
    }

    public static String getProperty(String propName) {
        if(migProperty == null) {
            init();
        }
        logger.debug("The requeted property name is : "+propName+". And the value is : " + migProperty.getProperty(propName));
        return migProperty.getProperty(propName);
    }
}
