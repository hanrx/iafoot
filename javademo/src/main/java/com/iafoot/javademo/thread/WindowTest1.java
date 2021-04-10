package com.iafoot.javademo.thread;

/**
 * 列：创建三个窗口卖票，总票数为100张，使用实现Runnable接口的方式
 * 存在线程安全问题，待解决
 * 1.问题：买票过程中，出现了重票、错票-->出现了线程的安全问题。
 * 2.问题出现的原因：当某个线程操作车票的过程中，尚未操作完成时，其他线程参与进来，也操作车票。
 * 3.如何解决：当一个线程在操作ticket的时候，其他线程不能参与进来。直到线程a操作完ticket时，其他线程才可以开始操作ticket。这种情况及时线程a
 *   出现阻塞，也不能被改变。
 * 4.在Java中，我们通过同步机制，来解决线程的安全问题。
 *  方式一：同步代码块
 *  synchronized（同步监视器）{
 *      //需要被同步的代码
 *  }
 *  说明：1. 操作共享数据的代码，即为需要被同步的代码
 *       2. 共享数据：多个线程共同操作的变量。比如ticket
 *       3. 同步监视器，俗称：锁。任何一个类的对象，都可以充当锁。
 *          要求：多个线程共用同一把锁
 *
 *  方式二：同步方法
 *  如果操作共享数据的代码完整的声明在一个方法中，我们不妨将此方法声明同步的。
 *
 *
 * 5. 同步的方式，解决了线程的安全问题。--好处
 *    操作同步代码时，只能有一个线程参与，其他线程等待。相当于是一个单线程的过程，效率低。--局限性。
 *
 * @author ：iAfoot
 * @description：TODO
 * @date ：2021/4/10 15:03
 */

class WindowThread1 implements Runnable{
    private int ticket = 100;// 票
    Object obj = new Object();
    @Override
    public void run() {
        while (true){
            synchronized (obj) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为： " + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {
        WindowThread1 w1 = new WindowThread1();
        new Thread(w1).start();
        new Thread(w1).start();
        new Thread(w1).start();
    }
}























