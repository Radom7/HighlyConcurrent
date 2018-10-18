package com.haiyu.proxy.cglib;

import com.haiyu.proxy.jdk.Hello;
import com.haiyu.proxy.jdk.HelloImpl;

/**
 * @Title: Main
 * @Description:
 * @author: youqing
 * @version: 1.0
 * @date: 2018/8/23 15:54
 */
public class Main {
    public static void main(String[] args) {
        CGLibProxy cgLibProxy = new CGLibProxy();

        //Hello helloProxy = CGLibProxy.getInstance().getProxy(HelloImpl.class);
        Hello helloProxy = cgLibProxy.getProxy(HelloImpl.class);

        helloProxy.say("jack");
    }
}
