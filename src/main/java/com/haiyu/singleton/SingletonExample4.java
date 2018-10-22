package com.haiyu.singleton;


import com.haiyu.annoations.UnThreadSafe;

/**
 * @Title: SingletonExample
 * @Description: 懒汉式 【双重同步锁单例模式】（单例实例在第一次使用时进行创建）性能开销大
 * @author: youqing
 * @verion: 1.0
 * @date: 2018/10/22 14:18
 */
@UnThreadSafe
public class SingletonExample4 {

    //私有构造方法
    private SingletonExample4(){

    }

    //单例对象
    private static SingletonExample4 instance = null;

    //静态的工厂方法
    public static SingletonExample4 getInstance(){
        if(instance == null ){ // 双重检测机制
           synchronized (SingletonExample4.class){//同步锁
                if(instance == null){
                    instance = new SingletonExample4();
                }
            }

        }
        return instance;
    }

}
