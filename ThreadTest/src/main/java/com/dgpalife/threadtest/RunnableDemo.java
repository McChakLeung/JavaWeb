package com.dgpalife.threadtest;

public class RunnableDemo implements Runnable {
    private String username;
    private Thread t;

    //构造方法
    RunnableDemo( String name) {
        username = name;
        System.out.println("Creating " +  username );
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void run() {
        System.out.println("Running " +  username );
    }

    public void start () {
        System.out.println("Starting " +  username );
        if (t == null) {
            t = new Thread (this, username);
            t.start ();
        }
    }
}
