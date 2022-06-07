package com.github.trojnartom.singinglessonscalendar;

import com.github.trojnartom.singinglessonscalendar.model.LessonEntity;
import com.github.trojnartom.singinglessonscalendar.model.UserEntity;
import com.github.trojnartom.singinglessonscalendar.repository.LessonRepository;
import com.github.trojnartom.singinglessonscalendar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@ConditionalOnProperty(name = "spring.jpa.hibernate.ddl-auto", havingValue = "create-drop")
@Component
@Slf4j
@RequiredArgsConstructor
public class TestDataLoader {

    private final UserRepository userRepository;
    private final LessonRepository lessonRepository;

    @EventListener
    @Transactional
    public void loadData(ContextRefreshedEvent event) {
        log.debug("Loading data...");

        userRepository.save(UserEntity.builder()
                .firstName("Tomasz")
                .lastName("Trojnar")
                .email("trojnar.t@gmail.com")
                .password("123")
                .role("ADMIN")
                .enable(true)
                .build());
        userRepository.save(UserEntity.builder()
                .firstName("Natalia")
                .lastName("Trojnar")
                .email("ncieslachowska@gmail.com")
                .password("456")
                .role("USER")
                .enable(true)
                .build());

        userRepository.save(UserEntity.builder()
                .firstName("Maria")
                .lastName("Trojnar")
                .email("mariatrojnar@hotmail.com")
                .password("888")
                .role("USER")
                .enable(false)
                .build());

        lessonRepository.save(LessonEntity.builder()
                .date(LocalDate.parse("2022-07-03"))
                .time(LocalTime.parse("17:00"))
                .status("Zarezerwowana")
                .user(userRepository.findUserById(1L))
                .build());
        lessonRepository.save(LessonEntity.builder()
                .date(LocalDate.parse("2022-07-27"))
                .time(LocalTime.parse("18:00"))
                .status("Zarezerwowana")
                .user(userRepository.findUserById(2L))
                .build());
        lessonRepository.save(LessonEntity.builder()
                .date(LocalDate.parse("2022-10-03"))
                .time(LocalTime.parse("15:00"))
                .status("Utworzona")
                .build());
        lessonRepository.save(LessonEntity.builder()
                .date(LocalDate.parse("2022-10-03"))
                .time(LocalTime.parse("16:00"))
                .status("Utworzona")
                .build());
        lessonRepository.save(LessonEntity.builder()
                .date(LocalDate.parse("2022-10-03"))
                .time(LocalTime.parse("17:00"))
                .status("Utworzona")
                .build());
        lessonRepository.save(LessonEntity.builder()
                .date(LocalDate.parse("2022-12-03"))
                .time(LocalTime.parse("16:00"))
                .status("Utworzona")
                .build());
        lessonRepository.save(LessonEntity.builder()
                .date(LocalDate.parse("2022-03-17"))
                .time(LocalTime.parse("17:30"))
                .status("Oczekuje na komentarz")
                .user(userRepository.findUserById(1L))
                .build());
        lessonRepository.save(LessonEntity.builder()
                .date(LocalDate.parse("2022-02-17"))
                .time(LocalTime.parse("17:30"))
                .status("Zakończona")
                .comments("Tutaj już jest komentarz")
                .user(userRepository.findUserById(2L))
                .build());
        log.debug("Data added succesfully");
    }
}
