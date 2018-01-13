package com.sunsat.sathish.java.hackerrank.preparation.jarUtilities;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.zip.ZipFile;

/**
 * Created by sathishkumar_su on 12/6/2017.
 */
public class JarReadsAndCheck {
    public static void main(String[] args) {

        File f = new File("C:\\vem-app-code\\CAR-128-jenkins\\em-1.0-SNAPSHOT\\WEB-INF\\lib");
        File[] jarFiles = f.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if(name.endsWith(".jar"))
                    return true;
                else
                    return  false;
            }
        });
        for(File jarFile : jarFiles) {
            try {
                ZipFile file = new ZipFile(jarFile);
                file.entries();
                //System.out.println(jarFile.getName());
            } catch (IOException e) {
                System.out.println("Error File Name is : " + jarFile.getName());
            }
        }
    }
}

