package com.github.trojnartom.singinglessonscalendar.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
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
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class LessonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private LocalTime time;

    @PositiveOrZero
    @Min(1) @Max(10)
    private Integer rating;
    private String comments;

    @NotBlank
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public String getFullTime() {
        return this.getDate() + " " + this.getTime();
    }

//    @NotNull
//    @Size(min = 30, max = 60)
//    private Integer duration;

}
