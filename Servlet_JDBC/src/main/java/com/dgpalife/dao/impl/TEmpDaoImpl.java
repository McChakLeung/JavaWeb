package com.dgpalife.dao.impl;

import com.dgpalife.dao.TEmpDao;
import com.dgpalife.util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TEmpDaoImpl implements TEmpDao {

    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public int checkAccount(String username, String password){
        String sql = "select count(*) from emp where ename = ? and empno = ?";
        int flag = 0;
        try{
            ps = DBUtil.createPreparedStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            rs = ps.executeQuery();
            rs.next();
            flag = rs.getInt("count(*)");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs);
        }
        return flag;
    }
}
