package com.github.trojnartom.singinglessonscalendar.service;

import com.github.trojnartom.singinglessonscalendar.model.LessonEntity;
import com.github.trojnartom.singinglessonscalendar.repository.LessonRepository;
import com.github.trojnartom.singinglessonscalendar.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class LessonReserveService {

    private final UserRepository userRepository;
    private final LessonRepository lessonRepository;

    @Transactional
    @Modifying
    public void modifyLessonReserve(Long userId, Long lessonId) {
        LessonEntity lesson = lessonRepository.findLessonByLessonId(lessonId);
        lesson.setUser(userRepository.findUserById(userId));
        lesson.setStatus("Zarezerwowana");
        lessonRepository.save(lesson);
    }
}
