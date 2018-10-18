package com.haiyu.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @Title: Main
 * @Description:
 * @author: youqing
 * @version: 1.0
 * @date: 2018/8/23 15:39
 */
public class Main {
    public static void main(String[] args) {
        Hello hello = new HelloImpl();

        DynamicProxy dynamicProxy = new DynamicProxy(hello);

        Hello helloProxy = dynamicProxy.getProxy();
        helloProxy.say("jack");
    }
}
