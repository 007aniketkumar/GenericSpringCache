/**
 * 
 */
package com.ani.cacheconfig;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.google.common.cache.CacheBuilder;

import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.cache.guava.GuavaCacheManager;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.*;


/**
 * 
 * This class passes the cache manager pertaining to Ehcache as well as Gauva cache
 * 
 * To set the configurations for ehcache , the client can make use of ehcache.xml and set the 
 * appropriate ehcache settings
 * 
 * 
 * To set the configurations of Guava cache, pass the parameters appropriately.
 * 
 * Next steps : To extract the complete configurations details.
 * 
 * 
 * Create a factory , where the client can pass the Cache he desires to use , along with basic parameters, like TTL etc
 * and then create the cache appropriately.
 * 
 * 
 * Also provide the support of using annotations  , so that the Ehcache/Guava cache can be used directly on the class/method being invoked.
 * 
 * @author aniket
 *
 */
@Configuration
@EnableCaching
public class CacheConfig {
	
	
	
	@Bean
	public CacheManager ehCacheManager() {
        //A EhCache based Cache manager
		return new EhCacheCacheManager(ehCacheCacheManager().getObject());

	}
	
	
	
	/*
	 * 
	 * The ehcache.xml is configurable and the client incorporating it should configure it
	 * 
	 * 
	 */
	
	@Bean
    public EhCacheManagerFactoryBean ehCacheCacheManager() {
        EhCacheManagerFactoryBean factory = new EhCacheManagerFactoryBean();
        factory.setConfigLocation(new ClassPathResource("ehcache.xml"));
        factory.setShared(true);
        return factory;
    }

	
	
	//plug Guava cahce.
	
	
	/*
	 * 
	 * Pass this bean and the configuation such as expiry Time , and Cache name 
	 * 
	 * 
	 */
	@Bean
	public CacheManager guavaCache() {
		
		GuavaCacheManager guavaCacheManager = new GuavaCacheManager();
		 guavaCacheManager.setCacheBuilder(CacheBuilder.newBuilder().expireAfterAccess(30, TimeUnit.MINUTES));
		 return guavaCacheManager;
		
		
 }
	}
	
	

