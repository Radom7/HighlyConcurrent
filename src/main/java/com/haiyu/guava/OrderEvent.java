package com.haiyu.guava;

/**
 * @Title: OrderEvent
 * @Description:
 * @author: youqing
 * @version: 1.0
 * @date: 2018/10/31 9:54
 */
public class OrderEvent {
    private String message;
    public OrderEvent(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
