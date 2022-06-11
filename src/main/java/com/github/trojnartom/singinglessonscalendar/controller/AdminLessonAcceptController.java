package com.github.trojnartom.singinglessonscalendar.controller;

import com.github.trojnartom.singinglessonscalendar.model.LessonEntity;
import com.github.trojnartom.singinglessonscalendar.model.UserEntity;
import com.github.trojnartom.singinglessonscalendar.repository.LessonRepository;
import com.github.trojnartom.singinglessonscalendar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/panel/admin")
public class AdminLessonAcceptController {

    private final UserRepository userRepository;
    private final LessonRepository lessonRepository;

    @GetMapping("/accept/{lessonId}")
    public String userLessonView (Model model, @PathVariable Long lessonId) {
        UserEntity user = userRepository.findUserById(lessonRepository.findLessonEntitiesById(lessonId).getUser().getId());
        model.addAttribute("user", userRepository.findUserById(lessonRepository.findLessonEntitiesById(lessonId).getUser().getId()));
        model.addAttribute("lesson", lessonRepository.findLessonEntitiesById(lessonId));
        return "/admin/adminAcceptLesson";
    }

    @PostMapping("/accept/{id}")
    public String userLessonData(@ModelAttribute("lesson") @Valid LessonEntity lesson, BindingResult result, @PathVariable Long id) {
        if(result.hasErrors()) {
            return "redirect:/panel/admin/accept/" + id;
        }
        lesson.setStatus("Oczekuje na komentarz");
        lessonRepository.save(lesson);

        return "redirect:/panel/admin/list/" + lesson.getUser().getId();
    }
}
