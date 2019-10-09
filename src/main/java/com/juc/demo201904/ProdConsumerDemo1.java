package com.juc.demo201904;


class Aircondition {
    private int number = 0;

    public synchronized void increment() throws Exception {
        //1 判断
        while (number != 0) {
            this.wait();
        }
        //计算
        number++;
        System.out.println(Thread.currentThread().getName() + "\t" + number);

        //通知
        this.notifyAll();
    }

    public synchronized void decrement() throws Exception {
        while (number == 0) {
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        this.notifyAll();
    }
}

/**
 * Creacted by jack on 2019/10/30 10:58
 * 题目： 两个线程 操作初始值为零的一个变量，实现一个线程对该变量+1，一个线程对该变量-1
 * 交替，来10轮
 **/
public class ProdConsumerDemo1 {
    public static void main(String[] args) {
        Aircondition aircondition = new Aircondition();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    aircondition.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    aircondition.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    aircondition.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    aircondition.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }
}