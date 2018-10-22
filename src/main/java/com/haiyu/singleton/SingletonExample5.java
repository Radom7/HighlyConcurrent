package com.haiyu.singleton;


import com.haiyu.annoations.ThreadSafe;
import com.haiyu.annoations.UnThreadSafe;

/**
 * @Title: SingletonExample
 * @Description: 懒汉式 【双重同步锁单例模式】（单例实例在第一次使用时进行创建）性能开销大  volatile
 * @author: youqing
 * @verion: 1.0
 * @date: 2018/10/22 14:18
 */
@ThreadSafe
public class SingletonExample5 {

    //私有构造方法
    private SingletonExample5(){

    }

    //单例对象 volatile + 双重检测机制 -> 禁止指令重排
    private volatile static SingletonExample5 instance = null;

    //静态的工厂方法
    public static SingletonExample5 getInstance(){
        if(instance == null ){ // 双重检测机制
           synchronized (SingletonExample5.class){//同步锁
                if(instance == null){
                    instance = new SingletonExample5();
                }
            }

        }
        return instance;
    }

}
