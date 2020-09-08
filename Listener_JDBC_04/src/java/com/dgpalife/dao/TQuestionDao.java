package com.dgpalife.dao;

import com.dgpalife.model.Question;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface TQuestionDao {

    List<Question> findQuestionList(HttpServletRequest request);

    void addQuestion(Question question, HttpServletRequest request);

}
