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
public class SingletonExample6 {

    //私有构造方法
    private SingletonExample6(){

    }

    //单例对象
    private static SingletonExample6 instance = null;

    //静态代码块
    static {
        instance = new SingletonExample6();
    }

    //静态的工厂方法
    public static SingletonExample6 getInstance(){
        return instance;
    }


    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }

}
