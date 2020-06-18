package com.java.thread;

import java.util.concurrent.*;

/**
 * @Description:
 * @Author: Sui, ChengBin
 * @Date: 2020/5/13
 **/
public class ExecutorCase {

//    private static Executor executor = Executors.newFixedThreadPool(3);
    private static Executor executor = new ThreadPoolExecutor(5, 7,
                                      1000L,TimeUnit.MILLISECONDS,
                                      new LinkedBlockingQueue<Runnable>());
    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            executor.execute(new MyTask());
        }
    }

    static class MyTask implements Runnable{

        @Override
        public void run() {
            System.out.println("current thread name is " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
