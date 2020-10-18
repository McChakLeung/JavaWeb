package com.dgpalife.controller.exam;

import com.dgpalife.model.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ExamScoreServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取相关变量
        HttpSession session = req.getSession(false);
        List<Question> questionList = (List<Question>)session.getAttribute("questionList");
        Integer score = 0;

        //2.遍历questionList,判断所选择的答案是否与正确答案一致，并计算分数
        for (Question question:questionList) {
            //获取单个对象的ID
            Integer id = question.getId();
            //获取所选择的答案
            String answer = req.getParameter(String.valueOf(id));
            //判断所选的答案是否与正确答案一致
            if(question.getAnswer().equals(answer)){
                score += 40;
            }
        }

        //3.将分数返回至前端页面
        resp.setCharacterEncoding("gbk");
        resp.getWriter().write("您的分数为：" + score + "分");
    }
}
