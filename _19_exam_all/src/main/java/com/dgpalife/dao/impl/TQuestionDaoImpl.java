package com.dgpalife.dao.impl;

import com.dgpalife.dao.TQuestionDao;
import com.dgpalife.model.Question;
import com.dgpalife.util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TQuestionDaoImpl implements TQuestionDao {
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
    public Integer getTotalRecord() {
        String sql = "select count(*) from question";
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
    public List<Question> findQuestionListWithPage(Integer startLine, Integer pageSize) {
        String sql = "select * from question limit ?,?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Question> questionList = new ArrayList<>();
        try{
            ps = DBUtil.getPreparedStatement(sql);
            ps.setInt(1,startLine);
            ps.setInt(2,pageSize);
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
    public Question findQuestionByID(Integer id) {
        String sql = "select * from question where id = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Question question = null;
        try{
            ps = DBUtil.getPreparedStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            rs.next();
            String title = rs.getString(2);
            String optionA = rs.getString(3);
            String optionB = rs.getString(4);
            String optionC = rs.getString(5);
            String optionD = rs.getString(6);
            String answer = rs.getString(7);
            question = new Question(id,title,optionA,optionB,optionC,optionD,answer);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs);
        }
        return question;
    }

    @Override
    public void updateQuestion(Question question) {
        String sql = "update question set " +
                "title = ?, optionA = ?, optionB = ?, optionC = ?, optionD = ?, answer = ? " +
                "where id = ?";
        PreparedStatement  ps = null;
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

    @Override
    public void deleteQuestion(Integer id) {
        String sql = "delete from question where id = ?";
        PreparedStatement ps = null;
        try{
            ps = DBUtil.getPreparedStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
    }

    @Override
    public List<Question> findRandomQuestionList() {
        String sql = "select * from question order by rand() limit 3";
        PreparedStatement ps = DBUtil.getPreparedStatement(sql);
        ResultSet rs = null;
        List<Question> questionList = new ArrayList<>();
        try{
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
}
