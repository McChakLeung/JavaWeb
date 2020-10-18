package com.dgpalife.dao;

import com.dgpalife.model.Question;

import java.util.List;

public interface TQuestionDao {

    void addQuestion(Question question);

    Integer getTotalRecord();

    List<Question> findQuestionListWithPage(Integer startLine, Integer pageSize);

    Question findQuestionByID(Integer id);

    void updateQuestion(Question question);

    void deleteQuestion(Integer id);
}
