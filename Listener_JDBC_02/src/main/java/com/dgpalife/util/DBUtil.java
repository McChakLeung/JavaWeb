package com.dgpalife.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.HTMLDocument;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.Map;

public class DBUtil {

    private static Connection conn;

    private static PreparedStatement ps;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 定义普通方法获取数据库连接对象的方法
     * @return
     */
    public static Connection createConnection(){
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Pa888888");
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 使用数据库连接池获取数据库连接对象
     * @param request
     * @return
     */
    public static Connection createConnection(HttpServletRequest request){
        ServletContext application = request.getServletContext();
        Map map = (Map)application.getAttribute("mapKey");
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            conn = (Connection)iterator.next();
            if((Boolean)map.get(conn) == true){
                map.put(conn,false);
                return conn;
            }else{
                conn = null;
            }
        }
        return null;
    }

    /**
     * 定义普通方法获取数据库操作对象的方法
     * @param sql
     * @return
     */
    public static PreparedStatement createPreparedStatement(String sql){
        try {
            conn = createConnection();
            ps = createConnection().prepareStatement(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ps;
    }

    /**
     * 使用数据库连接池获取数据库操作对象
     * @param sql
     * @param request
     * @return
     */
    public static PreparedStatement createPreparedStatement(String sql,HttpServletRequest request){
        try{
            conn = createConnection(request);
            ps = conn.prepareStatement(sql);
        }catch (Exception e){
            e.printStackTrace();
        }

        return ps;
    }

    public static void close(){
        try{
            if(ps!=null){
                ps.close();
            }

            if(conn!=null){
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rs, HttpServletRequest request){
        ServletContext application = request.getServletContext();
        Map map = (Map)application.getAttribute("mapKey");
        try{
            if(rs!=null){
                rs.close();
            }
            map.put(conn,true);
            System.out.println("conn已设置为空闲状态：" +conn );

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
