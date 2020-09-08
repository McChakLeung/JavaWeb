package com.dgpalife.dao;

import com.dgpalife.model.Question;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface TQuestionDao {
    void addQuestion(Question question, HttpServletRequest request);

    int deleteQuestion(Integer id);

    Question findQuestionByID(Integer id);

    List<Question> findQuestion(HttpServletRequest request);

    int updateQuestion(Question question);
}
