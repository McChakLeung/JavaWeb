package com.dgpalife.service;

import com.dgpalife.model.Question;

import java.util.List;

public interface QuestionService {
    List<Question> findRandQuestionList();
}
