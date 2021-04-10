package com.iafoot.javademo.thread;

/**
 * 多线程的创建，方式一：继承Thread类
 * 1.创建一个继承于Thread类的子类
 * 2.重写Thread类的run()
 * 3.创建Thread类的子类的对象
 * 4.通过此对象调用start()
 *
 * 例：遍历100以内所有的偶数
 * @author ：iAfoot
 * @description：TODO
 * @date ：2021/4/9 08:38
 */
//1.创建一个继承于Thread类的子类
class MyThread extends Thread{
    @Override
   //2.重写Thread类的run()
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2 == 0) {
                System.out.println(i);
            }
        }
    }

}

public  class ThreadTest{
    //3.创建Thread类的子类的对象
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        // 4.通过此对象调用start()
        t1.start();
        for (int i = 0; i < 100; i++) {
            if (i%2 == 0) {
                System.out.println("*************main():"+i);
            }
        }



    }
}