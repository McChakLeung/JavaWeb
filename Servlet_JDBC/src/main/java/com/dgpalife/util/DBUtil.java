package com.dgpalife.util;

import java.sql.*;

public class DBUtil {

    private static Connection conn;
    private static PreparedStatement ps;
    private static ResultSet rs;

    //加载驱动类（静态语句块）
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获取conn
    public static Connection getConn(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Pa888888");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static PreparedStatement createPreparedStatement(String sql){
        conn = getConn();
        try {
            ps = conn.prepareStatement(sql);
        } catch (SQLException e) {
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

            close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
