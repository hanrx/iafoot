package com.iafoot.javademo.demo;

/**
 * 需求：线程隔离
 *      在多线程并发的场景下，每个线程中的变量都是相互独立
 *      线程A：    设置（变量1）     获取（变量1）
 *      线程B：    设置（变量2）     获取（变量2）

 * @author ：iAfoot
 * @description：TODO
 * @date ：2021/4/1 21:13
 */
public class SynchronizedTest {

    //变量
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static void main(String[] args) {
        SynchronizedTest threadLocalTest = new SynchronizedTest();

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    //每个线程：存一个变量，过一会取出一个变量
                    synchronized (SynchronizedTest.class){
                        threadLocalTest.setContent(Thread.currentThread().getName()+"的数据");
                        System.out.println("---------------------------");
                        System.out.println(Thread.currentThread().getName()+"---->"
                                + threadLocalTest.getContent());
                    }

                }
            });
            thread.setName("线程名字是"+i);
            thread.start();
        }
    }




















}
