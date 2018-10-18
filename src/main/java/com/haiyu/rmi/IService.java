package com.haiyu.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @Title: IService
 * @Description:
 * @author: youqing
 * @version: 1.0
 * @date: 2018/8/23 16:34
 */
public interface IService extends Remote{
    public String queryName(String no) throws RemoteException;
}
