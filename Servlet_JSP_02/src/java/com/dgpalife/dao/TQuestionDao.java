package com.dgpalife.dao;

import com.dgpalife.model.Question;

import java.util.List;

public interface TQuestionDao {

    List<Question> findQuestionList();

    void addQuestion(Question question);
}
