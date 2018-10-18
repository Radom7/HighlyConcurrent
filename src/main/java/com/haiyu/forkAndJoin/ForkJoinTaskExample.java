package com.haiyu.forkAndJoin;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @Title: ForkJoinTaskExample
 * @Description:
 * @author: youqing
 * @version: 1.0
 * @date: 2018/10/18 14:46
 */
@Slf4j
public class ForkJoinTaskExample extends RecursiveTask<Integer> {

    public static final int threadhold = 2;
    private int start;
    private int end;

    public ForkJoinTaskExample(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;

        //如果任务足够小就计算任务
        boolean canCompute = (end - start) <= threadhold;
        if(canCompute){
            for (int i = start; i <= end ;i++){
                sum += i;
            }
        }else {
            //如果任务大于阈值，就分裂成两个子任务计算
            int middle = (start + end)/2;
            ForkJoinTaskExample leftTask = new ForkJoinTaskExample(start,middle);
            ForkJoinTaskExample rightTask = new ForkJoinTaskExample(middle+1,end);

            //执行子任务
            leftTask.fork();
            rightTask.fork();

            //等到子任务执行结束后合并其结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            //合并子任务
            sum = leftResult+rightResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        ForkJoinTaskExample task = new ForkJoinTaskExample(1,100);

        Future<Integer> result = forkJoinPool.submit(task);
        try {
            log.info("result:{}",result.get());
        }catch (Exception e){
            log.error("exception",e);
        }

    }

}
