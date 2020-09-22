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
    public void addUser(User user) {
        String sql = "insert into user (username,pwd,email,telephone,registDate) value (?,?,?,?,now())";
        PreparedStatement ps = null;
        try{
            ps = DBUtil.getPrepardStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPwd());
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
    public List<User> findUser() {
        String sql = "select id,username,email,telephone,registDate from user";
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> userList = new ArrayList<>();
        try{
            ps = DBUtil.getPrepardStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
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
    public void deleteUser(String[] params) {
        String sql = "delete from user where id = ?";
        PreparedStatement ps = null;
        try{
            ps = DBUtil.getPrepardStatement(sql);
            for(int i=0; i<params.length;i++){
                ps.setInt(1,Integer.valueOf(params[i]));
                ps.addBatch();
            }
            ps.executeBatch();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }

    }

    @Override
    public User findUserById(String id) {
        String sql = "select id, username, email, telephone, registDate from user where id = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try{
            ps = DBUtil.getPrepardStatement(sql);
            ps.setInt(1,Integer.valueOf(id));
            rs = ps.executeQuery();
            rs.next();
            Integer userId = rs.getInt(1);
            String username = rs.getString(2);
            String email = rs.getString(3);
            String telephone = rs.getString(4);
            String registDate = rs.getString(5);
            user = new User(userId,username,null,email,telephone,registDate);
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
                "username = ?, pwd = ?, email =?, telephone = ? " +
                "where id = ?";
        PreparedStatement ps = null;
        try{
            ps = DBUtil.getPrepardStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPwd());
            ps.setString(3,user.getEmail());
            ps.setString(4,user.getTelephone());
            ps.setInt(5,user.getId());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }

    }
}
