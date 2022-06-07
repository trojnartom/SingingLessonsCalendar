package com.github.trojnartom.singinglessonscalendar.controller;

import com.github.trojnartom.singinglessonscalendar.model.UserEntity;
import com.github.trojnartom.singinglessonscalendar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/panel/admin")
public class AdminEditDataController {

    private final UserRepository userRepository;

    @GetMapping("/edit/{id}")
    public String userEditDataView(@PathVariable Long id, Model model) {
        UserEntity user = userRepository.findUserById(id);
        model.addAttribute("user", user);
        return "/admin/adminEditData";
    }

    @PostMapping("/edit")
    public String userEditData(@ModelAttribute("user") @Valid UserEntity user, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/panel/admin/edit/" + user.getId();
        }
        userRepository.save(user);
        return "redirect:/panel/admin/list/" + user.getId();
    }


}
