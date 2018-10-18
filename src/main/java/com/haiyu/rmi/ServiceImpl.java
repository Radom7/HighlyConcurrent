package com.haiyu.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @Title: ServiceImpl
 * @Description: 服务实现
 * @author: youqing
 * @version: 1.0
 * @date: 2018/8/23 16:35
 */
public class ServiceImpl extends UnicastRemoteObject implements IService {


    private static final long serialVersionUID = 1L;

    protected ServiceImpl() throws RemoteException {
    }

    @Override
    public String queryName(String no) throws RemoteException {
        //方法的具体实现
        System.out.println("hello "+ no);
        return String.valueOf(System.currentTimeMillis());
    }
}
