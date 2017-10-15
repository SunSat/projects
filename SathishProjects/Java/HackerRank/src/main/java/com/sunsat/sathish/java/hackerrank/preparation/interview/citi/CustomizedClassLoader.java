package com.sunsat.sathish.java.hackerrank.preparation.interview.citi;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

/**
 * Created by ssundar2 on 6/19/2017.
 */
public class CustomizedClassLoader extends ClassLoader {

    CustomizedClassLoader() {
        super(CustomizedClassLoader.class.getClassLoader());
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] newClass  = loadClassData(name);
        return defineClass(name,newClass,0,newClass.length);
    }

    private byte[] loadClassData(String name) {
        try (JarFile jFile = new JarFile("C:/personal/Sample/jar2.jar")) {
            ZipEntry entry = jFile.getEntry("preparation/interview/citi/A.class");
            ByteArrayOutputStream osStreem = new ByteArrayOutputStream();
            InputStream reader = jFile.getInputStream(entry);
            int len = 0;
            while((len = reader.read()) != 0) {
                osStreem.write(len);
            }
            osStreem.flush();
            return osStreem.toByteArray();
        }catch (IOException ex) {
            System.out.println(ex.getCause());
        }
        return new byte[10];
    }
}
