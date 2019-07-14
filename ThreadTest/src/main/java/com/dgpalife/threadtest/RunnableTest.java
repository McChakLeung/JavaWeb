package com.dgpalife.threadtest;

public class RunnableTest {
    public static void main(String[] args) {
        RunnableDemo R1 = new RunnableDemo( "Thread-1");


        RunnableDemo R2 = R1;
        //RunnableDemo R2 = new RunnableDemo( "Thread-2");
        R1.start();
        R2.setUsername("Thread-2");
        R2.start();
    }
}
