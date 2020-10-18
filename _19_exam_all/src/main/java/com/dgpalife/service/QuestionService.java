package com.dgpalife.service;

import com.dgpalife.model.Question;
import com.dgpalife.util.PageBean;

import java.util.List;

public interface QuestionService {

    void addQuestion(Question question);

    PageBean<Question> findQuestionListWithPage(Integer pageNum, Integer pageSize);

    Question findQuestionByID(Integer id);

    void updateQuestion(Question question);

    void deleteQuestion(Integer id);
}
