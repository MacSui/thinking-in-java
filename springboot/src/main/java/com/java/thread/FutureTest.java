package com.java.thread;

import java.util.concurrent.*;

/**
 * @Description:
 * @Author: Sui, ChengBin
 * @Date: 2020/5/13
 **/
public class FutureTest {

    private static ExecutorService executor = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Future<String> future = executor.submit(new MyTask());
            System.out.println("main method do other things!");
            try {
                String s = future.get();
                System.out.println("result from future: "+s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }


    static class MyTask implements Callable<String>{
        @Override
        public String call() throws Exception {
            TimeUnit.SECONDS.sleep(2);
            return "this is future task, " + Thread.currentThread().getName();
        }
    }


}
