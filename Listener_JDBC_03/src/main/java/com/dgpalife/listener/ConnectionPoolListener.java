package com.dgpalife.listener;

import com.dgpalife.util.DBUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ConnectionPoolListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext application = sce.getServletContext();
        Map map = new HashMap<>();
        //创建一定数量的Connection
        for(int i=0; i<5;i++){
            Connection conn = DBUtil.createConnection();
            map.put(conn,true);
            System.out.println("connection has created now: " + conn);
        }
        application.setAttribute("mapKey",map);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext application = sce.getServletContext();
        Map map = (Map)application.getAttribute("mapKey");
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            Connection conn = (Connection) iterator.next();
            try{
                if(conn!=null){
                    System.out.println("Connection is closing:"+conn+"");
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
