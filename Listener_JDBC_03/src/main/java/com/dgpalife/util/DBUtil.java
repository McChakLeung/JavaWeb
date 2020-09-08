package com.dgpalife.util;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //普通的获取conn方法
    public static Connection createConnection(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "Pa888888");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }

    //从数据库连接池中获取conn
    public static Connection createConnection(HttpServletRequest request){
        ServletContext application = request.getServletContext();
        Map map = (Map)application.getAttribute("mapKey");
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            conn = (Connection)iterator.next();
            Boolean flag = (Boolean) map.get(conn);
            if(flag){
                map.put(conn,false);
                return conn;
            }else{
                conn = null; //将对象con与关联的Connection切断联系。
            }
        }
        return conn;
    }

    //普通的获取ps方法
    public static PreparedStatement createPreparedStatement(String sql){
        try{
            conn = createConnection();
            ps = conn.prepareStatement(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return ps;
    }

    //从数据库连接池中获取ps
    public static PreparedStatement createPreparedStatement(String sql, HttpServletRequest request){
        try {
            conn = createConnection(request);
            ps = conn.prepareStatement(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return ps;
    }


    public static void close(ResultSet rs){
        try{
            if(rs!=null){
                rs.close();
            }
            if(ps!=null){
                ps.close();
            }
            if(conn!=null){
                conn.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void close(HttpServletRequest request, ResultSet rs){

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
