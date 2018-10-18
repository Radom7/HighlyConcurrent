package com.haiyu.BlockingQueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Title: Consumer
 * @Description:
 * @author: youqing
 * @version: 1.0
 * @date: 2018/10/18 15:56
 */
public class Consumer implements Runnable{
    private BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void run() {
        System.out.println("启动消费者线程！");

        boolean isRunning = true;
        try {
            while (isRunning) {
                System.out.println("正从队列获取数据...");
                String data = queue.poll(2, TimeUnit.SECONDS);
                if (null != data) {
                    System.out.println("拿到数据：" + data);
                    System.out.println("正在消费数据：" + data);
                    Thread.sleep(1000);
                } else {
                    // 超过2s还没数据，认为所有生产线程都已经退出，自动退出消费线程。
                    isRunning = false;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } finally {
            System.out.println("退出消费者线程！");
        }
    }
}
