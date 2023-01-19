package com.bit2bit.qaapi.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ReplyResource {

    private Long id;
    private String content;
    private Date createdAt;
    private Date updatedAt;
    private UserResource user;
    private QuestionResource question;

}
