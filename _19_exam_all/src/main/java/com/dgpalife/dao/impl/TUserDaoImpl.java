package com.dgpalife.dao.impl;

import com.dgpalife.dao.TUserDao;
import com.dgpalife.model.User;
import com.dgpalife.util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TUserDaoImpl implements TUserDao {
    @Override
    public Integer getTotalRecord() {
        String sql = "select count(*) from user";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer totalRecord = 0;
        try{
            ps = DBUtil.getPreparedStatement(sql);
            rs = ps.executeQuery();
            rs.next();
            totalRecord = rs.getInt(1);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs);
        }
        return totalRecord;
    }

    @Override
    public List<User> findUserListWithPage(Integer startLine, Integer pageSize) {
        String sql = "select id,username,email,telephone,registDate from user limit ?,?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> userList = new ArrayList<>();
        try{
            ps = DBUtil.getPreparedStatement(sql);
            ps.setInt(1,startLine);
            ps.setInt(2,pageSize);
            rs = ps.executeQuery();
            while (rs.next()){
                Integer id = rs.getInt(1);
                String username = rs.getString(2);
                String email = rs.getString(3);
                String telephone = rs.getString(4);
                String registDate = rs.getString(5);
                User user = new User(id,username,null,email,telephone,registDate);
                userList.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs);
        }
        return userList;
    }

    @Override
    public Integer deleteUser(String[] params) {
        String sql = "delete from user where id = ?";
        PreparedStatement ps = null;
        Integer result = 1;
        try{
            ps = DBUtil.getPreparedStatement(sql);
            for(String id:params){
                ps.setInt(1,Integer.valueOf(id));
                ps.addBatch();
            }
            ps.executeBatch();
        }catch (Exception e){
            e.printStackTrace();
            result = 0;
        }finally {
            DBUtil.close();
        }
        return result;
    }

    @Override
    public void addUser(User user) {
        String sql = "insert into user (username,pwd,email,telephone,registDate) value (?,?,?,?,now())";
        PreparedStatement ps = null;
        try{
            ps = DBUtil.getPreparedStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getEmail());
            ps.setString(4,user.getTelephone());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
    }

    @Override
    public User findUserByID(Integer id) {
        String sql = "select id,username,pwd,email,telephone,registDate from user where id = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try{
            ps = DBUtil.getPreparedStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            rs.next();
            String username = rs.getString(2);
            String password = rs.getString(3);
            String email = rs.getString(4);
            String telephone = rs.getString(5);
            String registDate = rs.getString(6);
            user = new User(id,username,password,email,telephone,registDate);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs);
        }
        return user;
    }

    @Override
    public void updateUser(User user) {
        String sql = "update user set " +
                "username = ?, pwd = ?, email = ?, telephone = ? " +
                "where id = ?";
        PreparedStatement ps = null;
        try{
            ps = DBUtil.getPreparedStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getEmail());
            ps.setString(4,user.getTelephone());
            ps.setInt(5,user.getId());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
    }
}
