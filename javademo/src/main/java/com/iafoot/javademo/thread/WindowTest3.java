package com.iafoot.javademo.thread;

/**
 * 使用同步方法解决实现Runnable接口的线程安全问题
 *
 * 关于同步方法的总结：
 * 1. 同步方法仍然涉及到同步监视器，只是不需要我们显式的声明。
 * 2. 非静态的同步方法，同步监视器是:this。
 *    静态的同步方法，同步监视器是：当前类本身。
 *
 *
 *
 *
 *
 *
 * @author ：iAfoot
 * @description：TODO
 * @date ：2021/4/10 16:16
 */

class WindowThread3 implements Runnable{
    private int ticket = 100;// 票
    Object obj = new Object();
    @Override
    public void run() {
        while (true){
            show();
        }
    }
    private synchronized void show(){
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + ":卖票，票号为： " + ticket);
            ticket--;
        }
    }

}

public class WindowTest3 {
    public static void main(String[] args) {
        WindowThread3 w3 = new WindowThread3();
        new Thread(w3).start();
        new Thread(w3).start();
        new Thread(w3).start();
    }
}

