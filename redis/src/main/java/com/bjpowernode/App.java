package com.bjpowernode;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

public class App{

    public static void main( String[] args ){
        //与redis进行连接  建议建造连接池
       Jedis jedis = new Jedis("192.168.182.128",6379);
       //清空缓存
       jedis.flushAll();
       jedis.set("name", "tom");
       String name = jedis.get("name");
        System.out.println(name);

    }
}
