package com.dgpalife.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class ServletContextAttributeTestListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {

        ServletContext application = event.getServletContext();
        String name = event.getName();
        Object value = event.getValue();
        Object source = event.getSource();
        System.out.println(application + "name = " + name + ";value ="+ value + ";source=" + source);

    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {

    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {

    }
}
