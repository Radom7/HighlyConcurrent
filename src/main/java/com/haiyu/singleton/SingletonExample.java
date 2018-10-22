package com.haiyu.singleton;

import com.haiyu.annoations.UnThreadSafe;

/**
 * @Title: SingletonExample
 * @Description: 懒汉式 （单例实例在第一次使用时进行创建）
 * @author: youqing
 * @verion: 1.0
 * @date: 2018/10/22 14:18
 */
@UnThreadSafe
public class SingletonExample {

    //私有构造方法
    private SingletonExample(){

    }

    //单例对象
    private static SingletonExample instance = null;

    //静态的工厂方法
    public static SingletonExample getInstance(){
        if(instance == null ){
            instance = new SingletonExample();
        }
        return instance;
    }

}
