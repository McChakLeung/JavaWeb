package com.dgpalife.dao;

import com.dgpalife.model.Question;

import java.util.List;

public interface TQuestionDao {

    void addQuestion(Question question);

    List<Question> findQuestionList();

    void deleteQuestion(String id);

    Question findQuestionById(String id);

    void updateQuestion(Question question);
}
