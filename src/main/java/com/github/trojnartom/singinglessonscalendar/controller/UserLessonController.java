package com.github.trojnartom.singinglessonscalendar.controller;

import com.github.trojnartom.singinglessonscalendar.model.LessonEntity;
import com.github.trojnartom.singinglessonscalendar.model.UserEntity;
import com.github.trojnartom.singinglessonscalendar.repository.LessonRepository;
import com.github.trojnartom.singinglessonscalendar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/panel/user")
public class UserLessonController {

    private final UserRepository userRepository;
    private final LessonRepository lessonRepository;

    @GetMapping("/lesson/{lessonId}")
    public String userLessonView (Model model, @PathVariable Long lessonId) {
        UserEntity user = userRepository.findUserById(lessonRepository.findLessonEntitiesById(lessonId).getUser().getId());
        model.addAttribute("user", userRepository.findUserById(lessonRepository.findLessonEntitiesById(lessonId).getUser().getId()));
        model.addAttribute("lesson", lessonRepository.findLessonEntitiesById(lessonId));
        return "/user/userLesson";
    }

    @PostMapping("/lesson/{id}")
    public String userLessonData(@ModelAttribute("lesson") @Valid LessonEntity lesson, @PathVariable Long id) {
        lesson.setRating(lesson.getRating());
        lessonRepository.save(lesson);

        return "redirect:/panel/user/list/" + lesson.getUser().getId();
    }


}
