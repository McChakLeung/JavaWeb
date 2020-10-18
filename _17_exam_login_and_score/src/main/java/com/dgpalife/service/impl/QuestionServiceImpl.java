package com.dgpalife.service.impl;

import com.dgpalife.dao.TQuestionDao;
import com.dgpalife.dao.impl.TQuestionDaoImpl;
import com.dgpalife.model.Question;
import com.dgpalife.service.QuestionService;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {

    private TQuestionDao questionDao = new TQuestionDaoImpl();

    @Override
    public List<Question> findRandomQuestionList() {
        return questionDao.findRandomQuestionList();
    }
}
