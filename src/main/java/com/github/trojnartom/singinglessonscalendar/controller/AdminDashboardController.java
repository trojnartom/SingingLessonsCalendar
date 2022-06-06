package com.github.trojnartom.singinglessonscalendar.controller;

import com.github.trojnartom.singinglessonscalendar.model.LessonEntity;
import com.github.trojnartom.singinglessonscalendar.model.UserEntity;
import com.github.trojnartom.singinglessonscalendar.repository.LessonRepository;
import com.github.trojnartom.singinglessonscalendar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/panel/admin")
public class AdminDashboardController {

    private final UserRepository userRepository;
    private final LessonRepository lessonRepository;

    @GetMapping("/dashboard/{id}")
    public String adminLessonsListView(@PathVariable Long id, Model model) {
        UserEntity user = userRepository.findUserById(id);
        List<LessonEntity> lessons = lessonRepository.findAllByStatus("Zarezerwowana").stream()
                .sorted(Comparator.comparing(LessonEntity::getDate))
                .collect(Collectors.toList());
        model.addAttribute("user", user);
        model.addAttribute("lessons", lessons);

        return "admin/adminDashboard";
    }
}
