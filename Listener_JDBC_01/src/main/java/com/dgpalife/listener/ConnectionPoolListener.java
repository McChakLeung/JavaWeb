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

    /**
     * webapp启动时，自动创建Connection
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //1.获取ServletContext对象
        ServletContext application = sce.getServletContext();
        //2.创建Map集合，用于存放Connection
        Map map = new HashMap<>();
        //3.通过DBUtil创建多个Connection,并存放在Map中
        for(int i=0; i<5;i++){
            try{
                Connection conn = DBUtil.createConnection();
                map.put(conn,true); //使用引用对象作为map中的key，true:表示con处于空闲状态；false:表示conn正在被其他用户使用。
                System.out.println("在项目启动时,预先创建Connection ：" + conn);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        //4.将map存放在ServletContext对象
        application.setAttribute("mapkey",map);
    }

    /**
     * webapp关闭时，销毁相关Connection
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //1.获取ServletContext对象
        ServletContext application = sce.getServletContext();
        //2.获取对应的map集合
        Map map = (Map)application.getAttribute("mapKey");
        //3.遍历map集合中的Connetion对象，并关闭Connection
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            Connection conn = (Connection) iterator.next();
            if(conn!=null){
                try{
                    System.out.println("Connection:"+conn+",老子二十年后还是一条好汉");
                    conn.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
