package com.iscas.r1.lock;

import com.iscas.r1.utils.JedisTools;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import redis.clients.jedis.Jedis;

import java.util.UUID;

/**
 * @Author: zhuquanwen
 * @Description:
 * @Date: 2018/4/26 13:55
 * @Modified:
 **/
@RunWith(JUnit4.class)
public class Test1 {
    /*分布式锁置入值*/
    @Test
    public void test1(){
        String randomStr = UUID.randomUUID().toString();
        boolean flag = JedisTools.tryGetDistributedLock("aaaz", randomStr, 200000);
        System.out.println(flag);
        System.out.println(randomStr);
        Assert.assertTrue(flag);
    }

    /*置入值*/
    @Test
    public void test2(){
       boolean flag = JedisTools.set("aaa","aaaa");
       Assert.assertTrue(flag);
    }

    /*设置获得Object*/
    @Test
    public void test3(){
        boolean result = JedisTools.setObject("obj", "xxxxxx");
        System.out.println(result);
        Object obj = JedisTools.getObject("obj");
        System.out.println(obj);
    }


    /*释放锁*/
    @Test
    public void test4(){
        Boolean flag = JedisTools.releaseDistributedLock("aaaz","a35caa43-aab3-46d8-9763-1139f2cec004");
        System.out.println(flag);
        Assert.assertTrue(flag);
    }

    /*获得String*/
    @Test
    public void test5(){
        String obj = JedisTools.get("a");
        System.out.println(obj);
    }

    /*设置过期时间*/
    @Test
    public void test6(){
        boolean obj = JedisTools.setObject("obj1" ,"xxxxxx",20 );
        System.out.println(obj);
    }

    /*删除某个ObjectKey*/
    @Test
    public void test7(){
        boolean obj = JedisTools.delkeyObject("a");
        System.out.println(obj);
    }

    /*存在某个Key*/
    @Test
    public void test8(){
        boolean obj = JedisTools.existsObject("a");
        System.out.println(obj);
    }
}
