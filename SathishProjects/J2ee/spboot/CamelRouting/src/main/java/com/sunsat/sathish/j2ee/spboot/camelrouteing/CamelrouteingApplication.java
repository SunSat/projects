package com.sunsat.sathish.j2ee.spboot.camelrouteing;

import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.Configuration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.xml.XmlConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.net.MalformedURLException;
import java.time.Duration;

@SpringBootApplication
@RestController
public class CamelrouteingApplication {

    public static void main(String[] args) {
        SpringApplication.run(CamelrouteingApplication.class, args);

    }



    @Autowired
    ProducerTemplate producerTemplate;


    @RequestMapping({"/posts"})
    public String callingPost() {
        Object object = producerTemplate.sendBodyAndHeaders("direct:post",
                ExchangePattern.InOut,null,null);

        return object.toString();
    }

    @RequestMapping("/comments")
    public String callingComments() throws MalformedURLException {
        Object object = producerTemplate.sendBodyAndHeaders("direct:comments",
                ExchangePattern.InOut, null,null);
        String data = cachedata();
       // return object.toString();
        return data;
    }

    public String  getCacheData() throws MalformedURLException {
        File file = new File("/Users/sathishkumar_su/personal/project/SathishProjects/Java/CamelCache/src/resource/camel-ehcache.xml");

        Configuration xmlConfig = new XmlConfiguration(file.toURI().toURL());
        CacheManager myCacheManager = CacheManagerBuilder.newCacheManager(xmlConfig);
        /*myCacheManager.createCache("test-cache",CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class,
                ResourcePoolsBuilder.newResourcePoolsBuilder().offheap(1, MemoryUnit.MB)).withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(180))));
        myCacheManager.createCache("",CacheConfigurationBuilder)*/

        myCacheManager.init();

        Cache<Long, String> preConfigured = myCacheManager.getCache("dataServiceCache", Long.class, String.class);
        if(preConfigured.get(1L) == null) {
            preConfigured.put(1l, "Hello");
           System.out.println("FROM SOURCE Data ::"+preConfigured.get(1L));
           return preConfigured.get(1L);
        }
        System.out.println("FROM CACHE Data ::"+preConfigured.get(1L));
        return  preConfigured.get(1L);

    }

    public String cachedata(){
        try(CacheManager persistentCacheManager =
                    CacheManagerBuilder.newCacheManagerBuilder()
                            .withCache("test-cache",
                                    CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class,
                                            ResourcePoolsBuilder.newResourcePoolsBuilder().offheap(1, MemoryUnit.MB))
                                            .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(120))))
                            .build(true)) {

            Cache<Long, String> cache = persistentCacheManager.getCache("test-cache", Long.class, String.class);
            if(cache.get(1L) == null) {
                cache.put(1L, "test");
                return "From Code ::"+cache.get(1L);
            }
            return "From Cache ::"+cache.get(1L);
        }
    }

}
