package com.dgpalife.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.Map;

public class DBUtil {

    private static Connection conn;

    private static PreparedStatement ps;

    /**
     * 静态语句块，为了获取jdbc驱动
     */
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 普通方法获取conn
     * @return
     */
    public static Connection getConn(){
        try {
            conn =  DriverManager.getConnection("jdbc:mysql://localhost/test","root","Pa888888");
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 使用数据库连接池获取conn
     * @param request
     * @return
     */
    public static Connection getConn(HttpServletRequest request){
        ServletContext application = request.getServletContext();
        Map map = (Map)application.getAttribute("mapKey");
        Iterator iterator = map.keySet().iterator();
        try{
            while(iterator.hasNext()){
                conn = (Connection)iterator.next(); //从迭代器中取出的对象引用地址赋值给静态变量conn
                Boolean flag = (Boolean)map.get(conn);
                if(flag == true){
                    map.put(conn,false); //将数据库连接池中的conn设置为false，说明该conn状态非空闲
                    return conn;
                }else{
                    conn = null; //如果当前在数据库连接池所取得的conn状态为false，说明该conn正在使用，将该静态变量切联系
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return conn;
    }

    /**
     * 普通方法获取数据库操作对象ps
     * @param sql
     * @return
     */
    public static PreparedStatement getPreparedStateement(String sql){
        try{
            conn = getConn();
            ps = conn.prepareStatement(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ps;
    }


    /**
     * 调用数据库连接池中的conn，获取ps对象
     * @param sql
     * @param request
     * @return
     */
    public static PreparedStatement getPrepardStatement(String sql, HttpServletRequest request){
        try{
            conn = getConn(request);
            ps = conn.prepareStatement(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ps;
    }

    /**
     * 普通关闭方法
     * @param rs
     */
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
        }catch (Exception e){
            e.printStackTrace();
        }
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
            System.out.println("该conn对象已设置为空闲状态：" + conn);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
