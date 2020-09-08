package com.dgpalife.dao.impl;

import com.dgpalife.dao.TQuestionDao;
import com.dgpalife.model.Question;
import com.dgpalife.util.DBUtil;
import com.sun.applet2.preloader.event.PreloaderEvent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TQuestionDaoImpl implements TQuestionDao {

    //private String sql;

    @Override
    public void addQuestion(Question question) {
        String sql = "insert into question (title,optionA,optionB,optionC,optionD,answer) value (?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try{
            ps = DBUtil.getPreparedStatement(sql);
            ps.setString(1,question.getTitle());
            ps.setString(2,question.getOptionA());
            ps.setString(3,question.getOptionB());
            ps.setString(4,question.getOptionC());
            ps.setString(5,question.getOptionD());
            ps.setString(6,question.getAnswer());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
    }

    @Override
    public List<Question> findQuestionList() {
        String sql = "select * from question";
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Question> questionList = new ArrayList<>();

        try{
            ps = DBUtil.getPreparedStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Integer id = rs.getInt(1);
                String title = rs.getString(2);
                String optionA = rs.getString(3);
                String optionB = rs.getString(4);
                String optionC = rs.getString(5);
                String optionD = rs.getString(6);
                String answer = rs.getString(7);
                Question question = new Question(id,title,optionA,optionB,optionC,optionD,answer);
                questionList.add(question);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs);
        }
        return questionList;
    }

    @Override
    public void deleteQuestion(String id) {
        String sql = "delete from question where id = ?";
        PreparedStatement ps = null;
        try {
            ps = DBUtil.getPreparedStatement(sql);
            ps.setInt(1,Integer.valueOf(id));
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }

    }

    @Override
    public Question findQuestionById(String id) {
        String sql = "select * from question where id = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Question question = null;
        try{
            ps = DBUtil.getPreparedStatement(sql);
            ps.setInt(1,Integer.valueOf(id));
            rs = ps.executeQuery();
            rs.next();
            String title = rs.getString(2);
            String optionA = rs.getString(3);
            String optionB = rs.getString(4);
            String optionC = rs.getString(5);
            String optionD = rs.getString(6);
            String answer = rs.getString(7);
            question = new Question(Integer.valueOf(id),title,optionA,optionB,optionC,optionD,answer);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs);
        }
        return question;
    }

    @Override
    public void updateQuestion(Question question) {
        //定义相关参数
        String sql = "update question set " +
                "title = ?, optionA = ?, optionB = ?, optionC = ?, optionD = ? ,answer = ?" +
                "where id = ?";
        PreparedStatement ps = null;

        //更新数据
        try{
            ps = DBUtil.getPreparedStatement(sql);
            ps.setString(1,question.getTitle());
            ps.setString(2,question.getOptionA());
            ps.setString(3,question.getOptionB());
            ps.setString(4,question.getOptionC());
            ps.setString(5,question.getOptionD());
            ps.setString(6,question.getAnswer());
            ps.setInt(7,question.getId());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }


    }
}
