package com.java.thread;

/**
 * @Description:
 * @Author: Sui, ChengBin
 * @Date: 2020/5/13
 **/
public class WaitNotifyDemo {

    private int num; //输出数字
    private int runThreadNum; //当前运行线程编号

    public WaitNotifyDemo(int num, int runThreadNum){
        this.num = num;
        this.runThreadNum = runThreadNum;
    }

    public static void main(String[] args) {
        WaitNotifyDemo demo = new WaitNotifyDemo(1, 1);
        new PrintThread(1, demo).start();
        new PrintThread(2, demo).start();
        new PrintThread(3, demo).start();

    }

    static class PrintThread extends Thread{
        private int threadNum;
        private WaitNotifyDemo waitNotifyDemo;
        public PrintThread(int threadNum, WaitNotifyDemo waitNotifyDemo){
            this.threadNum = threadNum;
            this.waitNotifyDemo = waitNotifyDemo;
        }

        @Override
        public void run() {
            synchronized (waitNotifyDemo){
                try {
                    for (int i = 0; i < 5; i++) {
                        while (true){
                            if (threadNum == waitNotifyDemo.runThreadNum)
                                break;
                            else
                                waitNotifyDemo.wait();
                        }
                        for (int j=0; j<5; j++){
                            System.out.println("Thread "+threadNum +":"+ (waitNotifyDemo.num++));
                        }
                        waitNotifyDemo.runThreadNum = waitNotifyDemo.runThreadNum%3 + 1;
                        waitNotifyDemo.notifyAll();

                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }
    }


}
