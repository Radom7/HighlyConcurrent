package com.haiyu.commonUnsafe;

import com.haiyu.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Title: DateExample
 * @Description:
 * @author: youqing
 * @version: 1.0
 * @date: 2018/10/22 16:17
 */
@Slf4j
@ThreadSafe
public class DateFormatExample3 {

    private static int threadTotal = 200;
    private static int clientTotal = 5000;

    private static DateTimeFormatter dateTimeFormat = DateTimeFormat.forPattern("yyyyMMdd");

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        for (int index = 0; index < clientTotal ; index++){
            int count  = index;
            exec.execute(() -> {
                try{
                    semaphore.acquire();
                    update(count);
                    semaphore.release();
                }catch (Exception e){
                    log.error("exception",e);
                }
            });
        }
        exec.shutdown();
    }

    private static void update(int i){
        log.info("{},{}", i,DateTime.parse("20180228",dateTimeFormat).toDateTime());
    }

}
