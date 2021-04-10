package com.iafoot.javademo.thread;

/**
 * 列：创建三个窗口卖票，总票数100张
 *
 *
 * @author ：iAfoot
 * @description：TODO
 * @date ：2021/4/10 14:32
 */

class Windows extends Thread{
    private static int ticket = 100;// 票 不用static 可用实现接口方式
    @Override
    public void run() {
        while (true){
            if (ticket >0 ) {
                System.out.println(getName()+":卖票，票号为： "+ticket);
                ticket --;
            }else {
                break;//跳出本次循环
            }
        }
    }
}
public class WindowTest {
    public static void main(String[] args) {
        Windows w1 = new Windows();
        Windows w2 = new Windows();
        Windows w3 = new Windows();
        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");
        w1.start();
        w2.start();
        w3.start();
    }
}































