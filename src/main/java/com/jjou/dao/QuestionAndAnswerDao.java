package com.jjou.dao;

import com.jjou.domain.QuestionAndAnswer;

import java.util.List;

/**
 * Description:
 *
 * @Author ojj
 * @Create 2023/12/27 13:41
 * @version 1.0
 */
public interface QuestionAndAnswerDao {

    List<QuestionAndAnswer> selectList();

    int insert(QuestionAndAnswer req);
}
