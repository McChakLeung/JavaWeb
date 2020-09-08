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
        for(int i=0;i<5;i++){
            Connection conn = DBUtil.createConnection();
            map.put(conn,true);
            System.out.println("在项目启动时,预先创建Connection ：" + conn);
        }
        application.setAttribute("mapKey",map);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext application = sce.getServletContext();
        Map map = (Map)application.getAttribute("mapKey");
        //遍历map中所有元素
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            Connection conn = (Connection)iterator.next();
            try {
                if (conn != null) {
                    System.out.println("Connection:"+conn+",老子二十年后还是一条好汉");
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
