package com.campfour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CampController {

    @GetMapping("/camp")
    public String camp() {
        return "camp/campList";
    }
}

