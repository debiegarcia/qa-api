package com.bit2bit.qaapi.mapping;

import com.bit2bit.qaapi.domain.model.entity.User;
import com.bit2bit.qaapi.resource.CreateUserResource;
import com.bit2bit.qaapi.resource.UpdateUserResource;
import com.bit2bit.qaapi.resource.UserResource;
import com.bit2bit.qaapi.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class UserMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper mapper;

    public UserResource toResource(User model){
        return mapper.map(model, UserResource.class);
    }

    public List<UserResource> toResource(List<User>model){
        return mapper.mapList(model, UserResource.class);
    }

    public User toModel(CreateUserResource resource){
        return mapper.map(resource, User.class);
    }

    public User toModel(UpdateUserResource resource){
        return mapper.map(resource, User.class);
    }
}
