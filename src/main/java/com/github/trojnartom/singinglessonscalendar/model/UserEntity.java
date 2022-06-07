package com.github.trojnartom.singinglessonscalendar.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3)
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Size(min = 3)
    @Column(name = "last_name")
    private String lastName;

    @Email
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "role")
    private String role;

    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "enable")
    private boolean enable;

}
