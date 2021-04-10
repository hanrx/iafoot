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
 *  说明：操作共享数据的代码，即为需要被同步的代码
 *       共享数据：多个线程共同操作的变量。比如ticket
 *
 *  方式二：同步方法
 *
 *
 *
 * @author ：iAfoot
 * @description：TODO
 * @date ：2021/4/10 15:03
 */

class WindowThread1 implements Runnable{
    private int ticket = 100;// 票
    @Override
    public void run() {
        while (true){
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName()+":卖票，票号为： "+ticket);
                ticket --;
            }else {
                break;
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























