package com.github.trojnartom.singinglessonscalendar.controller;

import com.github.trojnartom.singinglessonscalendar.model.LessonEntity;
import com.github.trojnartom.singinglessonscalendar.model.UserEntity;
import com.github.trojnartom.singinglessonscalendar.repository.LessonRepository;
import com.github.trojnartom.singinglessonscalendar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/panel/admin")
public class AdminAddDatesController {

    private final UserRepository userRepository;
    private final LessonRepository lessonRepository;

    @GetMapping("/add/{id}")
    public String adminAddDateView (@PathVariable Long id, Model model) {
        UserEntity user = userRepository.findUserById(id);
        LessonEntity lesson = new LessonEntity();
        model.addAttribute("user", user);
        model.addAttribute("lesson", lesson);

        return "/admin/adminAddDates";
    }

    @PostMapping("/add/{id}")
    public String adminAddData (@ModelAttribute("lesson") @Valid LessonEntity lesson, BindingResult result, @PathVariable Long id) {
        if(result.hasErrors()) {
            return "redirect:/panel/admin/list/" + id;
        }
        lesson.setId(lessonRepository.count()+1);
        lesson.setDate(lesson.getDate());
        lesson.setTime(lesson.getTime());
        lesson.setStatus(lesson.getStatus());
        lessonRepository.save(lesson);
        return "redirect:/panel/admin/add/" + id;
    }

}
