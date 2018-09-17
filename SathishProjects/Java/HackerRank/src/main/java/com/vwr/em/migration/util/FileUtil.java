package com.vwr.em.migration.util;

import org.apache.log4j.Logger;

import java.io.File;

/**
 * Created by sathishkumar_su on 7/13/2018.
 */
public class FileUtil {

    private static Logger logger = Logger.getLogger(FileUtil.class);

    public static void creaateDir(String path) {
        try {
            File f = new File(path);
            if(!f.canExecute()) {
                f.mkdirs();
            }
        }catch (Exception e) {
            logger.error("error while creating the Directory and the dir name is : " + path, e);
        }
    }
}
