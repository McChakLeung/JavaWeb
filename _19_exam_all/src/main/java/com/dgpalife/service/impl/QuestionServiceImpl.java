package com.dgpalife.service.impl;

import com.dgpalife.dao.TQuestionDao;
import com.dgpalife.dao.impl.TQuestionDaoImpl;
import com.dgpalife.model.Question;
import com.dgpalife.service.QuestionService;
import com.dgpalife.util.PageBean;

import java.util.List;


public class QuestionServiceImpl implements QuestionService {

    private TQuestionDao questionDao = new TQuestionDaoImpl();

    @Override
    public void addQuestion(Question question) {
        questionDao.addQuestion(question);
    }

    @Override
    public PageBean<Question> findQuestionListWithPage(Integer pageNum, Integer pageSize) {

        //1.计算总记录数
        Integer totalRecord = questionDao.getTotalRecord();

        //2.定义PageBean,并初始化pageBean
        PageBean<Question> pageBean = new PageBean(pageNum,pageSize,totalRecord);

        //3.查询单页数据
        Integer startLine = pageBean.getStartLine();
        List<Question> questionList = questionDao.findQuestionListWithPage(startLine,pageSize);

        //4.将数据组装到pageBean
        pageBean.setDataList(questionList);

        //5.返回至前端
        return pageBean;
    }

    @Override
    public Question findQuestionByID(Integer id) {
        return questionDao.findQuestionByID(id);
    }

    @Override
    public void updateQuestion(Question question) {
        questionDao.updateQuestion(question);
    }

    @Override
    public void deleteQuestion(Integer id) {
        questionDao.deleteQuestion(id);
    }

    @Override
    public List<Question> findRandomQuestionList() {
        return questionDao.findRandomQuestionList();
    }
}
