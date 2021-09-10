package com.bjpowernode;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.util.List;

public class App3
{
    public static void main( String[] args )
    {
        JedisPool pool=null;
       try{
           pool=RedisUtils.open("192.168.182.128",6379);
           Jedis jedis=pool.getResource();
           jedis.flushAll();
           Transaction transaction = jedis.multi();
           transaction.set("a", "1");
           transaction.set("b", "2");
           transaction.set("c", "3");
           List<Object> oList = transaction.exec();
           for (Object o : oList) {
               System.out.println(o);
           }
       }catch (Exception e){
           e.printStackTrace();;
       }finally{
           RedisUtils.close();
       }
    }
}
