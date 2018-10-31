package com.haiyu.guava;

import com.google.common.eventbus.Subscribe;

/**
 * @Title: OrderEventListener
 * @Description:
 * @author: youqing
 * @version: 1.0
 * @date: 2018/10/31 9:56
 */
public class HelloListener {

    @Subscribe
    public void listen(OrderEvent event) {
        System.out.println("HelloListener receive msg:"+event.getMessage());
    }
}
