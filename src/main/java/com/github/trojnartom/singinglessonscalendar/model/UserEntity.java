package com.github.trojnartom.singinglessonscalendar.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Length(min = 3)
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Length(min = 3)
    @Column(name = "last_name")
    private String lastName;

    @UniqueElements
    @NotBlank
    @Email
    private String email;

    @UniqueElements
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotNull
    @Column(name = "role")
    private String role;

    @NotNull
    @Column(name = "password")
    private String password;
}
