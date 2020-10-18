package com.dgpalife.dao;

import com.dgpalife.model.Question;

import java.util.List;

public interface TQuestionDao {

    void addQuestion(Question question);

    List<Question> findQuestion();

    void deleteQuestion(String id);

    Question findById(String id);

    void updateQuestion(Question question);

    List<Question> findRandQuestionList();
}
