package com.bit2bit.qaapi.domain.service;

import com.bit2bit.qaapi.domain.model.entity.Reply;

import java.util.List;

public interface ReplyService {

    List<Reply> getAll();
    List<Reply> getAllByQuestionId(Long questionId);
    Reply getById(Long replyId);
    Reply create(Reply reply, Long userId, Long questionId);
    Reply update(Long replyId, Reply reply);
    Reply delete(Long replyId);
}
