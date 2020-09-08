package com.dgpalife.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtil {

    private static Connection conn;

    private static PreparedStatement ps;

    static {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Connection getConn(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "Pa888888");
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    public static PreparedStatement getPreparedStatement(String sql){
        try{
            conn = getConn();
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
        try{
            if(rs!=null){
                rs.close();
            }
            close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
