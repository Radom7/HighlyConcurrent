package com.haiyu.proxy.jdk;

/**
 * @Title: HelloImpl
 * @Description:
 * @author: youqing
 * @version: 1.0
 * @date: 2018/8/23 15:36
 */
public class HelloImpl implements Hello {
    @Override
    public void say(String name) {
        System.out.println("Hello" + name);
    }
}
