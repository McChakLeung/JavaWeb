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
        String sql = "insert into question (title,optionA,optionB,optionC,optionD,answer) values (?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try{
            ps = DBUtil.getPrepardStatement(sql);
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
    public List<Question> findQuestion() {
        String sql = "select * from question";
        PreparedStatement ps = null;
        List<Question> questionList = new ArrayList<>();
        ResultSet rs = null;
        try{
            ps = DBUtil.getPrepardStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Integer id = rs.getInt("id");
                String title = rs.getString("title");
                String optionA = rs.getString("optionA");
                String optionB = rs.getString("optionB");
                String optionC = rs.getString("optionC");
                String optionD = rs.getString("optionD");
                String answer = rs.getString("answer");
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
        try{
            ps = DBUtil.getPrepardStatement(sql);
            ps.setInt(1,Integer.valueOf(id));
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }

    }

    @Override
    public Question findById(String id) {
        String sql = "select * from question where id = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Question question = null;
        try{
            ps = DBUtil.getPrepardStatement(sql);
            ps.setInt(1,Integer.valueOf(id));
            rs = ps.executeQuery();
            rs.next();
            String title = rs.getString("title");
            String optionA = rs.getString("optionA");
            String optionB = rs.getString("optionB");
            String optionC = rs.getString("optionC");
            String optionD = rs.getString("optionD");
            String answer = rs.getString("answer");
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
        String sql = "update question set " +
                "title = ?, optionA = ?, optionB = ?, optionC = ?, optionD = ?, answer = ?" +
                "where id = ?";
        PreparedStatement ps = null;

        try{
            ps = DBUtil.getPrepardStatement(sql);
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
    public List<Question> findRandomQuestionList() {
        String sql = "select * from question order by rand() limit 3";
        PreparedStatement ps = null;
        List<Question> questionList = new ArrayList<>();
        ResultSet rs = null;
        try{
            ps = DBUtil.getPrepardStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Integer id = rs.getInt("id");
                String title = rs.getString("title");
                String optionA = rs.getString("optionA");
                String optionB = rs.getString("optionB");
                String optionC = rs.getString("optionC");
                String optionD = rs.getString("optionD");
                String answer = rs.getString("answer");
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
