package com.github.trojnartom.singinglessonscalendar.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
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
    @Min(3)
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Min(3)
    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @Email
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @NotBlank
    @Max(1)
    @Column(name = "is_admin")
    private String isAdmin;
}
