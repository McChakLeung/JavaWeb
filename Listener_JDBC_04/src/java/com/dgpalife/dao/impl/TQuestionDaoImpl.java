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
    public List<Question> findQuestionList(HttpServletRequest request) {
        String sql = "select * from question";
        ResultSet rs = null;
        List<Question> questionList = new ArrayList<>();
        PreparedStatement ps = DBUtil.getPrepardStatement(sql,request);
        try{
           rs = ps.executeQuery();
           while(rs.next()){
               Question question = new Question();
               question.setId(rs.getInt("id"));
               question.setTitle(rs.getString("title"));
               question.setOptionA(rs.getString("optionA"));
               question.setOptionB(rs.getString("optionB"));
               question.setOptionC(rs.getString("optionC"));
               question.setOptionD(rs.getString("optionD"));
               question.setAnswer(rs.getString("answer"));
               questionList.add(question);
           }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,request);
        }
        return questionList;
    }

    @Override
    public void addQuestion(Question question, HttpServletRequest request) {
        String sql = "insert into question (title,optionA,optionB,optionC,optionD,answer) value (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = DBUtil.getPrepardStatement(sql, request);
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
            DBUtil.close(null,request);
        }

    }
}
