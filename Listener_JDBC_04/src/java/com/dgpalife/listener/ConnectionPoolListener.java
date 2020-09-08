package com.dgpalife.listener;

import com.dgpalife.util.DBUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ConnectionPoolListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //从sce对象中获取servletcontext对象
        ServletContext application = sce.getServletContext();
        Map map = new HashMap<>();
        //监听器在系统启动的时候自动创建若干个conncection,并存放在map中（数据库连接池）
        for(int i = 0; i < 5; i++){
            Connection conn = DBUtil.getConn();
            //用conn引用地址作为key，value使用true和false，分别表示状态是否空闲，true为空闲，false为在用
            map.put(conn,true);
        }
        //将数据库连接池放进sc对象中，作为webapp的共享数据
        application.setAttribute("mapKey",map);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext application = sce.getServletContext();
        Map map = (Map)application.getAttribute("mapKey");
        Iterator iterator = map.keySet().iterator();
        try{
            while (iterator.hasNext()){
                Connection conn = (Connection)iterator.next();
                if(conn!=null){
                    conn.close();
                    System.out.println(conn + "：老子二十年后又是一条好汉！");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
