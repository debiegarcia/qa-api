package com.bit2bit.qaapi.domain.model.entity;

import com.bit2bit.qaapi.shared.domain.model.AuditModel;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
