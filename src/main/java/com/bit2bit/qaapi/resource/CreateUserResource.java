package com.bit2bit.qaapi.resource;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class CreateUserResource {

    @NotNull
    @NotBlank
    @Email
    private String email;

    @NotNull
    @NotBlank
    @Length(min = 8, max = 16)
    private String password;

    @NotNull
    @NotBlank
    @Length(max = 50)
    private String firstName;

    @NotNull
    @NotBlank
    @Length(max = 50)
    private String lastName;

    private LocalDate birthDate;
}
