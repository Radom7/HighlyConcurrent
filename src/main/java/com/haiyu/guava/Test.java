package com.haiyu.guava;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.concurrent.Executors;

/**
 * @Title: Test
 * @Description:
 * @author: youqing
 * @version: 1.0
 * @date: 2018/10/31 9:57
 */
public class Test {

    public static void main(String[] args) {
        /*
        * 通过EventBus.register(Object object)方法来注册订阅者（subscriber），
        * 使用EventBus.post(Object event)方法来发布事件。
        * */

        //1.Creates a new EventBus with the given identifier.
        //EventBus线程安全，本地线程，单线程，同步的
        EventBus eventBus = new EventBus("jackson");
        //AsyncEventBus线程异步
        //AsyncEventBus eventBus = new AsyncEventBus(Executors.newFixedThreadPool(3));

        //2.register all subscriber
        eventBus.register(new OrderEventListener());
        //eventBus.register(new HelloListener());

        //publish event
//        eventBus.post(new OrderEvent("hello"));
//        eventBus.post(new OrderEvent("world"));

        eventBus.post("haha");
    }
}
