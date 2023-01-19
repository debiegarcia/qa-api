package com.bit2bit.qaapi.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class QuestionResource {

    private Long id;
    private String title;
    private String description;
    private Integer likes;
    private Date createdAt;
    private Date updatedAt;
    private UserResource user;
}
