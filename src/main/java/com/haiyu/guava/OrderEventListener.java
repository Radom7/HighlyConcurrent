package com.haiyu.guava;

import com.google.common.eventbus.Subscribe;

/**
 * @Title: OrderEventListener
 * @Description:
 * @author: youqing
 * @version: 1.0
 * @date: 2018/10/31 9:56
 */
public class OrderEventListener {

    @Subscribe
    public void listen(OrderEvent event) {
        System.out.println("OrderEventListener receive msg:"+event.getMessage());
    }

    @Subscribe
    public void listen(String event) {
        System.out.println("OrderEventListener receive msg:"+event);
    }
}
