package com.bjsxt.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Farewell is well
 * @date 2019-11-19 13:59
 * redis缓存配置
 */
@Configuration("RedisCacheConfig")
public class RedisCacheConfig2 implements KeyGenerator {
    /**
     *说明:SpringBoot2.0版本后，Spring容器中默认提供了一个 RedisTemplate<Object, Object>对象
     *    但是该对象的泛型以及序列化器通常难以满足我们的需求，因此我们配置了一个自定义的RedisTem
     *    plate对象，泛型为<String, Object>，同时将Value序列化器类型指定为Json序列化器
     */
    @Bean
    public RedisTemplate<String, Object> getRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new GenericJackson2JsonRedisSerializer());
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    /**
     * 说明：CacheManager对象在Spring容器中也有默认的提供，在application.properties文件中就
     *      可以配置默认过期文件中就可以配置默认过期时间、是否取消缓存空值，是否使用前缀，但是在
     *      properties文件中，无法对缓存的后缀和序列化器类型进行明确的定义，因此我们要自定义一个
     *      CacheManager对象，实现符合需求的个性化配置
     */
    //@Bean
    public CacheManager getDefaultCacheManager(RedisConnectionFactory redisConnectionFactory) {
        // 默认缓存配置对象
        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig()
                // 设置缓存默认统一过期时间
                .entryTtl(Duration.ofMillis(60000))
                // 设置Key序列化器
                .serializeKeysWith(RedisSerializationContext.SerializationPair
                        .fromSerializer(new StringRedisSerializer()))
                // 设置Value序列化器
                .serializeValuesWith(RedisSerializationContext.SerializationPair
                        .fromSerializer(new GenericJackson2JsonRedisSerializer()))
                // 取消缓存空值
                .disableCachingNullValues()
                //设置缓存前缀(双引号中的字符串)
                .computePrefixWith(cacheName -> "prefix::" + cacheName);

        return RedisCacheManager
                .builder(redisConnectionFactory)
                .cacheDefaults(defaultCacheConfig)
                .transactionAware()
                .build();
    }
    @Bean
    public CacheManager getMultiCacheManager(RedisConnectionFactory redisConnectionFactory) {
        // 默认缓存配置对象
        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig()
                //设置缓存前缀
                .computePrefixWith(cacheName -> "Application:" +cacheName)
                // 设置Key序列化器
                .serializeKeysWith(RedisSerializationContext.SerializationPair
                        .fromSerializer(new StringRedisSerializer()))
                // 设置Value序列化器
                .serializeValuesWith(RedisSerializationContext.SerializationPair
                        .fromSerializer(new GenericJackson2JsonRedisSerializer()))
                // 取消缓存空值
                .disableCachingNullValues();
        Set<String> cacheNames = new HashSet<>();
        cacheNames.add("OneMinute");
        cacheNames.add("FiveMinutes");
        Map<String, RedisCacheConfiguration> configMap = new HashMap<>();
        configMap.put("OneMinute", defaultCacheConfig
                .entryTtl(Duration.ofMinutes(1)));
        configMap.put("FiveMinutes", defaultCacheConfig
                .entryTtl(Duration.ofMinutes(5)));
        return RedisCacheManager.builder(redisConnectionFactory)
                .initialCacheNames(cacheNames)
                .withInitialCacheConfigurations(configMap)
                .transactionAware()
                .build();
    }

    /**
     * 自定义缓存后缀名
     */
    @Override
    public Object generate(Object target, Method method, Object... params) {
        int count = method.getParameterCount();
        int i=0;
        StringBuilder sb = new StringBuilder("[");
        for (Object param : params) {
            i++;
            sb.append(param.toString());
            if(i==count){
                break;
            }
            sb.append(",");
        }
        sb.append("]");
        System.out.println(sb);
        return ":"+method.getName()+sb;
    }
}
