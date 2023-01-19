package com.bit2bit.qaapi.resource;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@Setter
public class CreateQuestionResource {

    @NotNull
    @NotBlank
    @Length(max = 250)
    private String title;

    @NotNull
    @NotBlank
    @Length(max = 1000)
    private String description;

    @NotNull
    private Integer likes;
}
