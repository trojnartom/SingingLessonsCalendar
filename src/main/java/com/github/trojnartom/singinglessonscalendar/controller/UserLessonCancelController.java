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
@RequestMapping("/panel/user/")
@RequiredArgsConstructor
public class UserLessonCancelController {

    private final LessonRepository lessonRepository;
    private final UserRepository userRepository;


    @GetMapping("/cancel/{id}")
    public String userLessonCancelView(Model model, @PathVariable Long id) {
        LessonEntity lesson = lessonRepository.findLessonEntitiesById(id);
        UserEntity user = userRepository.findUserById(lesson.getUser().getId());
        model.addAttribute("lesson", lesson);
        model.addAttribute("user", user);
        return "/user/userLessonCancel";
    }

    @PostMapping("/cancel/{userId}/{id}")
    public String userLessonCancelData(@ModelAttribute("lesson") @Valid LessonEntity lesson, BindingResult result, @PathVariable Long id, @PathVariable Long userId) {
        if (result.hasErrors()) {
            return "redirect:/panel/user/cancel/" + userId + id;
        }

        LessonEntity lessonEntity = lessonRepository.findLessonEntitiesById(lesson.getId());
        lessonEntity.setStatus("Utworzona");
        lessonEntity.setUser(null);
        lessonRepository.save(lessonEntity);

        return "redirect:/panel/user/list/" + userId;
    }


}
