package com.github.trojnartom.singinglessonscalendar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserListController {

    @GetMapping("/panel/user/list")
    public String userLessonsListView() {
        return "/user/userLessonsList";
    }
}
