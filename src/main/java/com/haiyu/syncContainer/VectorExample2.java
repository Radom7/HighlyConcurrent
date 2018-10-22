package com.haiyu.syncContainer;

import com.haiyu.annoations.UnThreadSafe;

import java.util.Vector;

/**
 * @Title: VectorExample2
 * @Description:
 * @author: youqing
 * @version: 1.0
 * @date: 2018/10/22 17:01
 */
@UnThreadSafe
public class VectorExample2 {
    private static Vector<Integer> vector = new Vector <>();

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }
            Thread thread1 = new Thread() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        vector.remove(i);
                    }
                }
            };

            Thread thread2 = new Thread() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        vector.get(i);
                    }
                }
            };

            thread1.start();
            thread2.start();
        }
    }
}
