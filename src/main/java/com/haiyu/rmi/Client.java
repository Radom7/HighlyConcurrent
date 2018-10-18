package com.haiyu.rmi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @Title: Client
 * @Description: RMI客户端
 * @author: youqing
 * @version: 1.0
 * @date: 2018/8/23 16:39
 */
public class Client {
    public static void main(String[] args) {
        //注册管理器
        Registry registry = null;
        try {
            //获取服务注册管理器
            registry = LocateRegistry.getRegistry("localhost",8088);
            //列出所有注册的服务
            String[] list = registry.list();
            for (String s : list){
                System.out.println(s);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            //根据命名获取服务
            IService service = (IService) registry.lookup("vince");
            //调用远程方法
            String result = service.queryName("jack");
            //输出调用结果
            System.out.println("result from remote : "+result);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

    }
}
