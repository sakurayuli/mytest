package com.bjpowernode;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtils {

  private static JedisPool pool = null;
     //创建连接池
  public static JedisPool open(String host,int port){
    //当连接池为空的时候进行创建
    if (pool == null){
      JedisPoolConfig config = new JedisPoolConfig();
      //最大连接数
      config.setMaxTotal(10);
      //最大空闲连接数
      config.setMaxIdle(5);
      pool = new JedisPool(config,host,port);
    }

    return  pool;
  }

  public static void close(){
      if (pool != null){
          pool.close();
      }

  }

}
