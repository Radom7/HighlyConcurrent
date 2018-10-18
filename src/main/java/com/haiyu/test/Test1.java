package com.haiyu.test;

/**
 * @Title: Test1
 * @Description:
 * @author: youqing
 * @version: 1.0
 * @date: 2018/8/24 10:18
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println("最大堆："+Runtime.getRuntime().maxMemory()/1024/1024+"M");
        System.out.println("空闲堆："+Runtime.getRuntime().freeMemory()/1024/1024+"M");
        System.out.println("总的堆："+Runtime.getRuntime().totalMemory()/1024/1024+"M");

    }
}
