package com.github.trojnartom.singinglessonscalendar.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name = "lessons")
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull (message = "Date is mandatory")
    private LocalDate date;

    @NotNull(message = "Time is mandatory")
    private LocalTime time;

    private Integer rating;

    private String comments;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;


}
