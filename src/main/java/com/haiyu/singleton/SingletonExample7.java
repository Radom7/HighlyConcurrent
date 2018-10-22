package com.haiyu.singleton;

import com.haiyu.annoations.Recommend;
import com.haiyu.annoations.ThreadSafe;

/**
 * @Title: SingletonExample7
 * @Description:
 * @author: youqing
 * @version: 1.0
 * @date: 2018/10/22 14:45
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {

    //私有构造方法
    private SingletonExample7(){

    }

    public static SingletonExample7 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{
        INSTANCE;

        private SingletonExample7 singleton;

        //JVM保证这个方法绝对只调用一次
        Singleton(){
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getInstance(){
            return singleton;
        }

    }

}
