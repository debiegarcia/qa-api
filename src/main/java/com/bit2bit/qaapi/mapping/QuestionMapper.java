package com.bit2bit.qaapi.mapping;

import com.bit2bit.qaapi.domain.model.entity.Question;
import com.bit2bit.qaapi.resource.CreateQuestionResource;
import com.bit2bit.qaapi.resource.QuestionResource;
import com.bit2bit.qaapi.resource.UpdateQuestionResource;
import com.bit2bit.qaapi.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class QuestionMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper mapper;

    public QuestionResource toResource(Question model){
        return mapper.map(model, QuestionResource.class);
    }

    public List<QuestionResource> toResource(List<Question> model){
        return mapper.mapList(model, QuestionResource.class);
    }

    public Question toModel(CreateQuestionResource resource){
        return mapper.map(resource, Question.class);
    }

    public Question toModel(UpdateQuestionResource resource){
        return mapper.map(resource, Question.class);
    }
}
