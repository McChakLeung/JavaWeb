package com.dgpalife.dao.impl;

import com.dgpalife.dao.TQuestionDao;
import com.dgpalife.model.Question;
import com.dgpalife.util.DBUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TQuestionDaoImpl implements TQuestionDao {
    @Override
    public void addQuestion(Question question, HttpServletRequest request) {
        String sql = "insert into question (title,optionA,optionB,optionC,optionD,answer) value (?,?,?,?,?,?)";
        try{
            PreparedStatement ps = DBUtil.createPreparedStatement(sql,request);
            ps.setString(1,question.getTitle());
            ps.setString(2,question.getOptionA());
            ps.setString(3,question.getOptionB());
            ps.setString(4,question.getOptionC());
            ps.setString(5,question.getOptionD());
            ps.setString(6,question.getAnswer());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int deleteQuestion(Integer id) {
        int flag = 0;
        String sql = "delete from question where id = ?";
        try{
            PreparedStatement ps = DBUtil.createPreparedStatement(sql);
            ps.setInt(1,id);
            flag = ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Question findQuestionByID(Integer id) {
        String sql = "select * from question where id = ?";
        Question question = new Question();
        try{
            PreparedStatement ps = DBUtil.createPreparedStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            rs.next();
            question.setId(rs.getInt("id"));
            question.setTitle(rs.getString("title"));
            question.setOptionA(rs.getString("optionA"));
            question.setOptionB(rs.getString("optionB"));
            question.setOptionC(rs.getString("optionC"));
            question.setOptionD(rs.getString("optionD"));
            question.setAnswer(rs.getString("answer"));

        }catch (Exception e){
            e.printStackTrace();
        }
        return question;
    }

    @Override
    public List<Question> findQuestion(HttpServletRequest request) {
        String sql = "select * from question";
        List<Question> list = new ArrayList<>();
        try{
            PreparedStatement ps = DBUtil.createPreparedStatement(sql,request);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Question question = new Question();
                question.setId(rs.getInt("id"));
                question.setTitle(rs.getString("title"));
                question.setOptionA(rs.getString("optionA"));
                question.setOptionB(rs.getString("optionB"));
                question.setOptionC(rs.getString("optionC"));
                question.setOptionD(rs.getString("optionD"));
                question.setAnswer(rs.getString("answer"));
                list.add(question);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int updateQuestion(Question question) {
        String sql = "update question set title = ?, optionA = ?, optionB = ?, optionC = ?" +
                "optionD = ?, answer = ? where id = ?";
        int flag = 0;

        try{
            PreparedStatement ps = DBUtil.createPreparedStatement(sql);
            ps.setString(1,question.getTitle());
            ps.setString(2,question.getOptionA());
            ps.setString(3,question.getOptionB());
            ps.setString(4,question.getOptionC());
            ps.setString(5,question.getOptionD());
            ps.setString(6,question.getAnswer());
            ps.setInt(7,question.getId());
            flag = ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
