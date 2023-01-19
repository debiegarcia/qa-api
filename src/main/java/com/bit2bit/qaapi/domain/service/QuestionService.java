package com.bit2bit.qaapi.domain.service;

import com.bit2bit.qaapi.domain.model.entity.Question;

import java.util.List;

public interface QuestionService {

    List<Question> getAll();
    List<Question> getAllByTitle(String title);
    List<Question> getAllOrderByPublishedDate();
    List<Question> getAllByLikes();
    Question getById(Long questionId);
    Question create (Question question, Long userId);
    Question update (Long questionId, Question question);
    Question delete (Long questionId);

}
