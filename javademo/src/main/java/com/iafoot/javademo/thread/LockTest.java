package com.iafoot.javademo.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式三：Locke --JDK 5.0新增方法
 *
 * 1. synchronized与Lock的异同
 *    相同：二者都可以解决线程安全问题
 *    不同：synchronized机制在执行完相应的同步代码以后，自动的释放同步监视器
 *         Lock需要手动的启动同步（Lock()），同时结束同步也需要手动的实现（unLock()）
 *
 *
 *
 * @author ：iAfoot
 * @description：TODO
 * @date ：2021/4/10 17:00
 */
class Window implements  Runnable{
    private int ticket = 100;// 票

    //1. 实例化ReentrantLock 锁
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true){
            try {
                // 2.调用lock()
                lock.lock();

                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为： " + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                //3.调用解锁方法 unlock()
                lock.unlock();
            }
        }
    }
}
public class LockTest {
    public static void main(String[] args) {
        Window w1 = new Window();
        new Thread(w1).start();
        new Thread(w1).start();
        new Thread(w1).start();
    }
}























