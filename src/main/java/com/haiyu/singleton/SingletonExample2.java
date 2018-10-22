package com.haiyu.singleton;

import com.haiyu.annoations.ThreadSafe;
/**
 * @Title: SingletonExample
 * @Description: 饿汉式 （单例实例在类装载时进行创建）
 * @author: youqing
 * @verion: 1.0
 * @date: 2018/10/22 14:18
 */
@ThreadSafe
public class SingletonExample2 {

    //私有构造方法
    private SingletonExample2(){

    }

    //单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    //静态的工厂方法
    public static SingletonExample2 getInstance(){
        return instance;
    }

}
