package com.bit2bit.qaapi.service;

import com.bit2bit.qaapi.domain.model.entity.Question;
import com.bit2bit.qaapi.domain.persistence.QuestionRepository;
import com.bit2bit.qaapi.domain.persistence.UserRepository;
import com.bit2bit.qaapi.domain.service.QuestionService;
import com.bit2bit.qaapi.shared.exception.ResourceNotFoundException;
import com.bit2bit.qaapi.shared.exception.ResourceValidationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final static String ENTITY = "Question";
    private final static String ENTITY2 = "User";

    private final QuestionRepository questionRepository;

    private final UserRepository userRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository, UserRepository userRepository) {
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> getAllByTitle(String title) {
        return questionRepository.findByTitleContainingOrderByCreatedAtDesc(title);
    }

    @Override
    public List<Question> getAllOrderByPublishedDate() {
        return questionRepository.findAllByOrderByCreatedAtDesc();
    }

    @Override
    public List<Question> getAllByLikes() {
        return questionRepository.findAllByOrderByLikesDesc();
    }

    @Override
    public Question getById(Long questionId) {
        return questionRepository.findById(questionId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, questionId));
    }

    @Override
    public Question create(Question request, Long userId) {
        var user = userRepository.findById(userId);
        if(user.isEmpty())
                throw new ResourceNotFoundException(ENTITY2, userId);

        try{
            request.setUser(user.get());
            return questionRepository.save(request);
        }
        catch (Exception e){
            throw new ResourceValidationException("An error occurred while creating the question");
        }
    }

    @Override
    public Question update(Long questionId, Question request) {
        return questionRepository.findById(questionId)
                .map(question -> questionRepository.save(
                        question.withTitle(request.getTitle())
                                .withDescription(request.getDescription())
                )).orElseThrow(() -> new ResourceNotFoundException(ENTITY, questionId));
    }

    @Override
    public Question delete(Long questionId) {
        return questionRepository.findById(questionId)
                .map(question -> {
                    questionRepository.delete(question);
                    return question;
                }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, questionId));
    }
}
