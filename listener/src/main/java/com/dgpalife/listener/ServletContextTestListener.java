package com.dgpalife.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextTestListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.printf("servletcontext object created by tomcat");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.printf("servletcontext object destroyed by tomcat");
    }
}
