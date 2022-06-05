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

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/panel/user")
@RequiredArgsConstructor
public class UserListController {

    private final UserRepository userRepository;
    private final LessonRepository lessonRepository;


    @GetMapping("/list/{id}")
    public String userLessonsListView(@PathVariable Long id, Model model) {
        UserEntity user = userRepository.findUserById(id);
        List<LessonEntity> lessons = lessonRepository.findAllByUserId(id);
        model.addAttribute("user", user);
        model.addAttribute("lessons", lessons);
        return "/user/userLessonsList";
    }

}
