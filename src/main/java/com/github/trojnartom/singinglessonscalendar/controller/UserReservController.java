package com.github.trojnartom.singinglessonscalendar.controller;

import com.github.trojnartom.singinglessonscalendar.model.LessonEntity;
import com.github.trojnartom.singinglessonscalendar.model.UserEntity;
import com.github.trojnartom.singinglessonscalendar.repository.LessonRepository;
import com.github.trojnartom.singinglessonscalendar.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/panel/user/")
@RequiredArgsConstructor
public class UserReservController {

    private final LessonRepository lessonRepository;
    private final UserRepository userRepository;


    @GetMapping("/reserv/{id}")
    public String userReservView (@PathVariable Long id, Model model) {
        UserEntity user = userRepository.findUserById(id);
        List<LessonEntity> lessons = lessonRepository.findAllByStatus("Utworzona");
        model.addAttribute("lessons", lessons);
        model.addAttribute("user", user);
        return "/user/userReserv";
    }



    @PostMapping("/reserv")
    public String userReservData (@ModelAttribute("lessons") LessonEntity lessons, BindingResult result) {
        UserEntity user = userRepository.findUserById(1L);
        if (result.hasErrors()) {
            return "redirect:/panel/user/reserv/" + user.getId();
        }
        lessons.setUser(user);
        lessons.setComments("Zarezerwowano");
        lessonRepository.save(lessons);

        return "redirect:/panel/user/list/" + user.getId();
    }
}
