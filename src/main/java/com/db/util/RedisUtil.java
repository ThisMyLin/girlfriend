package com.db.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

@SuppressWarnings(value = "all")
public class RedisUtil {

    private static Logger log = LoggerFactory.getLogger(RedisUtil.class);

    @Autowired
    private static JedisPool jedisPool;

    /**
     * 从redis中获取数据
     * @param key redis 键
     * @return
     */
    public static String get(String key){
        String result = "";
        if("".equals(key) || key == null){
            return result;
        }
        try {
            Jedis jedis = jedisPool.getResource();
            result = jedis.get(key);
            jedis.close();
        }catch (Exception e){
            log.error("redis连接失败");
         e.printStackTrace();
        }
        return result;
    }

    /**
     * 保存数据到redis中
     * @param key
     * @param value
     * @param period
     */
    public static void set(String key,String value,int period){
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            jedis.set(key,value);
            jedis.expire(key,period);
        }catch (Exception e){
            log.error("redis连接失败");
            e.printStackTrace();
        }
    }

    /**
     * 删除redis中的数据
     * @param key
     */
    public static void del(String key){
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            jedis.del(key);
        }catch (Exception e){
            log.error("redis连接失败");
            e.printStackTrace();
        }
    }

    /**
     * 一次从redis中删除多个数据
     * @param key
     */
    public static void dels(String ...key){
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            jedis.del(key);
        }catch (Exception e){
            log.error("redis连接失败");
            e.printStackTrace();
        }
    }
}
