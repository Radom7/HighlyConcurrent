package com.haiyu.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @Title: Server
 * @Description: RMI服务端
 * @author: youqing
 * @version: 1.0
 * @date: 2018/8/23 16:43
 */
public class Server {

    public static void main(String[] args) {
        //注册管理器
        Registry registry = null;
        try {
            //创建一个服务注册管理器
            registry = LocateRegistry.createRegistry(8088);
            System.out.println("registry");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            //创建一个服务
            ServiceImpl service = new ServiceImpl();

            //将服务绑定命名
            registry.rebind("vince",service);
            System.out.println("bind server");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
