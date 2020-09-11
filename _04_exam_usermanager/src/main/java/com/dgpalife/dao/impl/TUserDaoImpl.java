package com.dgpalife.dao.impl;

import com.dgpalife.dao.TUserDao;
import com.dgpalife.model.User;
import com.dgpalife.util.DBUtil;

import java.sql.PreparedStatement;

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
}
