package com.bit2bit.qaapi.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("qaMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public UserMapper userMapper(){
        return new UserMapper();
    }

    @Bean
    public QuestionMapper questionMapper(){
        return new QuestionMapper();
    }

    @Bean
    public ReplyMapper replyMapper(){
        return new ReplyMapper();
    }
}
