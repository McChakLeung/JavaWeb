package com.dgpalife.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.Iterator;
import java.util.Map;

public class DBUtil {

    private static Connection conn;
    private static PreparedStatement ps;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection createConnection(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Pa888888");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static Connection createConnection(HttpServletRequest request){
        ServletContext application = request.getServletContext();
        Map map = (Map)application.getAttribute("mapkey");
        //从数据库连接池获得一个[空闲的Connection]，返回给用户使用
        Iterator iterator = map.keySet().iterator();
        //遍历连接池
        while (iterator.hasNext()){
            //使用迭代器遍历出下一个conn
            conn = (Connection) iterator.next();
            //通过conn对象，找到当前的conn的状态
            Boolean flag = (Boolean)map.get(conn);
            if(flag==true){
                //如果遍历出来的conn地址
                map.put(conn, false);
                return conn;
            }else{
                conn = null;
            }
        }
        return null;
    }

    public static PreparedStatement createPreparedStatement(String sql){
        try {
            conn = createConnection();
            ps = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    public static PreparedStatement createPreparedStatement(String sql, HttpServletRequest request){
        conn = createConnection(request);
        try{
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

    public static void close(ResultSet rs){
        try {
            if(rs!=null){
                rs.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        close();
    }

    public static void close(ResultSet rs, HttpServletRequest request){
        try{
            if(rs!=null){
                rs.close();
            }

            if(ps!=null){
                ps.close();
            }
            ServletContext application = request.getServletContext();
            Map map = (Map)application.getAttribute("mapKey");
            map.put(conn,true);
            System.out.println("Connection : "+conn+"被返回到数据库连接池");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
