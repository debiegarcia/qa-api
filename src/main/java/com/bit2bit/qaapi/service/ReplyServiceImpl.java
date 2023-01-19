package com.bit2bit.qaapi.service;

import com.bit2bit.qaapi.domain.model.entity.Reply;
import com.bit2bit.qaapi.domain.persistence.QuestionRepository;
import com.bit2bit.qaapi.domain.persistence.ReplyRepository;
import com.bit2bit.qaapi.domain.persistence.UserRepository;
import com.bit2bit.qaapi.domain.service.ReplyService;
import com.bit2bit.qaapi.shared.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    private final static String ENTITY = "Reply";
    private final static String ENTITY2 = "User";
    private final static String ENTITY3 = "Question";

    private final ReplyRepository replyRepository;
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;

    public ReplyServiceImpl(ReplyRepository replyRepository, UserRepository userRepository, QuestionRepository questionRepository) {
        this.replyRepository = replyRepository;
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Reply> getAll() {
        return replyRepository.findAll();
    }

    @Override
    public List<Reply> getAllByQuestionId(Long questionId) {
        return replyRepository.findByQuestionIdOrderByCreatedAtDesc(questionId);
    }

    @Override
    public Reply getById(Long replyId) {
        return replyRepository.findById(replyId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, replyId));
    }

    @Override
    public Reply create(Reply request, Long userId, Long questionId) {
        var user = userRepository.findById(userId);
        if(user.isEmpty())
            throw new ResourceNotFoundException(ENTITY2, userId);

        var question = questionRepository.findById(questionId);
        if(question.isEmpty())
            throw new ResourceNotFoundException(ENTITY3, questionId);

        try{
            request.setUser(user.get());
            request.setQuestion(question.get());
            return replyRepository.save(request);
        }
        catch (Exception e){
            throw new ResourceNotFoundException("An error occurred while creating the reply");
        }
    }

    @Override
    public Reply update(Long replyId, Reply request) {
        return replyRepository.findById(replyId)
                .map(reply -> replyRepository.save(
                        reply.withContent(request.getContent())
                )).orElseThrow(() -> new ResourceNotFoundException(ENTITY, replyId));
    }

    @Override
    public Reply delete(Long replyId) {
        return replyRepository.findById(replyId)
                .map(reply -> {
                    replyRepository.delete(reply);
                    return reply;
                }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, replyId));
    }
}
