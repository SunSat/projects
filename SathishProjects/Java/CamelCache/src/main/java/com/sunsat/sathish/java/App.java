package com.sunsat.sathish.java;

import org.apache.camel.component.ehcache.EhcacheManager;
import org.apache.camel.component.ehcache.processor.idempotent.EhcacheIdempotentRepository;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.Configuration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.xml.XmlConfiguration;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        System.out.println( "Hello World!" );
        File file = new File("/Users/sathishkumar_su/personal/project/SathishProjects/Java/CamelCache/src/resource/camel-ehcache.xml");
        /*File file = new File("/Users/sathishkumar_su/personal/project/SathishProjects/Java/CamelCache/src/resource/camel-ehcache.xml");

        XmlConfiguration configuration = new XmlConfiguration(file.toURI().toURL());

        CacheManager manager = CacheManagerBuilder.newCacheManager(configuration);
        EhcacheManager ehcacheManager = new EhcacheManager(manager);
        ehcacheManager.start();



        EhcacheIdempotentRepository repository = new EhcacheIdempotentRepository(manager);

        repository.add("hello");

        Map<String,String> map = System.getenv();
        for(String st : map.keySet()) {
            System.out.println(st + " : " + map.get(st));
        }
        Properties prop = System.getProperties();*/


        Configuration xmlConfig = new XmlConfiguration(file.toURI().toURL());
        CacheManager myCacheManager = CacheManagerBuilder.newCacheManager(xmlConfig);

        myCacheManager.init();

        Cache<Long, String> preConfigured = myCacheManager.getCache("dataServiceCache", Long.class, String.class);
        preConfigured.put(1l,"Hello");

        System.out.println(preConfigured.get(1l));


        Cache<Long, String> preConfigured1 = myCacheManager.getCache("dataServiceCache", Long.class, String.class);

        System.out.println(preConfigured1.get(1l));


    }
}
