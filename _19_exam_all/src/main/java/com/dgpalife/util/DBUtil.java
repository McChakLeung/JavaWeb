package com.dgpalife.util;

import java.sql.*;

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

    /**
     * 获取connection
     * @return
     */
    public static Connection getConn(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Pa888888");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 获取数据库操纵对象
     * @param sql
     * @return
     */
    public static PreparedStatement getPreparedStatement(String sql){
        conn = getConn();
        try {
            ps = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    /**
     * 关闭数据库操作对象和数据库连接对象（无ResultSet)
     */
    public static void close(){
        try {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 关闭数据库操作对象和数据库连接对象（有ResultSet)
     */
    public static void close(ResultSet rs){
        try{
            if(rs!=null){
                rs.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        close();
    }
}
