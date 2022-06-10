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

@Controller
@RequestMapping("/panel/admin/")
@RequiredArgsConstructor
public class AdminLessonDetailsController {

    private final LessonRepository lessonRepository;
    private final UserRepository userRepository;

    @GetMapping("/details/{id}")
    public String userLessonCancelView(Model model, @PathVariable Long id) {
        LessonEntity lesson = lessonRepository.findLessonEntitiesById(id);
        UserEntity user = userRepository.findUserById(lesson.getUser().getId());
        model.addAttribute("lesson", lesson);
        model.addAttribute("user", user);
        return "/admin/adminLessonDetails";
    }
}
