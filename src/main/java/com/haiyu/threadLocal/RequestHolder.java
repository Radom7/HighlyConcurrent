package com.haiyu.threadLocal;

/**
 * @Title: RequestHolder
 * @Description:
 * @author: youqing
 * @version: 1.0
 * @date: 2018/10/22 15:32
 */
public class RequestHolder {
    private final static ThreadLocal<Long> requestHolder = new ThreadLocal <>();

    public static void add(Long id){
        requestHolder.set(id);
    }

    public static Long getId(){
        return requestHolder.get();
    }

    public static void remove(){
        requestHolder.remove();
    }
}
