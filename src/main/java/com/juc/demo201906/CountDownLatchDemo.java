package com.juc.demo201906;

import java.util.concurrent.CountDownLatch;

/**
 * Creacted by jack on 2019/10/30 14:37
 * 倒计时 从6 减
 *
 **/
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch= new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t离开教室");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t班长离开");
    }

}