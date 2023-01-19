package com.bit2bit.qaapi.mapping;

import com.bit2bit.qaapi.domain.model.entity.Reply;
import com.bit2bit.qaapi.resource.CreateReplyResource;
import com.bit2bit.qaapi.resource.ReplyResource;
import com.bit2bit.qaapi.resource.UpdateReplyResource;
import com.bit2bit.qaapi.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class ReplyMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper mapper;

    public ReplyResource toResource(Reply model){
        return mapper.map(model, ReplyResource.class);
    }

    public List<ReplyResource> toResource(List<Reply> model){
        return mapper.mapList(model, ReplyResource.class);
    }

    public Reply toModel(CreateReplyResource resource){
        return mapper.map(resource, Reply.class);
    }

    public Reply toModel(UpdateReplyResource resource){
        return mapper.map(resource, Reply.class);
    }
}
