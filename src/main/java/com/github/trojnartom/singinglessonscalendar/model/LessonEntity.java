package com.github.trojnartom.singinglessonscalendar.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name = "lessons")
@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class LessonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private LocalTime time;
    private Integer rating;
    private String comments;
    private String status;

    public String getFullTime() {
        return this.getDate() + " " + this.getTime();
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

//    @NotNull
//    @Size(min = 30, max = 60)
//    private Integer duration;

}
